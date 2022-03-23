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


import com.intuitbrains.common.AuditTrail;
import com.intuitbrains.common.Collection;
import com.intuitbrains.dao.common.AuditTrailRepository;
import com.intuitbrains.dao.common.FlagRepository;
import com.intuitbrains.dao.company.EmployeeRepository;
import com.intuitbrains.dao.crew.CrewRepository;
import com.intuitbrains.dao.vessel.*;
import com.intuitbrains.model.company.Employee;
import com.intuitbrains.model.crew.Crew;
import com.intuitbrains.model.crew.Rank;
import com.intuitbrains.model.vessel.*;
import com.intuitbrains.service.common.SequenceGeneratorService;
import com.intuitbrains.util.ListUtil;
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

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.*;

@Controller
@RequestMapping(value = "/vessel")
public class VesselOwnerController {
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

    @GetMapping(value = "/vessel_owner_list")
    public ModelAndView vesselOwnerList(Model model) {
        ModelAndView mv = new ModelAndView("vessel/vessel_owner_list");
        mv.addObject("list", vesselOwnerDao.findAll());
        return mv;
    }

    @PostMapping(value = "/add_vessel_owner", consumes = {MediaType.MULTIPART_FORM_DATA_VALUE})
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
        ModelAndView mv = new ModelAndView("redirect:/vessel/vessel_owner_list");
        System.out.println("ownerName: " + ownerName);
        System.out.println("image: " + image);
        String empId = user.getEmpId();

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
        owner.setEnteredBy(empId);
        owner.setEnteredLocalDateTime(LocalDateTime.now());
        owner.setId(sequenceGenerator.generateSequence(VesselOwner.SEQUENCE_NAME));
        vesselOwnerDao.insert(owner);

        long ownerId = owner.getId();
        System.out.println("New ownerId ---> " + ownerId);
        mv.addObject("vesselOwner", owner);

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

        //Audit
        AuditTrail audit = new AuditTrail();
        audit.setAction(StandardWebParameter.ADD);
        audit.setActionBy(empId);
        audit.setActionLocalDateTime(LocalDateTime.now());
        audit.setCollection(Collection.VESSEL_OWNER);
        audit.setText("New Vessel Owner - <b>" + (owner.getOwnerName()) + "</b> added!");
        audit.setId(sequenceGenerator.generateSequence(AuditTrail.SEQUENCE_NAME));
        audit.setUniqueId(ownerId);
        auditTrailDao.insert(audit);
        return mv;
    }

    @PostMapping(value = "/update_vessel_owner", consumes = {MediaType.MULTIPART_FORM_DATA_VALUE})
    public ModelAndView updateVesselOwner(MultipartHttpServletRequest req, Model model) {
        Employee user = (Employee) req.getSession().getAttribute("currentUser");
        ModelAndView mv = new ModelAndView("redirect:/vessel/vessel_owner_list");

        long vesselOwnerId = ParamUtil.parseLong(req.getParameter("vesselOwnerId"), -1);
        VesselOwner persistedVesselOwner = vesselOwnerDao.findById(vesselOwnerId).get();

        String empId = user.getEmpId();
        String ownerName = req.getParameter("ownerName");
        String website = req.getParameter("website");
        String emailId = req.getParameter("emailId");
        String primaryFlag = req.getParameter("primaryFlag");
        String regFlag = req.getParameter("regFlag");
        String primaryContact = req.getParameter("primaryContact");
        String secondaryContact = req.getParameter("secondaryContact");
        String primaryAddr = req.getParameter("primaryAddr");
        String regAddr = req.getParameter("regAddr");
        int yearOfStart = ParamUtil.parseInt(req.getParameter("yearOfStart"), -1);

        persistedVesselOwner.setOwnerName(ownerName);
        persistedVesselOwner.setWebsite(website);
        persistedVesselOwner.setEmailId(emailId);
        persistedVesselOwner.setPrimaryFlag(flagDao.getByCode(primaryFlag).getId());
        persistedVesselOwner.setRegisterdFlag(flagDao.getByCode(regFlag).getId());
        persistedVesselOwner.setYearOfStart(yearOfStart);
        persistedVesselOwner.setPrimaryContact(primaryContact);
        persistedVesselOwner.setSecondaryContact(secondaryContact);
        persistedVesselOwner.setPrimaryAddress(primaryAddr);
        persistedVesselOwner.setRegisterdAddress(regAddr);
        persistedVesselOwner.setEnteredBy(empId);
        persistedVesselOwner.setEnteredLocalDateTime(LocalDateTime.now());
        vesselOwnerDao.save(persistedVesselOwner);

        mv.addObject("vesselOwner", persistedVesselOwner);

        try {
            MultipartFile image = req.getFile("image");
            if (image != null) {
                VesselOwnerPhoto photo = new VesselOwnerPhoto(vesselOwnerId, String.valueOf(vesselOwnerId));
                photo.setId(persistedVesselOwner.getPhotoId());
                photo.setImage(new Binary(BsonBinarySubType.BINARY, image.getBytes()));
                photo = vesselOwnerPhotoDao.save(photo);
                long photoId = photo.getId();
                System.out.println("OwnerId ---> " + vesselOwnerId + " Photo ID: " + photoId);

                photo = vesselOwnerPhotoDao.findById(photoId).get();
                //model.addAttribute("title", photo.getTitle());
                mv.addObject("image", Base64.getEncoder().encodeToString(photo.getImage().getData()));
            }

        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        //Audit
        AuditTrail audit = new AuditTrail();
        audit.setAction(StandardWebParameter.MODIFY);
        audit.setActionBy(empId);
        audit.setActionLocalDateTime(LocalDateTime.now());
        audit.setCollection(Collection.VESSEL_OWNER);
        audit.setText("Modified Vessel Owner - <b>" + (persistedVesselOwner.getOwnerName()) + "</b>!");
        audit.setId(sequenceGenerator.generateSequence(AuditTrail.SEQUENCE_NAME));
        audit.setUniqueId(vesselOwnerId);
        auditTrailDao.insert(audit);

        return mv;
    }


    @GetMapping(value = "/vessel_owner_details")
    public ModelAndView vesselOwnerDetails(HttpServletRequest req) {
        ModelAndView mv = new ModelAndView("vessel/vessel_owner_details");
        long vesselOwnerId = ParamUtil.parseLong(req.getParameter("vesselOwnerId"), -1);

        if (vesselOwnerId > 0) {
            VesselOwner owner = vesselOwnerDao.findById(vesselOwnerId).get();

            if (owner.getPrimaryFlag() != null) {
                owner.setPrimaryFlagObj(flagDao.findById(owner.getPrimaryFlag()).get());
            }
            if (owner.getRegisterdFlag() != null) {
                owner.setRegisterdFlagObj(flagDao.findById(owner.getRegisterdFlag()).get());
            }

            //Audit Trails
            List<AuditTrail> auditTrails = auditTrailDao.getAudit(Collection.VESSEL_OWNER, vesselOwnerId);
            if (ListUtil.isNotEmpty(auditTrails)) {
                System.out.println("auditTrails = " + auditTrails.size());
                mv.addObject("auditTrails", auditTrails);
            } else {
                System.out.println("No auditTrails");
            }
            //Photo
            try {
                VesselOwnerPhoto photo = vesselOwnerPhotoDao.findById(owner.getPhotoId()).get();
                //mv.addObject("title", photo.getTitle());
                mv.addObject("image", Base64.getEncoder().encodeToString(photo.getImage().getData()));
            } catch (NoSuchElementException e) {
                e.printStackTrace();
            }
            mv.addObject("vesselOwner", owner);

        }

        mv.addObject("flags", flagDao.findAll());
        return mv;
    }


    @GetMapping(value = "/owner_vessel_list")
    public ModelAndView vesselList(HttpServletRequest req) {
        ModelAndView mv = new ModelAndView("vessel/vessel_details_list");
        long vesselOwnerId = ParamUtil.parseLong(req.getParameter("vesselOwnerId"), -1);

        VesselOwner owner = vesselOwnerDao.findById(vesselOwnerId).get();

        mv.addObject("list", vesselDao.findByVesselOwner(vesselOwnerId));
        mv.addObject("vesselOwnerId", vesselOwnerId);

        //Photo
        try {
            VesselOwnerPhoto photo = vesselOwnerPhotoDao.findById(owner.getPhotoId()).get();
            //mv.addObject("title", photo.getTitle());
            mv.addObject("image", Base64.getEncoder().encodeToString(photo.getImage().getData()));
        } catch (NoSuchElementException e) {
            e.printStackTrace();
        }
        return mv;
    }
}
