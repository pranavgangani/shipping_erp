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
package com.intuitbrains.web;

import com.intuitbrains.common.AuditTrail;
import com.intuitbrains.common.Collection;
import com.intuitbrains.dao.common.AuditTrailRepository;
import com.intuitbrains.model.company.Employee;
import com.intuitbrains.model.crew.Crew;
import com.intuitbrains.service.company.CustomUserDetailsService;
import com.intuitbrains.service.crew.CrewService;
import com.intuitbrains.util.ListUtil;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;
import org.bson.conversions.Bson;
import org.bson.json.JsonWriterSettings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.stream.Collectors;


import static com.mongodb.client.model.Accumulators.push;
import static com.mongodb.client.model.Accumulators.sum;
import static com.mongodb.client.model.Aggregates.*;
import static com.mongodb.client.model.Filters.eq;
import static com.mongodb.client.model.Projections.*;
import static com.mongodb.client.model.Sorts.descending;

@Controller
public class AuthController {
    @Autowired
    private CustomUserDetailsService userService;
    @Autowired
    private AuditTrailRepository auditTrailDao;
    @Autowired
    private CrewService crewService;

    @GetMapping(value = "/dashboard")
    public ModelAndView dashboard(HttpServletRequest request) {
        HttpSession session = request.getSession();
        ModelAndView mv = new ModelAndView();
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        Employee user = userService.findUserByEmailId(auth.getName());

        List<AuditTrail> auditTrails = auditTrailDao.findAll(Sort.by(Sort.Direction.DESC, "actionLocalDateTime")).stream().limit(7).collect(Collectors.toList());

        if (ListUtil.isNotEmpty(auditTrails)) {
            //System.out.println("auditTrails = " + auditTrails.size());
            mv.addObject("auditTrails", auditTrails);
        }
        session.setAttribute("currentUser", getRestrictedEmpObj(user));
        session.setAttribute("fullName", user.getFullName());

        List<Crew> list = crewService.getList();
        mv.addObject("list", list);

        //Get Count of documents expiring in next 6 months
        //Get Count of pending review crews
        //Get Count of new recruits added
        //Get Count of ready for sign-off
        //Get Count of ready for sign-on

        //modelAndView.addObject("adminMessage", "Content Available Only for Users with Admin Role");
        mv.setViewName("dashboard");
        return mv;
    }

    private Employee getRestrictedEmpObj(Employee emp){
        Employee newEmp = new Employee();
        newEmp.setEmpId(emp.getEmpId());
        newEmp.setFirstName(emp.getFirstName());
        newEmp.setLastName(emp.getLastName());
        newEmp.setMiddleName(emp.getMiddleName());
        newEmp.setEmailId(emp.getEmailId());
        return newEmp;
    }
}
