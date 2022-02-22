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
package com.shipping.web.ship;


import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.shipping.service.crew.CrewService;
import com.shipping.service.ship.ShipService;

@Controller
@RequestMapping(value="/ship")
public class ShipController {
	@Autowired private ShipService shipService;
	
    @GetMapping(value = "/ship_list")
    public ModelAndView shipList(Model model) {
    	ModelAndView mv = new ModelAndView("ship/ship_list");
        return mv;
    }
    @GetMapping(value = "/ship_manager_list")
    public ModelAndView shipManagerList(Model model) {
    	ModelAndView mv = new ModelAndView("ship/ship_manager_list");
        return mv;
    }
    
    @GetMapping(value = "/add_ship")
    public ModelAndView addShip(Model model) {
    	ModelAndView mv = new ModelAndView("ship/add_ship");
        return mv;
    }
    
    @GetMapping(value = "/add_ship_manager")
    public ModelAndView addShipManager(Model model) {
    	ModelAndView mv = new ModelAndView("ship/add_ship_manager");
        return mv;
    }
    

}
