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
package com.shipping.web;

import com.shipping.dao.company.EmployeeRepository;
import com.shipping.model.company.Employee;
import com.shipping.model.crew.Crew;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@RestController
public class LoginController {
    @Autowired
    private EmployeeRepository employeeDao;

    @GetMapping("/login")
    public String login(Model model) {
        model.addAttribute("message", "hello");
        return "login";
    }

    @GetMapping(value = "dashboard")
    public ModelAndView dashboard() {
        ModelAndView modelAndView = new ModelAndView();
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        Employee emp = employeeDao.findByFirstUserNamePass(auth.getName(), "");
        modelAndView.addObject("currentUser", emp);
        modelAndView.addObject("fullName", "Welcome " + emp.getName());
        modelAndView.addObject("adminMessage", "Content Available Only for Users with Admin Role");
        modelAndView.setViewName("dashboard");
        return modelAndView;
    }

    @GetMapping(value = {"/home", "/index"})
    public ModelAndView home() {
        return new ModelAndView("index");
    }


}
