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
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.*;
import java.util.stream.Collectors;

import javax.servlet.http.HttpServletRequest;

import com.intuitbrains.common.AuditTrail;
import com.intuitbrains.common.Collection;
import com.intuitbrains.dao.common.*;
import com.intuitbrains.dao.company.EmployeeRepository;
import com.intuitbrains.dao.vessel.VesselRepository;
import com.intuitbrains.dao.vessel.VesselVacancyRepository;
import com.intuitbrains.model.common.document.Passport;
import com.intuitbrains.model.common.document.category.CrewDocument;
import com.intuitbrains.model.common.document.category.DocumentPool;
import com.intuitbrains.model.company.Employee;
import com.intuitbrains.model.crew.*;
import com.intuitbrains.model.vessel.Vessel;
import com.intuitbrains.model.vessel.VesselVacancy;
import com.intuitbrains.model.vessel.VesselVacancyAttributes;
import com.intuitbrains.service.crew.CrewService;
import com.intuitbrains.util.ListUtil;
import com.intuitbrains.util.StandardWebParameter;
import com.intuitbrains.util.StringUtil;
import org.bson.BsonBinarySubType;
import org.bson.types.Binary;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.intuitbrains.dao.crew.PhotoRepository;
import com.intuitbrains.model.vessel.VesselSubType;
import com.intuitbrains.service.common.SequenceGeneratorService;
import com.intuitbrains.util.ParamUtil;

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

    @GetMapping(value = "/list")
    public ModelAndView crewList(Model model) {
        ModelAndView mv = new ModelAndView("crew/crew_list");
        List<Crew> list = crewService.getList();
        mv.addObject("list", list);
        return mv;
    }

    @GetMapping(value = "/add")
    public ModelAndView addCrew(Model model) {
        ModelAndView mv = new ModelAndView("crew/crew_details");
        mv.addObject("action", StandardWebParameter.ADD);
        mv.addObject("rankMap", Rank.getByGroup());
        mv.addObject("flags", flagDao.findAll());
        return mv;
    }

    @GetMapping(value = "/modify")
    public ModelAndView modifyCrew(HttpServletRequest req) {
        ModelAndView mv = new ModelAndView("/crew/crew_details");

        long crewId = ParamUtil.parseLong(req.getParameter("crewId"), -1);
        if (crewId > 0) {
            Crew crew = crewService.getById(crewId);

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

        }
        mv.addObject("crewId", crewId);
        mv.addObject("flags", flagDao.findAll());
        mv.addObject("action", StandardWebParameter.MODIFY);
        mv.addObject("rankMap", Rank.getByGroup());
        return mv;
    }


    @PostMapping(value = "/save")
    public ModelAndView saveCrew(HttpServletRequest req) {
        ModelAndView mv = new ModelAndView("/crew/crew_details");

        Employee emp = (Employee) req.getSession().getAttribute("currentUser");
        long crewId = ParamUtil.parseLong(req.getParameter("crewId"), -1);
        if (crewId > 0) {
            Enumeration enumer = req.getParameterNames();
            Iterator iter = enumer.asIterator();
            while (iter.hasNext()) {
                String paramName = (String) iter.next();
                System.out.println(paramName + " : " + req.getParameter(paramName));
            }
            //Crew crew = crewDao.findById(crewId).get();


        }
        mv.addObject("action", StandardWebParameter.MODIFY);
        mv.addObject("rankMap", Rank.getByGroup());
        return mv;
    }


    @GetMapping(value = "/document_list")
    public ModelAndView documentList(HttpServletRequest req, Model model) {
        ModelAndView mv = new ModelAndView("crew/document_list");
        List<CrewDocument> documents = documentDao.findAll();

        long crewId = ParamUtil.parseLong(req.getParameter("crewId"), -1);
        if (crewId > 0) {
            Crew crew = crewService.getById(crewId);
            mv.addObject("crew", crew);
            List<? extends CrewDocument> existingDocuments = crew.getExistingDocuments();

            if (ListUtil.isNotEmpty(existingDocuments)) {
                existingDocuments.forEach(doc -> {
                    doc.setFileTitle(Base64.getEncoder().encodeToString(doc.getFile().getData()));
                    System.out.println(doc.getDocName() + " - " + doc.getFileTitle());
                });
                mv.addObject("existingDocuments", existingDocuments);
            }
            CrewPhoto photo = null;

            try {
                photo = photoDao.findById(crew.getPhotoId()).get();
                //mv.addObject("title", photo.getTitle());
                mv.addObject("image", Base64.getEncoder().encodeToString(photo.getImage().getData()));
            } catch (NoSuchElementException e) {

            }


            List<AuditTrail> auditTrails = auditTrailDao.getAudit(Collection.CREW, crew.getId());
            if (ListUtil.isNotEmpty(auditTrails)) {
                System.out.println("auditTrails = " + auditTrails.size());
                mv.addObject("auditTrails", auditTrails);
            } else {
                System.out.println("No auditTrails");
            }

        }

        mv.addObject("action", "Edit");
        mv.addObject("list", documents);


        return mv;
    }

    @GetMapping(value = "/contract_list")
    public ModelAndView contractList(HttpServletRequest req, Model model) {
        ModelAndView mv = new ModelAndView("crew/contract_list");
        List<CrewDocument> documents = documentDao.findAll();

        long crewId = ParamUtil.parseLong(req.getParameter("crewId"), -1);
        if (crewId > 0) {
            Crew crew = crewService.getById(crewId);
            mv.addObject("crew", crew);
            List<? extends CrewDocument> existingDocuments = crew.getExistingDocuments();

            if (ListUtil.isNotEmpty(existingDocuments)) {
                existingDocuments.forEach(doc -> {
                    doc.setFileTitle(Base64.getEncoder().encodeToString(doc.getFile().getData()));
                    System.out.println(doc.getDocName() + " - " + doc.getFileTitle());
                });
                mv.addObject("existingDocuments", existingDocuments);
            }
            CrewPhoto photo = null;

            try {
                photo = photoDao.findById(crew.getPhotoId()).get();
                //mv.addObject("title", photo.getTitle());
                mv.addObject("image", Base64.getEncoder().encodeToString(photo.getImage().getData()));
            } catch (NoSuchElementException e) {

            }


            List<AuditTrail> auditTrails = auditTrailDao.getAudit(Collection.CREW, crew.getId());
            if (ListUtil.isNotEmpty(auditTrails)) {
                System.out.println("auditTrails = " + auditTrails.size());
                mv.addObject("auditTrails", auditTrails);
            } else {
                System.out.println("No auditTrails");
            }

        }

        mv.addObject("action", "Edit");
        mv.addObject("list", documents);


        return mv;
    }

    @PostMapping(value = "/add", consumes = {MediaType.MULTIPART_FORM_DATA_VALUE})
    public ModelAndView addCrew(HttpServletRequest req, @RequestParam("fName") String fName, @RequestParam("mName") String mName,
                                @RequestParam("lName") String lName, @RequestParam("rankId") int rankId,
                                @RequestParam("gender") String gender, @RequestParam("distinguishingMark") String distinguishMark,
                                @RequestParam("maritalStatus") String maritalStatus,
                                @RequestParam("homeAddress") String homeAddress,
                                @RequestParam("nearestAirport") String nearestAirport,
                                @RequestParam("emailId") String emailId,
                                @RequestParam("nationality") String nationality,
                                @RequestParam("nationalityFlagCode") String nationalityFlagCode,
                                @RequestParam("contact_1") String contact1,
                                @RequestParam("contact_2") String contact2,
                                @RequestParam("birthDate") String dob,
                                @RequestParam("manningOffice") String manningOffice, @RequestParam("image") MultipartFile image,
                                Model model) {
        Employee emp = (Employee) req.getSession().getAttribute("currentUser");
        String maker = emp.getEmpId();
        ModelAndView mv = new ModelAndView("/crew/employment_list");
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
        crew.setMaritalStatusId(0);
        crew.setPermAddress(homeAddress);
        crew.setNationality(nationality);
        crew.setNationalityFlagId(flagDao.getByCode(nationalityFlagCode).getId());
        String[] dobStr = dob.split("/");
        int month = ParamUtil.parseInt(dobStr[0], -1);
        int day = ParamUtil.parseInt(dobStr[1], -1);
        int year = ParamUtil.parseInt(dobStr[2], -1);
        crew.setDob(LocalDate.of(year, month, day));
        crew.setRank(Rank.createFromId(rankId));
        crew.setGender(gender);
        crew.setDistinguishMark(distinguishMark);
        crew.setManningOffice(manningOffice);

        CrewFieldStatus fs = crew.getFieldStatus();
        fs.setGender(new FieldStatus(maker, LocalDateTime.now(), null, null));
        fs.setDistinguishingMark(new FieldStatus(maker, LocalDateTime.now(), null, null));
        fs.setManningOffice(new FieldStatus(maker, LocalDateTime.now(), null, null));
        fs.setEmailId(new FieldStatus(maker, LocalDateTime.now(), null, null));
        fs.setPermAddress(new FieldStatus(maker, LocalDateTime.now(), null, null));
        fs.setPresentAddress(new FieldStatus(maker, LocalDateTime.now(), null, null));
        fs.setNearestAirport(new FieldStatus(maker, LocalDateTime.now(), null, null));
        fs.setRank(new FieldStatus(maker, LocalDateTime.now(), null, null));
        fs.setDob(new FieldStatus(maker, LocalDateTime.now(), null, null));
        fs.setNationality(new FieldStatus(maker, LocalDateTime.now(), null, null));
        fs.setContact1(new FieldStatus(maker, LocalDateTime.now(), null, null));
        fs.setContact2(new FieldStatus(maker, LocalDateTime.now(), null, null));
        crew.setFieldStatus(fs);

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
        List<? extends CrewDocument> passportVisa = crewService.getPassportVisa(crewId);

        List<Passport> passport = passportVisa.stream().filter(d->d.getDocType().getDocumentPool().getId() == DocumentPool.PASSPORT.getId()).map(Passport.class::cast).collect(Collectors.toList());

        mv.addObject("crewId", crewId);
        mv.addObject("passport", passport);
        return mv;
    }

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

    @GetMapping("/photos/{id}")
    public String getPhoto(@PathVariable long id, Model model) {
        CrewPhoto photo = photoDao.findById(id).get();
        model.addAttribute("title", photo.getTitle());
        model.addAttribute("image", Base64.getEncoder().encodeToString(photo.getImage().getData()));
        return "photos";
    }

    @GetMapping("/photos/upload")
    public String uploadPhoto(Model model) {
        model.addAttribute("message", "hello");
        return "uploadPhoto";
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

        List<CrewDocument> documents = crew.getExistingDocuments();
        if (documents == null) {
            documents = new LinkedList<>();
        }
        CrewDocument docToUpload = documentDao.findById(docId).get();
        docToUpload.setFileTitle(file.getOriginalFilename());
        try {
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

       // documents.add(docToUpload);

        crew.setExistingDocuments(documents);
        crewService.updateCrew(crew);

        return "redirect:/";
    }

    /*
     * @PostMapping("/photos/add") public String addPhoto(@RequestParam("title")
     * String title, @RequestParam("image") MultipartFile image, Model model) throws
     * IOException { String id = photoService.addPhoto(title, image); return
     * "redirect:/photos/" + id; }
     */

    @GetMapping(value = "/vacancy_list")
    public ModelAndView vacancyListForACrew(HttpServletRequest req, Model model) {
        ModelAndView mv = new ModelAndView("crew/vacancy_list");

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
            if (v.getFilledByCrewId() > 0) {
                v.setFilledByCrew(crewService.getById(v.getFilledByCrewId()));
            }
            v.setStatus(VesselVacancy.Status.createFromId(v.getStatusId()));
            System.out.print(" ]");
            System.out.println();
        });
        mv.addObject("vacancies", vacancies);
        return mv;
    }

}
