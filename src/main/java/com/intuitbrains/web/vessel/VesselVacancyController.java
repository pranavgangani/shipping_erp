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
import com.intuitbrains.service.crew.CrewService;
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
public class VesselVacancyController {
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
    private CrewService crewService;

    @GetMapping(value = "/vacancy_details")
    public ModelAndView addVesselVacancy(HttpServletRequest req) {
        ModelAndView mv = new ModelAndView("vessel/vacancy_details");
        String action = StringUtil.trim(req.getParameter("action"));
        if (StandardWebParameter.ADD.equalsIgnoreCase(action)) {

        } else if (StandardWebParameter.MODIFY.equalsIgnoreCase(action)) {

        }
        return mv;
    }

    @GetMapping(value = "/vacancy_list")
    public ModelAndView getVacancyList(HttpServletRequest req, Model model) {
        ModelAndView mv = new ModelAndView("vessel/vacancy_list");
        long vesselId = ParamUtil.parseLong(req.getParameter("vesselId"), -1);
        List<VesselVacancy> list = null;
        if (vesselId > 0) {
            list = vesselVacancyDao.findVacanciesByVessel(vesselId);
        } else {
            list = vesselVacancyDao.findAll();
        }
        mv.addObject("vessels", vesselDao.findAll());
        mv.addObject("rankMap", Rank.getByGroup());
        mv.addObject("list", list);
        return mv;
    }

    @PostMapping(value = "/add_vacancy")
    public ModelAndView addVacancy(@RequestParam("vesselId") long vesselId, Model model) {
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



    @GetMapping(value = "/vacancy_list_for_crew")
    public ModelAndView assignVessel(HttpServletRequest req, Model model) {
        ModelAndView mv = new ModelAndView("vessel/vacancy_list");

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

            v.setStatus(VesselVacancy.Status.createFromId(v.getStatusId()));
            System.out.print(" ]");
            System.out.println();
        });
        mv.addObject("vacancies", vacancies);
        return mv;
    }


    @GetMapping(value = "/assign_crew")
    public ModelAndView assignCrew(HttpServletRequest req) {
        ModelAndView mv = new ModelAndView("/vessel/assign_crew");
        long vacancyId = ParamUtil.parseLong(req.getParameter("vacancyId"), -1);
        List<Crew> crewList = crewService.getReadyToSignOffCrew();
        VesselVacancy vacancy = vesselVacancyDao.findById(vacancyId).get();
        mv.addObject("vacancy", vacancy);
        //mv.addObject("vessels", vesselDao.findAll());
        //mv.addObject("rankMap", Rank.getByGroup());
        mv.addObject("crewList", crewList);
        return mv;
    }

    @PostMapping(value = "/fill_vacancy")
    public ModelAndView fillVacancy(HttpServletRequest req) {
        ModelAndView mv = new ModelAndView("/vessel/assign_crew");
        long vacancyId = ParamUtil.parseLong(req.getParameter("vacancyId"), -1);
        String crewIdsParam = req.getParameter("crewIds");
        String[] crewIdArray = crewIdsParam.split(",");
        for(int i=0;i<crewIdArray.length;i++){
            long crewId = ParamUtil.parseLong(crewIdArray[i], -1);
            if(crewId>0){
                //crewService.
            }
        }


        return mv;
    }

    @GetMapping(value = "/add_vacancy")
    public ModelAndView addVacancy(HttpServletRequest req) {
        ModelAndView mv = new ModelAndView("/vessel/assign_crew");
        long vacancyId = ParamUtil.parseLong(req.getParameter("vacancyId"), -1);
        List<Crew> crewList = crewService.getReadyToSignOffCrew();
        VesselVacancy vacancy = vesselVacancyDao.findById(vacancyId).get();
        mv.addObject("vacancy", vacancy);
        //mv.addObject("vessels", vesselDao.findAll());
        //mv.addObject("rankMap", Rank.getByGroup());
        mv.addObject("crewList", crewList);
        return mv;
    }
}
