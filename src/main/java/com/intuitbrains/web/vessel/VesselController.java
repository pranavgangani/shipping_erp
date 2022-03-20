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
import java.util.*;
import java.time.LocalDateTime;

import com.intuitbrains.common.AuditTrail;
import com.intuitbrains.common.Collection;
import com.intuitbrains.dao.common.AuditTrailRepository;
import com.intuitbrains.dao.company.EmployeeRepository;
import com.intuitbrains.dao.crew.CrewRepository;
import com.intuitbrains.dao.vessel.*;
import com.intuitbrains.model.company.Employee;
import com.intuitbrains.model.crew.Rank;
import com.intuitbrains.model.vessel.*;
import com.intuitbrains.util.ListUtil;
import com.intuitbrains.util.ParamUtil;

import org.bson.BsonBinarySubType;
import org.bson.types.Binary;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
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

    @GetMapping(value = "/vessel_list")
    public ModelAndView vesselList(HttpServletRequest req) {
        ModelAndView mv = new ModelAndView();
        long vesselOwnerId = ParamUtil.parseLong(req.getParameter("vesselOwnerId"), -1);

        List<Vessel> list = null;
        if (vesselOwnerId > 0) {
            list = vesselDao.findByVesselOwner(vesselOwnerId);
            mv.setViewName("vessel/vessel_details_list");
        } else {
            list = vesselDao.findAll();
            mv.setViewName("vessel/vessel_list");
        }
        mv.addObject("list", list);
        return mv;
    }

    @PostMapping(value = "/add_vessel", consumes = {MediaType.MULTIPART_FORM_DATA_VALUE})
    public ModelAndView addVessel(MultipartHttpServletRequest req, Model model) {
        ModelAndView mv = new ModelAndView("redirect:/vessel/vessel_list");
        long vesselOwnerId = ParamUtil.parseLong(req.getParameter("vesselOwnerId"), -1);
        long vesselId = ParamUtil.parseLong(req.getParameter("vesselId"), -1);
        Vessel vessel = new Vessel();
        Employee user = (Employee) req.getSession().getAttribute("currentUser");
        String empId = user.getEmpId();

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
        vessel.setEnteredBy(empId);
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


            //Audit
            AuditTrail audit = new AuditTrail();
            audit.setAction("add");
            audit.setActionBy(empId);
            audit.setActionDateTime(LocalDateTime.now());
            audit.setCollection(Collection.VESSEL);
            audit.setText("New Vessel Owner - <b>" + (vessel.getVesselName()) + "</b> added!");
            audit.setId(sequenceGenerator.generateSequence(AuditTrail.SEQUENCE_NAME));
            audit.setUniqueId(vesselId);
            auditTrailDao.insert(audit);

        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        mv.addObject("vessel", vessel);
        return mv;
    }

    @GetMapping(value = "/vessel_details")
    public ModelAndView viewDetailsPage(HttpServletRequest req) {
        ModelAndView mv = new ModelAndView("/vessel/vessel_details");
        Employee user = (Employee) req.getSession().getAttribute("currentUser");
        long vesselId = ParamUtil.parseLong(req.getParameter("vesselId"), -1);
        //String action = StringUtil.trim(req.getParameter("action"));

        if (vesselId > 0) {
            Vessel vessel = vesselDao.findById(vesselId).get();
            VesselFieldStatus fs = vessel.getFieldStatus();

            //Audit Trails
            List<AuditTrail> auditTrails = auditTrailDao.getAudit(Collection.VESSEL, vesselId);
            if (ListUtil.isNotEmpty(auditTrails)) {
                System.out.println("auditTrails = " + auditTrails.size());
                mv.addObject("auditTrails", auditTrails);
            } else {
                System.out.println("No auditTrails");
            }
            //Photo
            VesselPhoto photo = null;
            try {
                photo = vesselPhotoDao.findById(vessel.getPhotoId()).get();
                //mv.addObject("title", photo.getTitle());
                mv.addObject("image", Base64.getEncoder().encodeToString(photo.getImage().getData()));
            } catch (NoSuchElementException e) {
                e.printStackTrace();
            }
            mv.addObject("vessel", vessel);

        }
        mv.addObject("flags", flagDao.findAll());
        mv.addObject("vesselTypes", VesselType.getList());
        mv.addObject("vesselSubTypeMap", VesselSubType.getByGroup());
        mv.addObject("vesselOwners", vesselOwnerDao.findAll());
        mv.addObject("rankMap", Rank.getByGroup());
        return mv;
    }


}
