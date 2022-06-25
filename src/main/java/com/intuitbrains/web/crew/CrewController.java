/*
 * Copyright 2012-2013 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.intuitbrains.web.crew;

import java.io.*;
import java.math.BigDecimal;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.*;
import java.util.stream.Collectors;

import javax.servlet.http.HttpServletRequest;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.intuitbrains.common.AuditTrail;
import com.intuitbrains.common.Collection;
import com.intuitbrains.common.Flag;
import com.intuitbrains.dao.common.*;
import com.intuitbrains.dao.company.EmployeeRepository;
import com.intuitbrains.dao.crew.CrewContractRepository;
import com.intuitbrains.dao.vessel.VesselRepository;
import com.intuitbrains.dao.vessel.VesselVacancyRepository;
import com.intuitbrains.model.common.Duration;
import com.intuitbrains.model.common.DurationType;
import com.intuitbrains.model.common.document.*;
import com.intuitbrains.model.common.document.category.DocumentCategory;
import com.intuitbrains.model.common.document.category.DocumentPool;
import com.intuitbrains.model.common.document.category.DocumentType;
import com.intuitbrains.model.crew.CrewDocument;
import com.intuitbrains.model.company.Employee;
import com.intuitbrains.model.crew.*;
import com.intuitbrains.model.crew.contract.CrewContract;
import com.intuitbrains.model.vessel.Vessel;
import com.intuitbrains.model.vessel.Vacancy;
import com.intuitbrains.service.common.ContractDocumentGenerator;
import com.intuitbrains.service.crew.CrewService;
import com.intuitbrains.service.vessel.VesselService;
import com.intuitbrains.util.*;
import com.mongodb.BasicDBObject;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;
import com.mongodb.client.model.Updates;
import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.engine.export.JRPdfExporter;
import net.sf.jasperreports.export.SimpleExporterInput;
import net.sf.jasperreports.export.SimpleOutputStreamExporterOutput;
import net.sf.jasperreports.export.SimplePdfExporterConfiguration;
import net.sf.jasperreports.export.SimplePdfReportConfiguration;
import org.apache.commons.io.FileUtils;
import org.apache.poi.openxml4j.opc.OPCPackage;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.bson.BsonBinarySubType;
import org.bson.conversions.Bson;
import org.bson.types.Binary;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTBody;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.Resource;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.intuitbrains.dao.crew.PhotoRepository;
import com.intuitbrains.service.common.SequenceGeneratorService;

import static java.util.Comparator.comparing;

@RestController
@RequestMapping(value = "/crew")
public class CrewController {
    @Autowired
    private PhotoRepository photoDao;
    @Autowired
    private SequenceGeneratorService sequenceGenerator;
    @Autowired
    private CrewDocumentRepository documentDao;
    @Autowired
    private DocumentTypeRepository docTypeDao;
    @Autowired
    private AuditTrailRepository auditTrailDao;
    @Autowired
    private EmployeeRepository employeeDao;
    @Autowired
    private FlagRepository flagDao;
    @Autowired
    private VesselVacancyRepository vesselVacancyDao;
    @Autowired
    private VesselRepository vesselDao;
    @Autowired
    private CrewService crewService;
    @Autowired
    private CrewContractRepository crewContractDao;
    @Autowired
    private VesselService vesselService;
    @Autowired
    private MongoDatabase db;
    @Autowired
    private MongoTemplate mongoTemplate;

    @GetMapping(value = "/list")
    public ModelAndView crewList(HttpServletRequest req, Model model) {
        ModelAndView mv = new ModelAndView("crew/crew_list");

        int crewStatusId = ParamUtil.parseInt(req.getParameter("statusId"), -1);
        List<Crew> list = crewService.getList();

        if (crewStatusId > 0) {
            Crew filterCrew = new Crew();
            filterCrew.setStatusId(crewStatusId);
            list = crewService.getFilteredList(filterCrew);
        } else {
            list = crewService.getList();
        }
        mv.addObject("list", list);
        return mv;
    }

    @GetMapping(value = "/personal")
    public ModelAndView personal(HttpServletRequest req) {
        ModelAndView mv = new ModelAndView("/crew/personal");
        String action = StringUtil.trim(req.getParameter("action"));
        String menu = StringUtil.trim(req.getParameter("menu"));
        String sMenu = StringUtil.trim(req.getParameter("sMenu"));
        if (menu == null) {
            menu = "personal";
        }
        long crewId = ParamUtil.parseLong(req.getParameter("crewId"), -1);
        if (crewId > 0) {
            Crew crew = crewService.getObjectById(crewId);
            crew.setStatus(Crew.Status.createFromId(crew.getStatusId()));

            mv.addObject("crew", crew);
            List<AuditTrail> auditTrails = auditTrailDao.getAudit(Collection.CREW, crewId);

            if (ListUtil.isNotEmpty(auditTrails)) {
                mv.addObject("auditTrails", auditTrails.stream().sorted(comparing(AuditTrail::getActionLocalDateTime).reversed()).collect(Collectors.toList()));
            } else {
                System.out.println("No auditTrails");
            }
            CrewPhoto photo = null;

            try {
                photo = photoDao.findById(crew.getPhotoId()).get();
                //mv.addObject("title", photo.getTitle());
                mv.addObject("image", Base64.getEncoder().encodeToString(photo.getImage().getData()));
            } catch (NoSuchElementException e) {

            }
        } else {
            if (action == null) {
                action = StandardWebParameter.ADD;
            }
        }
        mv.addObject("statuses", Crew.Status.getList());
        mv.addObject("menu", menu);
        mv.addObject("sMenu", sMenu);
        mv.addObject("crewId", crewId);

        mv.addObject("flags", getFlags());
        mv.addObject("action", action);
        mv.addObject("rankMap", Rank.getByGroup());
        return mv;
    }

    @GetMapping(value = "/overview")
    public ModelAndView view(HttpServletRequest req) {
        ModelAndView mv = new ModelAndView("/crew/overview");
        long crewId = ParamUtil.parseLong(req.getParameter("crewId"), -1);
        if (crewId > 0) {
            Crew crew = crewService.getObjectById(crewId);
            crew.setStatus(Crew.Status.createFromId(crew.getStatusId()));

            mv.addObject("crew", crew);
            List<AuditTrail> auditTrails = auditTrailDao.getAudit(Collection.CREW, crewId);
            if (ListUtil.isNotEmpty(auditTrails)) {
                System.out.println("auditTrails = " + auditTrails.size());
                mv.addObject("auditTrails", auditTrails);
            } else {
                System.out.println("No auditTrails");
            }
            CrewPhoto photo = null;

            try {
                photo = photoDao.findById(crew.getPhotoId()).get();
                //mv.addObject("title", photo.getTitle());
                mv.addObject("image", Base64.getEncoder().encodeToString(photo.getImage().getData()));
            } catch (NoSuchElementException e) {

            }
            List<CrewDocument> documents = documentDao.getPassportVisaCDC(crewId);
            mv.addObject("documents", documents);
        }
        mv.addObject("statuses", Crew.Status.getList());
        mv.addObject("menu", "overview");
        mv.addObject("crewId", crewId);
        mv.addObject("flags", getFlags());
        mv.addObject("rankMap", Rank.getByGroup());
        return mv;
    }

    @PostMapping(value = "/add", consumes = {MediaType.MULTIPART_FORM_DATA_VALUE})
    public ModelAndView addCrew(HttpServletRequest req, @RequestParam("firstName") String fName, @RequestParam("middleName") String mName,
                                @RequestParam("lastName") String lName, @RequestParam("rankId") int rankId,
                                @RequestParam("gender") String gender, @RequestParam("distinguishingMark") String distinguishMark,
                                @RequestParam("maritalStatus") String maritalStatus,
                                @RequestParam("permAddress") String permAddress,
                                @RequestParam("presentAddress") String presentAddress,
                                @RequestParam("nearestAirport") String nearestAirport,
                                @RequestParam("manningOffice") String manningOffice,
                                @RequestParam("emailId") String emailId,
                                @RequestParam("nationalityFlagCode") String nationalityFlagCode,
                                @RequestParam("contact1") String contact1,
                                @RequestParam("contact2") String contact2,
                                @RequestParam("dob") String dob,
                                @RequestParam("height") String height,
                                @RequestParam("weight") String weight,
                                @RequestParam("passportNumber") String passportNumber,
                                @RequestParam("availableFromDate") String availableFromDate,
                                @RequestParam("image") MultipartFile image,
                                Model model) {
        Employee emp = (Employee) req.getSession().getAttribute("currentUser");
        String maker = emp.getEmpId();
        ModelAndView mv = new ModelAndView("/crew/experience");
        System.out.println("add_crew: " + fName);
        System.out.println("image: " + image);

        //Add New Crew
        Crew crew = new Crew();
        crew.setFirstName(fName);
        crew.setLastName(lName);
        crew.setMiddleName(mName);
        crew.setEmailId(emailId);
        crew.setContact1(contact1);
        crew.setContact2(contact2);
        crew.setNearestAirport(nearestAirport);
        crew.setMaritalStatus(maritalStatus);
        crew.setPermAddress(permAddress);
        crew.setHeight(Double.parseDouble(height));
        crew.setWeight(Double.parseDouble(weight));
        crew.setPresentAddress(presentAddress);
        crew.setNationalityFlag(flagDao.getByCode(nationalityFlagCode));
        crew.setDob(DateTimeUtil.convertToDate(dob));
        crew.setAvailableFromDate(DateTimeUtil.convertToDate(availableFromDate));
        crew.setRank(Rank.createFromId(rankId));
        crew.setPassportNumber(passportNumber);
        crew.setGender(gender);
        crew.setDistinguishingMark(distinguishMark);
        crew.setManningOffice(manningOffice);

        crew.setEnteredBy(emp.getEmpId());
        crewService.addCrew(crew);
        long crewId = crew.getId();
        System.out.println("New crewId ---> " + crewId);
        mv.addObject("crewId", crewId);

        try {
            //Add Crew Photo
            CrewPhoto photo = new CrewPhoto(crewId, fName + " " + mName + " " + lName);
            photo.setId(sequenceGenerator.generateSequence(CrewPhoto.SEQUENCE_NAME));
            photo.setImage(new Binary(BsonBinarySubType.BINARY, image.getBytes()));
            photo = photoDao.insert(photo);
            long photoId = photo.getId();
            System.out.println("CrewId ---> " + crewId + " Photo ID: " + photoId);
            photo = photoDao.findById(photoId).get();

            //Save PhotoId to Crew
            crew.setPhotoId(photoId);
            crewService.updateCrew(crew);
            mv.addObject("image", Base64.getEncoder().encodeToString(photo.getImage().getData()));

        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
//		return "redirect:/photos/" + id;

        return mv;
    }

    @PostMapping(value = "/update.ajax", consumes = {MediaType.MULTIPART_FORM_DATA_VALUE})
    public String updateCrew(MultipartHttpServletRequest req, Model model) {
        Employee emp = (Employee) req.getSession().getAttribute("currentUser");
        String maker = emp.getEmpId();
        long crewId = ParamUtil.parseLong(req.getParameter("crewId"), -1);
        String json = req.getParameter("modifiedFields");
        JsonObject jsonObject = new Gson().fromJson(json, JsonObject.class);

        BasicDBObject searchQuery = new BasicDBObject("_id", crewId);
        BasicDBObject updateFields = new BasicDBObject();
        jsonObject.entrySet().forEach(e -> {
            if (e.getKey().equals("dob") || e.getKey().equals("availableFromDate")) {
                updateFields.append(e.getKey(), DateTimeUtil.convertToDate(e.getValue().getAsString()));
            } else {
                updateFields.append(e.getKey(), e.getValue().getAsString());
            }

        });
        BasicDBObject setQuery = new BasicDBObject();
        setQuery.append("$set", updateFields);
        db.getCollection(Collection.CREW, Crew.class).updateMany(searchQuery, setQuery);

        //Audit
       /* AuditTrail audit = new AuditTrail();
        audit.setAction(StandardWebParameter.ADD);
        audit.setActionBy(emp.getEmpId());
        audit.setActionLocalDateTime(LocalDateTime.now());
        audit.setCollection(Collection.CREW);
        audit.setText("New Document - <b>" + (docToUpload.getDocName()) + "</b> added!");
        audit.setId(sequenceGenerator.generateSequence(AuditTrail.SEQUENCE_NAME));
        audit.setUniqueId(crew.getId());
        auditTrailDao.insert(audit);*/

        model.addAttribute("message", "success");
        return model.toString();
    }


    @GetMapping(value = "/nok")
    public ModelAndView nok(HttpServletRequest req, Model model) {
        ModelAndView mv = new ModelAndView("crew/nok");
        long crewId = Long.parseLong(req.getParameter("crewId"));
        Crew crew = crewService.getObjectById(crewId);
        String menu = StringUtil.trim(req.getParameter("menu"));
        String sMenu = StringUtil.trim(req.getParameter("sMenu"));
        List<NextOfKin> list = crewService.getNextOfKins(crewId);
        mv.addObject("crew", crew);
        mv.addObject("crewId", crewId);
        mv.addObject("list", list);
        mv.addObject("menu", menu);
        mv.addObject("sMenu", sMenu);
        mv.addObject("relationTypes", NextOfKin.RelationType.getList());
        return mv;
    }

    @GetMapping(value = "/offer")
    public ModelAndView offerLetter(HttpServletRequest req, Model model) {
        ModelAndView mv = new ModelAndView("crew/offer");
        String action = StringUtil.trim(req.getParameter("action"));
        String menu = StringUtil.trim(req.getParameter("menu"));
        String sMenu = StringUtil.trim(req.getParameter("sMenu"));
        long crewId = Long.parseLong(req.getParameter("crewId"));

        if (StandardWebParameter.LIST.equals(action)) {
            //Crew crew = crewService.getObjectById(crewId);
            List<CrewDocument> list = documentDao.getOfferLetters(crewId);
            final List<OfferLetter> offerLetters = new ArrayList<>();
            list.forEach(d -> {
                if (d instanceof OfferLetter) {
                    offerLetters.add((OfferLetter) d);
                }
            });
            //mv.addObject("crew", crew);
            mv.addObject("list", offerLetters);

        } else if (StandardWebParameter.VIEW.equals(action)) {

        }
        mv.addObject("crewId", crewId);
        mv.addObject("menu", menu);
        mv.addObject("sMenu", sMenu);
        mv.addObject("sMenu", sMenu);
        mv.addObject("vessels", vesselDao.findAll());
        mv.addObject("rankMap", Rank.getByGroup());
        mv.addObject("durationTypes", DurationType.getList());

        List<DocumentType> docTypes = docTypeDao.findAll();
        DocumentType offerLetterDT = docTypes.stream().filter(d -> d.getDocumentPool().equals(DocumentPool.OFFER_LETTER)).collect(Collectors.toList()).get(0);
        mv.addObject("offerLetterDT", offerLetterDT);
        return mv;
    }

    @PostMapping(value = "/offer/add")
    public ModelAndView addOfferLetter(HttpServletRequest req, Model model) {
        ModelAndView mv = null;
        String menu = StringUtil.trim(req.getParameter("menu"));
        String sMenu = StringUtil.trim(req.getParameter("sMenu"));
        long crewId = ParamUtil.parseLong(req.getParameter("crewId"), -1);
        if (crewId > 0) {
            mv = new ModelAndView("redirect:/crew/offer?menu=" + menu + "&sMenu=" + sMenu + "&crewId=" + crewId);
            Crew crew = crewService.getObjectById(crewId);
            Employee emp = (Employee) req.getSession().getAttribute("currentUser");
            long docTypeId = ParamUtil.parseInt(req.getParameter("docTypeId"), -1);
            long vesselId = ParamUtil.parseLong(req.getParameter("vesselId"), -1);
            Vessel vessel = vesselService.getById(vesselId);
            Rank agreedRank = Rank.createFromId(ParamUtil.parseInt(req.getParameter("rankId"), -1));
            double agreedWages = ParamUtil.parseDouble(req.getParameter("agreedWages"), 0);
            DurationType durationType = DurationType.createFromId(ParamUtil.parseInt(req.getParameter("durationTypeId"), -1));
            int durationValue = ParamUtil.parseInt(req.getParameter("durationValue"), 0);
            Duration contractDuration = new Duration(durationType, durationValue);
            //LocalDate dateOfIssue = DateTimeUtil.convertToDate(req.getParameter("dateOfIssue"));

            DocumentType dt = docTypeDao.findById(docTypeId).get();
            if (dt.getDocumentPool().getName().equals(DocumentPool.OFFER_LETTER.getName())) {
                OfferLetter doc = new OfferLetter();
                doc.setCrewId(crewId);
                doc.setDocType(dt);
                doc.setVesselName(vessel.getVesselOwner().getOwnerName() + " " + vessel.getVesselName());
                doc.setAgreedRank(agreedRank);
                doc.setAgreedWages(agreedWages);
                //doc.setDateOfIssue(dateOfIssue);
                doc.setContractPeriod(contractDuration);
                //doc.setDateOfExpiry(DateTimeUtil.calculateExpiryDate(contractDuration, dateOfIssue));
                doc.setEnteredBy(emp);
                doc.setStatus(CrewDocumentStatus.PENDING_APPROVAL);
                doc.setEnteredDateTime(LocalDateTime.now());
                doc.setId(sequenceGenerator.generateSequence(CrewDocument.SEQUENCE_NAME));
                String uploadPath = req.getServletContext().getRealPath("");
                try{
                    generateOfferLetter(doc, crew, req.getServletContext().getRealPath(""));
                }catch (Exception e) {
                    e.printStackTrace();
                }
                documentDao.insert(doc);
            }

        }

        return mv;
    }

    @PostMapping(value = "/offer/acceptReject.ajax")
    public void acceptRejectOffer(MultipartHttpServletRequest req) {
        try {
            Employee emp = (Employee) req.getSession().getAttribute("currentUser");
            long crewId = Long.parseLong(req.getParameter("crewId"));
            long docId = Long.parseLong(req.getParameter("offerId"));
            String action = StringUtil.trim(req.getParameter("action"));
            CrewDocumentStatus status = null;
            Bson updates = null;
            if (action.equalsIgnoreCase(CrewDocumentStatus.APPROVED.getDesc())) {
                status = CrewDocumentStatus.APPROVED;
                updates = Updates.combine(
                        Updates.set("status", status),
                        Updates.set("approvedBy", emp),
                        Updates.set("approvedDateTime", DateTimeUtil.getNowDateTime())
                );
                //Create Appointment Letter

                OfferLetter offerLetter = (OfferLetter)documentDao.findById(docId).get();
                List<DocumentType> docTypes = docTypeDao.findAll();
                DocumentType appointLetterDT = docTypes.stream().filter(d -> d.getDocumentPool().equals(DocumentPool.APPT_LETTER)).collect(Collectors.toList()).get(0);

                AppointmentLetter doc = new AppointmentLetter();
                doc.setCrewId(crewId);
                doc.setDocType(appointLetterDT);
                doc.setVesselName(offerLetter.getVesselName());
                doc.setAgreedRank(offerLetter.getAgreedRank());
                doc.setAgreedWages(offerLetter.getAgreedWages());
                //doc.setDateOfIssue(dateOfIssue);
                doc.setContractPeriod(offerLetter.getContractPeriod());
                //doc.setDateOfExpiry(DateTimeUtil.calculateExpiryDate(contractDuration, dateOfIssue));
                doc.setEnteredBy(emp);
                doc.setStatus(CrewDocumentStatus.PENDING_APPROVAL);
                doc.setEnteredDateTime(LocalDateTime.now());
                doc.setId(sequenceGenerator.generateSequence(CrewDocument.SEQUENCE_NAME));
                documentDao.insert(doc);

            } else if (action.equalsIgnoreCase(CrewDocumentStatus.REJECTED.getDesc())) {
                status = CrewDocumentStatus.REJECTED;
                updates = Updates.combine(
                        Updates.set("status", status),
                        Updates.set("rejectedBy", emp),
                        Updates.set("rejectedDateTime", DateTimeUtil.getNowDateTime())
                );
            }
            if (status != null) {
                Bson filter = Filters.all("_id", docId);
                db.getCollection(Collection.CREW_DOCUMENT, CrewDocument.class).updateMany(filter, updates);
            }
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    @GetMapping(value = "/documents")
    public ModelAndView documentList(HttpServletRequest req, Model model) {
        ModelAndView mv = null;
        String menu = StringUtil.trim(req.getParameter("menu"));
        String sMenu = StringUtil.trim(req.getParameter("sMenu"));
        final String type = StringUtil.trim(req.getParameter("type")) != null ? req.getParameter("type") : "";

        Set<DocumentCategory> filterDocCatSet = new HashSet<>();
        Set<DocumentPool> filterDocPoolSet = new HashSet<>();

        DocumentCategory category = DocumentCategory.createFromName(type);
        if (category != null) {
            filterDocCatSet.add(category);
        } else if (type.equalsIgnoreCase("license")) {
            filterDocPoolSet.add(DocumentPool.LICENSE);
        } else if (type.equalsIgnoreCase("course")) {
            filterDocCatSet.add(DocumentCategory.TRAINING);
        } else if (type.equalsIgnoreCase("award")) {
            filterDocPoolSet.add(DocumentPool.AWARD);
        }
        long crewId = ParamUtil.parseLong(req.getParameter("crewId"), -1);
        if (crewId > 0) {
            mv = new ModelAndView("crew/documents");
            Crew crew = crewService.getById(crewId);
            mv.addObject("crew", crew);

            List<CrewDocument> allCrewFiles = documentDao.getDocsByCrewId(crewId);
            List<CrewDocument> list = new ArrayList<>();

            if (ListUtil.isNotEmpty(allCrewFiles)) {
                allCrewFiles.forEach(doc -> {
                    if (doc.getFile() != null) {
                        doc.setFileTitle(Base64.getEncoder().encodeToString(doc.getFile().getData()));
                    }
                    if (type.equals("")) {
                        list.add(doc);
                    } else {
                        if (filterDocPoolSet.size() > 0 && filterDocPoolSet.contains(doc.getDocType().getDocumentPool())) {
                            if (filterDocCatSet.size() > 0 && filterDocCatSet.contains(doc.getDocType().getDocumentCategory())) {
                                list.add(doc);
                            } else {
                                list.add(doc);
                            }
                        } else if (filterDocCatSet.size() > 0 && filterDocCatSet.contains(doc.getDocType().getDocumentCategory())) {
                            list.add(doc);
                        }
                    }


                });
                mv.addObject("list", list);
            }
            mv.addObject("docTypes", docTypeDao.findAll());
            mv.addObject("flags", getFlags());
        } else {
            mv = new ModelAndView("crew/doc_list");
            List<CrewDocument> existingDocuments = documentDao.findAll();
            mv.addObject("existingDocuments", existingDocuments);
        }
        mv.addObject("action", StandardWebParameter.MODIFY);
        mv.addObject("crewId", crewId);
        mv.addObject("menu", menu);
        mv.addObject("sMenu", sMenu);
        return mv;
    }

    @PostMapping(value = "/document/add", consumes = {MediaType.MULTIPART_FORM_DATA_VALUE})
    public ModelAndView addDocument(HttpServletRequest req, Model model) {
        ModelAndView mv = null;
        String menu = StringUtil.trim(req.getParameter("menu"));
        long crewId = ParamUtil.parseLong(req.getParameter("crewId"), -1);
        if (crewId > 0) {
            mv = new ModelAndView("redirect:/crew/documents?menu=documents&sMenu=documents&crewId=" + crewId);
            Crew crew = crewService.getById(crewId);
            mv.addObject("crew", crew);
            Employee emp = (Employee) req.getSession().getAttribute("currentUser");
            long docTypeId = ParamUtil.parseInt(req.getParameter("docTypeId"), -1);
            String nationalityFlagCode = req.getParameter("nationalityFlagCode");
            String docTypeName = req.getParameter("docTypeName");
            String docTypeDesc = req.getParameter("docTypeDesc");
            String docNumber = req.getParameter("docNumber");
            String givenName = req.getParameter("givenName");
            String issueDate = req.getParameter("issueDate");
            String placeOfIssue = req.getParameter("placeOfIssue");
            String expiryDate = req.getParameter("expiryDate");

            List<CrewDocument> list = documentDao.getDocsByCrewId(crewId);

            if (ListUtil.isNotEmpty(list)) {
                list.forEach(doc -> {
                    if (doc.getFile() != null) {
                        doc.setFileTitle(Base64.getEncoder().encodeToString(doc.getFile().getData()));
                        System.out.println(doc.getDocName() + " - " + doc.getFileTitle());
                    }
                });
                mv.addObject("list", list);
            }

            DocumentType dt = docTypeDao.findById(docTypeId).get();
            if (dt.getDocumentPool().getName().equals(DocumentPool.PASSPORT.getName())) {
                Passport doc = new Passport();
                doc.setCrewId(crewId);
                doc.setGivenName(givenName);
                doc.setDocName(docTypeName);
                doc.setDocDesc(docTypeDesc);
                doc.setDocType(dt);
                doc.setDocNumber(docNumber);
                doc.setPlaceOfIssue(placeOfIssue);
                Flag flag = flagDao.getByCode(nationalityFlagCode);
                doc.setFlag(flag);
                doc.setDateOfIssue(LocalDate.now());
                doc.setDateOfExpiry(LocalDate.now());
                doc.setEnteredBy(emp);
                doc.setEnteredDateTime(LocalDateTime.now());
                doc.setId(sequenceGenerator.generateSequence(CrewDocument.SEQUENCE_NAME));
                documentDao.insert(doc);
            } else if (dt.getDocumentPool().getName().equals(DocumentPool.VISA.getName())) {
                Visa doc = new Visa();
                doc.setCrewId(crewId);
                doc.setGivenName(givenName);
                doc.setDocName(docTypeName);
                doc.setDocDesc(docTypeDesc);
                doc.setDocType(dt);
                doc.setDocNumber(docNumber);
                doc.setPlaceOfIssue(placeOfIssue);
                Flag flag = flagDao.getByCode(nationalityFlagCode);
                doc.setFlag(flag);
                doc.setDateOfIssue(LocalDate.now());
                doc.setDateOfExpiry(LocalDate.now());
                doc.setEnteredBy(emp);
                doc.setEnteredDateTime(LocalDateTime.now());
                doc.setId(sequenceGenerator.generateSequence(CrewDocument.SEQUENCE_NAME));
                documentDao.insert(doc);
            } else if (dt.getDocumentPool().getName().equals(DocumentPool.LICENSE.getName())) {
                License doc = new License();
                doc.setCrewId(crewId);
                doc.setGivenName(givenName);
                doc.setDocName(docTypeName);
                doc.setDocDesc(docTypeDesc);
                doc.setDocType(dt);
                doc.setDocNumber(docNumber);
                doc.setPlaceOfIssue(placeOfIssue);
                Flag flag = flagDao.getByCode(nationalityFlagCode);
                doc.setFlag(flag);
                doc.setDateOfIssue(LocalDate.now());
                doc.setDateOfExpiry(LocalDate.now());
                doc.setEnteredBy(emp);
                doc.setEnteredDateTime(LocalDateTime.now());
                doc.setId(sequenceGenerator.generateSequence(CrewDocument.SEQUENCE_NAME));
                documentDao.insert(doc);
            } else if (dt.getDocumentPool().getName().equals(DocumentPool.CERTIFICATE.getName())) {
                License doc = new License();
                doc.setCrewId(crewId);
                doc.setGivenName(givenName);
                doc.setDocName(docTypeName);
                doc.setDocDesc(docTypeDesc);
                doc.setDocType(dt);
                doc.setDocNumber(docNumber);
                doc.setPlaceOfIssue(placeOfIssue);
                Flag flag = flagDao.getByCode(nationalityFlagCode);
                doc.setFlag(flag);
                doc.setDateOfIssue(LocalDate.now());
                doc.setDateOfExpiry(LocalDate.now());
                doc.setEnteredBy(emp);
                doc.setEnteredDateTime(LocalDateTime.now());
                doc.setId(sequenceGenerator.generateSequence(CrewDocument.SEQUENCE_NAME));
                documentDao.insert(doc);
            }

            mv.addObject("documentPools", DocumentPool.getList());
            mv.addObject("flags", getFlags());
            mv.addObject("action", StandardWebParameter.ADD);
            mv.addObject("crewId", crewId);
            mv.addObject("menu", menu);
        }

        return mv;
    }

    @GetMapping(value = "/generateContract")
    public ModelAndView generateContract(HttpServletRequest req, Model model) {
        ModelAndView mv = new ModelAndView("crew/contract_details");

        long crewId = ParamUtil.parseLong(req.getParameter("crewId"), -1);
        if (crewId > 0) {
            Crew crew = crewService.getObjectById(crewId);

            Vacancy vacancy = vesselVacancyDao.findById(crew.getAssignedVacancyId()).get();
            mv.addObject("crew", crew);
            mv.addObject("vessel", vacancy.getVessel());
            mv.addObject("crewId", crewId);
        }


        return mv;
    }

    @PostMapping(value = "/generateContract")
    public ModelAndView generateContractFiles(HttpServletRequest req, Model model) {
        ModelAndView mv = new ModelAndView("crew/crew_list");
        Employee emp = (Employee) req.getSession().getAttribute("currentUser");

        long crewId = ParamUtil.parseLong(req.getParameter("crewId"), -1);
        double monthlyWage = Double.parseDouble(req.getParameter("wage"));
        String embarkPort = StringUtil.trim(req.getParameter("embarkPort"));

        //Date
        String embarkDateStr = StringUtil.trim(req.getParameter("embarkDate"));
        String[] embarkDateArr = embarkDateStr.split("/");
        int month = ParamUtil.parseInt(embarkDateArr[0], -1);
        int day = ParamUtil.parseInt(embarkDateArr[1], -1);
        int year = ParamUtil.parseInt(embarkDateArr[2], -1);
        LocalDate embarkDate = LocalDate.of(year, month, day);

        if (crewId > 0) {
            Crew crew = crewService.getObjectById(crewId);
            generateContract(crew, emp.getEmpId(), embarkDate, embarkPort, monthlyWage);
            mv.addObject("crew", crew);
            mv.addObject("crewId", crewId);
        }


        return mv;
    }

    @GetMapping("/contract/download")
    public ResponseEntity<Resource> downloadContract(HttpServletRequest req, Model model) throws Exception {
        long contractId = ParamUtil.parseLong(req.getParameter("contractId"), -1);
        //model.addAttribute("message", "hello");

        CrewContract contract = crewContractDao.findById(contractId).get();
        String fileName = "Contract_" + contract.getId() + "_" + contract.getCrew().getFullName().replaceAll(" ", "_") + ".docx";

        FileOutputStream faos = new FileOutputStream(fileName);
        //Combine all contract pages
        final WordMerge wm = new WordMerge(faos);
        contract.getDocuments().forEach(d -> {
            try {
                InputStream input = new ByteArrayInputStream(d.getFile().getData());
                wm.add(input);
                input.close();
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        });
        wm.doMerge();
        wm.close();

        HttpHeaders header = new HttpHeaders();
        header.add(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=" + fileName);
        header.add("Cache-Control", "no-cache, no-store, must-revalidate");
        header.add("Pragma", "no-cache");
        header.add("Expires", "0");

        Path path = Paths.get(fileName);
        ByteArrayResource resource = new ByteArrayResource(Files.readAllBytes(path));

        File file = new File(fileName);

        return ResponseEntity.ok()
                .headers(header)
                .contentLength(file.length())
                .contentType(MediaType.APPLICATION_OCTET_STREAM)
                .body(resource);

    }

    @GetMapping("/document/download")
    public ResponseEntity<Resource> downloadDowcument(HttpServletRequest req, Model model) throws Exception {
        long documentId = ParamUtil.parseLong(req.getParameter("documentId"), -1);
        //model.addAttribute("message", "hello");

        CrewDocument doc = documentDao.findById(documentId).get();
        //String fileName = doc.getDocType().getDocumentPool().getName() + "_"+doc.getId() + ".docx";


        HttpHeaders header = new HttpHeaders();
        header.add(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=" + doc.getFileTitle());
        header.add("Cache-Control", "no-cache, no-store, must-revalidate");
        header.add("Pragma", "no-cache");
        header.add("Expires", "0");

        File file = new File(doc.getFileTitle());
        FileUtils.writeByteArrayToFile(file, doc.getFile().getData());

        //Path path = Paths.get(fileName);
        ByteArrayResource resource = new ByteArrayResource(doc.getFile().getData());

        return ResponseEntity.ok()
                .headers(header)
                .contentLength(file.length())
                .contentType(MediaType.APPLICATION_OCTET_STREAM)
                .body(resource);

    }

    private void generateContract(Crew crew, String enteredBy, LocalDate embarkDate, String embarkPort, Double monthlyWage) {

        //Get Vessel details on which the crew has been assigned
        Vacancy vacancy = vesselVacancyDao.findById(crew.getAssignedVacancyId()).get();

        //Get Vessel details
        Vessel vessel = vesselDao.findById(vacancy.getVessel().getId()).get();

        CrewContract contract = new CrewContract();
        contract.setId(sequenceGenerator.generateSequence(CrewContract.SEQUENCE_NAME));
        contract.setRank(crew.getRank());
        contract.setCrew(crew);
        contract.setVessel(vessel);
        contract.setPlaceOfContract("Mumbai");
        contract.setStartDate(embarkDate);
        contract.setEmbarkPort(embarkPort);
        Flag flag = flagDao.getByCode("IN");
        contract.setPlaceOfContractFlag(flag);
        contract.setMonthlyWage(new BigDecimal(monthlyWage));
        contract.setWageCurrency("USD");
        contract.setStatusId(CrewContract.Status.GENERATED.getId());
        contract.setEnteredBy(enteredBy);
        contract.setEnteredDateTime(LocalDateTime.now());

        //Generate Contract Docs
        ContractDocumentGenerator wordDocument = new ContractDocumentGenerator(crew, vessel, contract);
        try {
            wordDocument.generate();
        } catch (Exception e) {
            e.printStackTrace();
        }

        //Add Contract
        crewContractDao.insert(contract);


    }


    @GetMapping(value = "/contracts")
    public ModelAndView getContracts(HttpServletRequest req, Model model) {
        ModelAndView mv = null;
        List<CrewContract> list = null;
        long crewId = ParamUtil.parseLong(req.getParameter("crewId"), -1);
        if (crewId > 0) {
            mv = new ModelAndView("crew/contracts");
            list = crewContractDao.findByCrewId(crewId);
        } else {
            mv = new ModelAndView("crew/contract_list");
            list = crewContractDao.findAll();
        }
        mv.addObject("list", list);
        mv.addObject("crewId", crewId);
        return mv;
    }

    @GetMapping(value = "/experience")
    public ModelAndView employment(HttpServletRequest req, Model model) {
        ModelAndView mv = new ModelAndView("crew/experience");
        long crewId = Long.parseLong(req.getParameter("crewId"));
        List<Experience> experiences = crewService.getEmploymentHistory(crewId);
        mv.addObject("crewId", crewId);
        mv.addObject("experiences", experiences);
        return mv;
    }

    @GetMapping(value = "/education")
    public ModelAndView education(HttpServletRequest req, Model model) {
        ModelAndView mv = new ModelAndView("crew/education");
        long crewId = Long.parseLong(req.getParameter("crewId"));
        List<Education> educations = crewService.getEducationHistory(crewId);
        mv.addObject("crewId", crewId);
        mv.addObject("educations", educations);
        return mv;
    }

    @GetMapping(value = "/passport_visa")
    public ModelAndView getPassportVisa(HttpServletRequest req, Model model) {
        ModelAndView mv = new ModelAndView("crew/passport_visa");
        long crewId = Long.parseLong(req.getParameter("crewId"));
        List<CrewDocument> list = crewService.getPassportVisa(crewId);

        //List<Passport> passports = passportVisa.stream().filter(d->d.getDocType().getDocumentPool().getId() == DocumentPool.PASSPORT.getId()).map(Passport.class::cast).collect(Collectors.toList());
        List<Passport> passports = new ArrayList<>();
        List<Visa> visas = new ArrayList<>();
        for (CrewDocument doc : list) {
            if (doc instanceof Passport) {
                Passport pp = (Passport) doc;
                passports.add(pp);
            } else if (doc instanceof Visa) {
                Visa visa = (Visa) doc;
                visas.add(visa);
            }
        }

        mv.addObject("crewId", crewId);
        mv.addObject("passports", passports);
        mv.addObject("visas", visas);
        return mv;
    }


    @GetMapping(value = "/medical")
    public ModelAndView medical(HttpServletRequest req, Model model) {
        ModelAndView mv = new ModelAndView("crew/medical");
        long crewId = Long.parseLong(req.getParameter("crewId"));
        List<NextOfKin> list = crewService.getNextOfKins(crewId);
        mv.addObject("crewId", crewId);
        mv.addObject("list", list);
        return mv;
    }

    @GetMapping(value = "/bank")
    public ModelAndView bank(HttpServletRequest req, Model model) {
        ModelAndView mv = new ModelAndView("crew/bank");
        long crewId = Long.parseLong(req.getParameter("crewId"));
        String menu = StringUtil.trim(req.getParameter("menu"));
        String sMenu = StringUtil.trim(req.getParameter("sMenu"));
        List<Bank> list = crewService.getBanks(crewId);
        mv.addObject("crewId", crewId);
        mv.addObject("list", list);
        mv.addObject("sMenu", sMenu);
        mv.addObject("crewId", crewId);
        return mv;
    }

    @PostMapping(value = "/bank/add")
    public ModelAndView addBank(HttpServletRequest req, @RequestParam("crewId") long crewId,
                                @RequestParam("inputBankName") String bankName,
                                @RequestParam("inputAccountNumber") String accountNumber,
                                @RequestParam("inputSWIFT") String swift, @RequestParam("inputIFSC") String ifsc,
                                @RequestParam("inputBranchAddress") String branchAddress,
                                Model model) {
        Employee emp = (Employee) req.getSession().getAttribute("currentUser");
        String maker = emp.getEmpId();
        ModelAndView mv = new ModelAndView("redirect:/crew/bank?menu=personal&sMenu=bank&crewId=" + crewId);

        //Add New Crew
        Bank bank = new Bank();
        bank.setIfscCode(ifsc);
        bank.setSwiftCode(swift);
        bank.setBankName(bankName);
        bank.setAccountNumber(accountNumber);
        bank.setBranchAddress(branchAddress);
        bank.setPrimary(true);
        bank.setEnteredByEmp(emp);
        bank.setEnteredDateTime(DateTimeUtil.getNowDateTime());
        crewService.addBank(crewId, bank);

        return mv;
    }

    @PostMapping(value = "/bank/update.ajax")
    public String updateBank(MultipartHttpServletRequest req, Model model) {
        Employee emp = (Employee) req.getSession().getAttribute("currentUser");
        String maker = emp.getEmpId();
        long crewId = ParamUtil.parseLong(req.getParameter("crewId"), -1);
        String json = req.getParameter("modifiedFields");
        JsonObject jsonObject = new Gson().fromJson(json, JsonObject.class);

        BasicDBObject searchQuery = new BasicDBObject("_id", crewId);
        BasicDBObject updateFields = new BasicDBObject();
        jsonObject.entrySet().forEach(e -> {
            updateFields.append(e.getKey(), e.getValue().getAsString());
        });
        BasicDBObject setQuery = new BasicDBObject();
        setQuery.append("$set", updateFields);
        db.getCollection(Collection.CREW, Crew.class).updateOne(searchQuery, setQuery);

        //Audit
       /* AuditTrail audit = new AuditTrail();
        audit.setAction(StandardWebParameter.ADD);
        audit.setActionBy(emp.getEmpId());
        audit.setActionLocalDateTime(LocalDateTime.now());
        audit.setCollection(Collection.CREW);
        audit.setText("New Document - <b>" + (docToUpload.getDocName()) + "</b> added!");
        audit.setId(sequenceGenerator.generateSequence(AuditTrail.SEQUENCE_NAME));
        audit.setUniqueId(crew.getId());
        auditTrailDao.insert(audit);*/

        model.addAttribute("message", "success");
        return model.toString();
    }

    /*
        @PostMapping(value = "/add_employment")
        public ModelAndView addEmployment(HttpServletRequest req) {
            ModelAndView mv = new ModelAndView("crew/employment_list");
            String empName = StringUtil.trim(req.getParameter("empName"));
            long crewId = Long.parseLong(req.getParameter("crewId"));
            return mv;
        }

        @GetMapping(value = "/add_education")
        public ModelAndView addEducation(Model model) {
            ModelAndView mv = new ModelAndView("crew/add_education");
            return mv;
        }


        @GetMapping(value = "/add_medical")
        public ModelAndView addMedical(Model model) {
            ModelAndView mv = new ModelAndView("crew/add_medical");
            return mv;
        }

        @GetMapping(value = "/add_bank_account")
        public ModelAndView addBankAccount(Model model) {
            ModelAndView mv = new ModelAndView("crew/add_bank_account");
            return mv;
        }

        @GetMapping(value = "/add_nominee")
        public ModelAndView addNominee(Model model) {
            ModelAndView mv = new ModelAndView("crew/add_nominee");
            return mv;
        }

        @GetMapping(value = "/add_other_docs")
        public ModelAndView addOtherDocs(Model model) {
            ModelAndView mv = new ModelAndView("crew/add_other_docs");
            return mv;
        }
    */
    @GetMapping("/photos/{id}")
    public String getPhoto(@PathVariable long id, Model model) {
        CrewPhoto photo = photoDao.findById(id).get();
        model.addAttribute("title", photo.getTitle());
        model.addAttribute("image", Base64.getEncoder().encodeToString(photo.getImage().getData()));
        return "photos";
    }

    @PostMapping(value = "/photos/upload.ajax", consumes = {MediaType.MULTIPART_FORM_DATA_VALUE})
    public void uploadPhoto(MultipartHttpServletRequest req, @RequestParam("image") MultipartFile image) {
        try {
            long crewId = Long.parseLong(req.getParameter("crewId"));
            CrewPhoto photo = photoDao.findByCrewId(crewId);
            long photoId = 0;
            //Add Crew Photo
            if (photo != null) {
                photoId = photo.getId();
                db.getCollection(Collection.CREW_PHOTO, CrewPhoto.class).updateOne(Filters.all("_id", photoId), Updates.set("image", new Binary(BsonBinarySubType.BINARY, image.getBytes())));
            } else {
                photo = new CrewPhoto(crewId, "Photo");
                photoId = sequenceGenerator.generateSequence(CrewPhoto.SEQUENCE_NAME);
                photo.setId(photoId);
                photo.setImage(new Binary(BsonBinarySubType.BINARY, image.getBytes()));
                photoDao.insert(photo);
            }
            //Update PhotoId to Crew
            db.getCollection(Collection.CREW, Crew.class).updateOne(Filters.all("_id", crewId), Updates.set("photoId", photoId));

        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    @GetMapping(value = "/upload_crew")
    public ModelAndView uploadCrewData(Model model) {
        ModelAndView mv = new ModelAndView("crew/upload_crew");
        return mv;
    }

    @PostMapping(value = "/upload", consumes = {MediaType.MULTIPART_FORM_DATA_VALUE})
    public ModelAndView uploadExcel(HttpServletRequest req, @RequestParam("file") MultipartFile file,
                                    RedirectAttributes redirectAttributes) {
        ModelAndView mv = new ModelAndView("crew/crew_list");
        Employee emp = (Employee) req.getSession().getAttribute("currentUser");

        redirectAttributes.addFlashAttribute("message",
                "You successfully uploaded " + file.getOriginalFilename() + "!");

        try {
            String uploadPath = req.getServletContext().getRealPath("") + File.separator + "temp" + File.separator;
            String newFilePath = uploadPath + file.getOriginalFilename();
            FileCopyUtils.copy(file.getBytes(), new File(newFilePath));
            FileInputStream fi = new FileInputStream(newFilePath);
            crewService.uploadCrewData(emp.getEmpId(), fi);

        } catch (IOException e) {
            e.printStackTrace();
        }
        return mv;
    }

    @PostMapping(value = "/addDoc", consumes = {MediaType.MULTIPART_FORM_DATA_VALUE})
    public String addDoc(HttpServletRequest req, @RequestParam("crewId") long crewId,
                         @RequestParam("docId") long docId,
                         @RequestParam("file") MultipartFile file,
                         RedirectAttributes redirectAttributes) {
        Crew crew = crewService.getById(crewId);
        Employee emp = (Employee) req.getSession().getAttribute("currentUser");

        redirectAttributes.addFlashAttribute("message",
                "You successfully uploaded " + file.getOriginalFilename() + "!");
        System.out.println("docId = " + docId);


        CrewDocument docToUpload = documentDao.findById(docId).get();
        try {
            docToUpload.setFileTitle(file.getOriginalFilename());
            docToUpload.setFile(new Binary(BsonBinarySubType.BINARY, file.getBytes()));
            docToUpload.setFieldStatus(new FieldStatus(emp.getEmpId(), LocalDateTime.now(), null, null));

            //Audit
            AuditTrail audit = new AuditTrail();
            audit.setAction(StandardWebParameter.ADD);
            audit.setActionBy(emp.getEmpId());
            audit.setActionLocalDateTime(LocalDateTime.now());
            audit.setCollection(Collection.CREW);
            audit.setText("New Document - <b>" + (docToUpload.getDocName()) + "</b> added!");
            audit.setId(sequenceGenerator.generateSequence(AuditTrail.SEQUENCE_NAME));
            audit.setUniqueId(crew.getId());
            auditTrailDao.insert(audit);
        } catch (IOException e) {
            e.printStackTrace();
        }

        documentDao.save(docToUpload);

        //crew.setExistingDocuments(documents);
        //crewService.updateCrew(crew);

        return "redirect:/";
    }

    /*
     * @PostMapping("/photos/add") public String addPhoto(@RequestParam("title")
     * String title, @RequestParam("image") MultipartFile image, Model model) throws
     * IOException { String id = photoService.addPhoto(title, image); return
     * "redirect:/photos/" + id; }
     */

  /*  @GetMapping(value = "/vacancies")
    public ModelAndView vacancyListForACrew(HttpServletRequest req, Model model) {
        ModelAndView mv = new ModelAndView("crew/vacancies");

        long crewId = ParamUtil.parseLong(req.getParameter("crewId"), -1);
        List<VesselVacancy> vacancies = new ArrayList<>();
        if (crewId > 0) {
            Crew crew = crewService.getById(crewId);
            mv.addObject("crew", crew);
            //vacancies = vesselVacancyDao.findVacanciesByRank(crew.getRank().getId());
            vacancies = vesselVacancyDao.findAll();
        } else {
            vacancies = vesselVacancyDao.findAll();
        }

        vacancies.forEach(v -> {
            Vessel vessel = vesselDao.findById(v.getVesselId()).get();
            VesselVacancyAttributes att = v.getVacancyAttributes();
            System.out.print("[" + vessel.getVesselName() + "] has VACANCY -> ");
            System.out.print(" Min Gross Tonnage [" + att.getMinGrossTonnage() + "] | ");
            System.out.print(" Min Ranks required [");
            att.getMinRankList().forEach(rankId -> {
                System.out.print(Rank.createFromId(rankId).getName() + ", ");
            });
            System.out.print("] | ");
            System.out.print(" Min Vessel Experince in [");
            if (att.getMinVesselSubTypeIdList() != null && !att.getMinVesselSubTypeIdList().isEmpty()) {
                att.getMinVesselSubTypeIdList().forEach(vesselSubTypeId -> {
                    System.out.print(VesselSubType.createFromId(vesselSubTypeId).getDesc() + ", ");
                });
            } else {
                System.out.print("Any Vessel");
            }
            v.setVessel(vessel);
           *//* if (v.getFilledByCrewId() > 0) {
                v.setFilledByCrew(crewService.getById(v.getFilledByCrewId()));
            }*//*
            v.setStatus(VesselVacancy.Status.createFromId(v.getStatusId()));
            System.out.print(" ]");
            System.out.println();
        });
        mv.addObject("vacancies", vacancies);
        return mv;
    }*/


    class WordMerge {

        private final OutputStream result;
        private final List<InputStream> inputs;
        private XWPFDocument first;

        public WordMerge(OutputStream result) {
            this.result = result;
            inputs = new ArrayList<>();
        }

        public void add(InputStream stream) throws Exception {
            inputs.add(stream);
            OPCPackage srcPackage = OPCPackage.open(stream);
            XWPFDocument src1Document = new XWPFDocument(srcPackage);
            if (inputs.size() == 1) {
                first = src1Document;
            } else {
                CTBody srcBody = src1Document.getDocument().getBody();
                first.getDocument().addNewBody().set(srcBody);
            }
        }

        public void doMerge() throws Exception {
            first.write(result);
        }

        public void close() throws Exception {
            result.flush();
            result.close();
            for (InputStream input : inputs) {
                input.close();
            }
        }
    }

    private List<Flag> getFlags() {
        List<Flag> flags = flagDao.findAll();
        flags.parallelStream().forEach(f -> {
            f.setId(null);
            f.setImage(null);
            f.setUnicode(null);
            f.setEmoji(null);
        });
        return flags;
    }

    public void generateOfferLetter(OfferLetter offerLetter, Crew crew, String tempFilePath) throws JRException {
        File jasperFile = new File(tempFilePath +  "\\jasper\\offer_letter.jasper");
        String uploadPath = tempFilePath + File.separator + "temp" + File.separator + "offer_letter.pdf";
        Map<String, Object> parameters = new HashMap<>();
        parameters.put("crewName", crew.getFullName());
        parameters.put("rank", offerLetter.getAgreedRank().getName());
        parameters.put("agreedWages", String.valueOf(offerLetter.getAgreedWages()));
        parameters.put("vesselName", offerLetter.getVesselName());
        parameters.put("contractPeriod", offerLetter.getContractPeriod());

        List<Bank> banks = crew.getBanks();
        if(ListUtil.isNotEmpty(banks)) {
            Bank bank = (Bank)ListUtil.getFirstItem(banks);
            parameters.put("bankName", bank.getBankName());
            parameters.put("accountNUmber", bank.getAccountNumber());
            parameters.put("beneficiaryName", bank.getBeneficiaryName());
        }
        //final JRBeanCollectionDataSource data = new JRBeanCollectionDataSource(new ArrayList<>());

        JasperPrint jasperPrint = JasperFillManager.fillReport(jasperFile.getPath(), parameters, new JREmptyDataSource());
        JRPdfExporter exporter = new JRPdfExporter();

        exporter.setExporterInput(new SimpleExporterInput(jasperPrint));
        exporter.setExporterOutput(
                new SimpleOutputStreamExporterOutput("offer_letter.pdf"));
        SimplePdfReportConfiguration reportConfig
                = new SimplePdfReportConfiguration();
        reportConfig.setSizePageToContent(true);
        reportConfig.setForceLineBreakPolicy(false);

        SimplePdfExporterConfiguration exportConfig
                = new SimplePdfExporterConfiguration();
        exportConfig.setMetadataAuthor("intuitbrains");
        exportConfig.setEncrypted(true);
        exportConfig.setAllowedPermissionsHint("PRINTING");

        exporter.setConfiguration(reportConfig);
        exporter.setConfiguration(exportConfig);

        exporter.exportReport();
        JasperExportManager.exportReportToPdfFile(jasperPrint, uploadPath);

        offerLetter.setFile(new Binary(BsonBinarySubType.BINARY, uploadPath.getBytes()));

    }
}
