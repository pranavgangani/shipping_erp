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
package com.shipping.web.crew;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.shipping.crew.service.CrewService;
import com.shipping.service.HelloWorldService;

@Controller
@RequestMapping(value="/crew")
public class CrewController {
	@Autowired private CrewService crewService;
	
    @GetMapping(value = "/crew_list")
    public ModelAndView crewList(Model model) {
    	ModelAndView mv = new ModelAndView("crew/crew_list");
        return mv;
    }
    
    @GetMapping(value = "/add_crew")
    public ModelAndView addCrew(Model model) {
    	ModelAndView mv = new ModelAndView("crew/add_crew");
        return mv;
    }
    
    
    @GetMapping(value = "/profile")
    public ModelAndView profile(Model model) {
    	ModelAndView mv = new ModelAndView("crew/profile");
        return mv;
    }
	/*
	 * 
	 * 
	 * @GetMapping("/hello")
	 * 
	 * @ResponseBody public String helloWorld() {
	 * System.out.println("helloWorld..."); return
	 * this.helloWorldService.getHelloMessage(); }
	 */
}
