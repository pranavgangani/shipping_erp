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
package com.intuitbrains.web.vessel;


import java.io.IOException;
import java.time.LocalDateTime;
import java.util.*;

import com.intuitbrains.dao.common.AuditTrailRepository;
import com.intuitbrains.dao.company.EmployeeRepository;
import com.intuitbrains.dao.crew.CrewRepository;
import com.intuitbrains.dao.vessel.*;
import com.intuitbrains.model.company.Employee;
import com.intuitbrains.model.crew.Crew;
import com.intuitbrains.model.crew.Rank;
import com.intuitbrains.model.vessel.*;
import com.intuitbrains.util.ParamUtil;
import com.intuitbrains.util.StandardWebParameter;
import com.intuitbrains.util.StringUtil;
import org.bson.BsonBinarySubType;
import org.bson.types.Binary;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;

import com.intuitbrains.dao.common.FlagRepository;
import com.intuitbrains.service.common.SequenceGeneratorService;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping(value = "/vessel")
public class VesselController {
    @Autowired
    private VesselRepository vesselDao;
    @Autowired
    private VesselOwnerRepository vesselOwnerDao;
    @Autowired
    private SequenceGeneratorService sequenceGenerator;
    @Autowired
    private VesselOwnerPhotoRepository vesselOwnerPhotoDao;
    @Autowired
    private VesselPhotoRepository vesselPhotoDao;
    @Autowired
    private FlagRepository flagDao;
    @Autowired
    private EmployeeRepository employeeDao;
    @Autowired
    private AuditTrailRepository auditTrailDao;
    @Autowired
    private VesselVacancyRepository vesselVacancyDao;
    @Autowired
    private CrewRepository crewDao;

    /*********************************************** Vessel Start ***********************************/
    @GetMapping(value = "/vessel_list")
    public ModelAndView vesselList(HttpServletRequest req) {
        ModelAndView mv = new ModelAndView("vessel/vessel_list");
        String action = StringUtil.trim(req.getParameter("action"));
        long vesselOwnerId = ParamUtil.parseLong(req.getParameter("vesselOwnerId"), -1);

        List<Vessel> list = null;
        if (vesselOwnerId > 0) {
            list = vesselDao.findByVesselOwner(vesselOwnerId);
        } else {
            list = vesselDao.findAll();
        }
        mv.addObject("list", list);
        return mv;
    }

    @PostMapping(value = "/vessel_details", consumes = {MediaType.MULTIPART_FORM_DATA_VALUE})
    public ModelAndView vesselDetails(MultipartHttpServletRequest req, Model model) {
        ModelAndView mv = new ModelAndView("redirect:/vessel/vessel_list");
        String action = StringUtil.trim(req.getParameter("action"));
        long vesselOwnerId = ParamUtil.parseLong(req.getParameter("vesselOwnerId"), -1);
        long vesselId = ParamUtil.parseLong(req.getParameter("vesselId"), -1);
        Vessel vessel = new Vessel();

        if (StandardWebParameter.ADD.equalsIgnoreCase(action) || StandardWebParameter.MODIFY.equalsIgnoreCase(action)) {
            String vesselName = req.getParameter("vesselName");
            String imo = req.getParameter("imo");
            String mmsi = req.getParameter("mmsi");
            String flag = req.getParameter("flag");
            String callSign = req.getParameter("callSign");
            int vesselSubTypeId = ParamUtil.parseInt(req.getParameter("vesselSubTypeId"), -1);
            int length = ParamUtil.parseInt(req.getParameter("length"), -1);
            int beam = ParamUtil.parseInt(req.getParameter("beam"), -1);
            int draught = ParamUtil.parseInt(req.getParameter("draught"), -1);

            int grossTon = ParamUtil.parseInt(req.getParameter("grossTon"), -1);
            int yearOfBuilt = ParamUtil.parseInt(req.getParameter("yearOfBuilt"), -1);
            String vesselDesc = req.getParameter("vesselDesc");

            MultipartFile image = req.getFile("image");
            System.out.println("vesselName: " + vesselName);
            Employee user = (Employee) req.getSession().getAttribute("currentUser");

            vessel.setVesselName(vesselName);
            vessel.setVesselOwner(vesselOwnerDao.findById(vesselOwnerId).get());
            vessel.setImo(imo);
            vessel.setMmsi(mmsi);
            vessel.setFlagCode(flag);
            //vessel.setVesselType(VesselType.createFromId(vesselTypeId));
            vessel.setVesselSubType(VesselSubType.createFromId(vesselSubTypeId));
            vessel.setLength(length);
            vessel.setBeam(beam);
            vessel.setDraught(draught);
            vessel.setCallSign(callSign);
            vessel.setGrossTonnage(grossTon);
            vessel.setYearOfBuilt(yearOfBuilt);
            vessel.setVesselDesc(vesselDesc);
            vessel.setEnteredBy(user.getEmpId());
            vessel.setEnteredDateTime(LocalDateTime.now());
            vessel.setId(sequenceGenerator.generateSequence(Vessel.SEQUENCE_NAME));
            vesselDao.insert(vessel);

            vesselId = vessel.getId();
            System.out.println("New vesselId ---> " + vesselId);

            try {
                VesselPhoto photo = new VesselPhoto(vesselId, String.valueOf(vesselId));
                photo.setId(sequenceGenerator.generateSequence(VesselPhoto.SEQUENCE_NAME));
                photo.setImage(new Binary(BsonBinarySubType.BINARY, image.getBytes()));
                photo = vesselPhotoDao.insert(photo);
                long photoId = photo.getId();
                System.out.println("VesselId ---> " + vesselId + " Photo ID: " + photoId);

                photo = vesselPhotoDao.findById(photoId).get();
                //model.addAttribute("title", photo.getTitle());
                mv.addObject("image", Base64.getEncoder().encodeToString(photo.getImage().getData()));

                vessel.setPhotoId(photoId);
                vesselDao.save(vessel);


            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            mv.addObject("vessel", vessel);
        } else if (StandardWebParameter.VIEW.equalsIgnoreCase(action)) {
            if (vesselId > 0) {
                vessel = vesselDao.findById(vesselId).get();
                mv.addObject("vessel", vessel);
            }
        } else if (StandardWebParameter.LIST.equalsIgnoreCase(action)) {
            if (vesselOwnerId > 0) {
                List<Vessel> list = vesselDao.findByVesselOwner(vesselOwnerId);
                mv.addObject("list", list);
            }
        }
        mv.addObject("vesselId", vesselId);

        return mv;
    }


    @GetMapping(value = "/vessel_details")
    public ModelAndView vesselDetails(HttpServletRequest req, Model model) {
        ModelAndView mv = new ModelAndView();
        String action = StringUtil.trim(req.getParameter("action"));
        long vesselOwnerId = ParamUtil.parseLong(req.getParameter("vesselOwnerId"), -1);

        mv.addObject("vesselOwnerId", vesselOwnerId);

        if (StandardWebParameter.ADD.equalsIgnoreCase(action) || StandardWebParameter.MODIFY.equalsIgnoreCase(action)) {
            mv.addObject("flags", flagDao.findAll());
            mv.addObject("vesselTypes", VesselType.getList());
            mv.addObject("vesselSubTypeMap", VesselSubType.getByGroup());
            mv.addObject("vesselOwners", vesselOwnerDao.findAll());

            mv.setViewName("vessel/vessel_details");
        } else if (StandardWebParameter.LIST.equalsIgnoreCase(action)) {
            List<Vessel> list = null;
            if (vesselOwnerId > 0) {
                list = vesselDao.findByVesselOwner(vesselOwnerId);
            } else {
                list = vesselDao.findAll();
            }
            mv.addObject("list", list);
            mv.setViewName("vessel/vessel_details_list");
        }

        mv.addObject("action", action);
        return mv;
    }

    /*********************************************** Vessel End ***********************************/

    /*********************************************** Vessel Owner Start ***********************************/
    @GetMapping(value = "/vessel_owner_list")
    public ModelAndView vesselOwnerList(Model model) {
        ModelAndView mv = new ModelAndView("vessel/vessel_owner_list");
        mv.addObject("list", vesselOwnerDao.findAll());
        return mv;
    }

    @GetMapping(value = "/vessel_owner_details")
    public ModelAndView vesselOwnerDetails(HttpServletRequest req) {
        ModelAndView mv = new ModelAndView("vessel/vessel_owner_details");
        long vesselOwnerId = ParamUtil.parseLong(req.getParameter("vesselOwnerId"), -1);
        String action = StringUtil.trim(req.getParameter("action"));

        VesselOwner owner = vesselOwnerDao.findById(vesselOwnerId).get();

        if (StandardWebParameter.ADD.equalsIgnoreCase(action) || StandardWebParameter.MODIFY.equalsIgnoreCase(action)) {

        } else if (StandardWebParameter.VIEW.equalsIgnoreCase(action)) {

        }

        mv.addObject("vesselOwner", owner);
        mv.addObject("flags", flagDao.findAll());
        return mv;
    }

    @PostMapping(value = "/vessel_owner_details", consumes = {MediaType.MULTIPART_FORM_DATA_VALUE})
    public ModelAndView addVesselOwner(HttpServletRequest req, @RequestParam("ownerName") String ownerName,
                                       @RequestParam("website") String website,
                                       @RequestParam("emailId") String emailId,
                                       @RequestParam("primaryFlag") String primaryFlag,
                                       @RequestParam("regFlag") String regFlag,
                                       @RequestParam("primaryContact") String primaryContact,
                                       @RequestParam("secondaryContact") String secondaryContact,
                                       @RequestParam("primaryAddr") String primaryAddr,
                                       @RequestParam("regAddr") String regAddr,
                                       @RequestParam("yearOfStart") int yearOfStart,
                                       @RequestParam("image") MultipartFile image,
                                       Model model) {
        Employee user = (Employee) req.getSession().getAttribute("currentUser");
        ModelAndView mv = new ModelAndView("/vessel/vessel_owner_list");
        System.out.println("ownerName: " + ownerName);
        System.out.println("image: " + image);

        VesselOwner owner = new VesselOwner();
        owner.setOwnerName(ownerName);
        owner.setWebsite(website);
        owner.setEmailId(emailId);
        owner.setPrimaryFlag(flagDao.getByCode(primaryFlag).getId());
        owner.setRegisterdFlag(flagDao.getByCode(regFlag).getId());
        owner.setYearOfStart(yearOfStart);
        owner.setPrimaryContact(primaryContact);
        owner.setSecondaryContact(secondaryContact);
        owner.setPrimaryAddress(primaryAddr);
        owner.setRegisterdAddress(regAddr);
        owner.setEnteredBy(user.getEmpId());
        owner.setId(sequenceGenerator.generateSequence(VesselOwner.SEQUENCE_NAME));
        vesselOwnerDao.insert(owner);

        long ownerId = owner.getId();
        System.out.println("New ownerId ---> " + ownerId);
        mv.addObject("ownerId", ownerId);

        try {
            VesselOwnerPhoto photo = new VesselOwnerPhoto(ownerId, String.valueOf(ownerId));
            photo.setId(sequenceGenerator.generateSequence(VesselOwnerPhoto.SEQUENCE_NAME));
            photo.setImage(new Binary(BsonBinarySubType.BINARY, image.getBytes()));
            photo = vesselOwnerPhotoDao.insert(photo);
            long photoId = photo.getId();
            System.out.println("OwnerId ---> " + ownerId + " Photo ID: " + photoId);

            photo = vesselOwnerPhotoDao.findById(photoId).get();
            //model.addAttribute("title", photo.getTitle());

            owner.setPhotoId(photoId);
            vesselOwnerDao.save(owner);
            mv.addObject("image", Base64.getEncoder().encodeToString(photo.getImage().getData()));

        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return mv;
    }
    /*********************************************** Vessel Owner End ***********************************/


    /*********************************************** Vessel Vacancy Start ***********************************/
    @GetMapping(value = "/vessel_vacancy_details")
    public ModelAndView addVesselVacancy(HttpServletRequest req) {
        ModelAndView mv = new ModelAndView("vessel/vessel_vacancy_details");
        String action = StringUtil.trim(req.getParameter("action"));
        if (StandardWebParameter.ADD.equalsIgnoreCase(action)) {

        } else if (StandardWebParameter.MODIFY.equalsIgnoreCase(action)) {

        }
        return mv;
    }



	/*@GetMapping(value = "/edit")
	public ModelAndView editVessel(HttpServletRequest req) {
		ModelAndView mv = new ModelAndView("/vessel/vessel_details");

		Employee emp = employeeDao.findById(1l).get();
		long vesselId = ParamUtil.parseLong(req.getParameter("vesselId"), -1);
		if (vesselId > 0) {
			Vessel vessel = vesselDao.findById(vesselId).get();

			VesselFieldStatus fs = vessel.getFieldStatus();

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
		mv.addObject("action", "Edit");
		mv.addObject("rankMap", Rank.getByGroup());
		return mv;
	}*/

    @GetMapping(value = "/add_vacancy")
    public ModelAndView getVacancyDetails(@RequestParam("vesselId") long vesselId, Model model) {
        ModelAndView mv = new ModelAndView("vessel/vacancy_details");

        return mv;
    }

    @PostMapping(value = "/add_vacancy")
    public ModelAndView addVacancyToVessel(@RequestParam("vesselId") long vesselId, Model model) {
        ModelAndView mv = new ModelAndView("vessel/vacancy_list");

        //Find Vessel
        Vessel vessel = vesselDao.findById(vesselId).get();

        VesselVacancy vacancy = new VesselVacancy();
        vacancy.setId(sequenceGenerator.generateSequence(VesselVacancy.SEQUENCE_NAME));
        vacancy.setVesselId(vessel.getId());

        //All Vacancies

        //Vacancy#1
        VesselVacancyAttributes att = new VesselVacancyAttributes();
        //Add Min Rank Attributes
        att.setMinRankList(new ArrayList<>(Arrays.asList(Rank.JR_ENGINEER.getId())));

        //Add Min Vessel Type Attributes
        /*att.setMinVesselSubTypeIdList(new ArrayList<>(Arrays.asList(
                VesselSubType.LNG_TANKER.getId(),
                VesselSubType.LPG_TANKER.getId(),
                VesselSubType.FSO_TANKER.getId(),
                VesselSubType.OIL_PROD_TANKER.getId()
        )));*/

        //Min Gross Tonn
        att.setMinGrossTonnage(1000);
        vacancy.setVacancyAttributes(att);
        vacancy.setStatusId(VesselVacancy.Status.OPEN.getId());
        vesselVacancyDao.insert(vacancy);

        //mongoTemplate.getCollection(VESSEL_VACANCY).insertMany(vacancies);
        return mv;
    }

    @GetMapping(value = "/vacancy_list")
    public ModelAndView getVacancyList(@RequestParam("vesselId") long vesselId, Model model) {
        ModelAndView mv = new ModelAndView("vessel/vacancy_list");
        List<VesselVacancy> list = null;
        if (vesselId > 0) {
            list = vesselVacancyDao.findVacanciesByVessel(vesselId);
        } else {
            list = vesselVacancyDao.findAll();
        }
        mv.addObject("list", list);
        return mv;
    }


    @GetMapping(value = "/vacancy_list_for_crew")
    public ModelAndView assignVessel(HttpServletRequest req, Model model) {
        ModelAndView mv = new ModelAndView("vessel/vacancy_list");

        long crewId = ParamUtil.parseLong(req.getParameter("crewId"), -1);
        List<VesselVacancy> vacancies = new ArrayList<>();
        if (crewId > 0) {
            Crew crew = crewDao.findById(crewId).get();
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
                v.setFilledByCrew(crewDao.findById(v.getFilledByCrewId()).get());
            }
            v.setStatus(VesselVacancy.Status.createFromId(v.getStatusId()));
            System.out.print(" ]");
            System.out.println();
        });
        mv.addObject("vacancies", vacancies);
        return mv;
    }

    /*********************************************** Vessel Vacancy End ***********************************/

    /*********************************************** Vessel Documents Start ***********************************/
    @GetMapping(value = "/document_list")
    public ModelAndView vesselDocList(Model model) {
        ModelAndView mv = new ModelAndView("vessel/document_list");
        //mv.addObject("list", vesselDao.findAll());
        return mv;
    }

    /*********************************************** Vessel Documents End ***********************************/
}
