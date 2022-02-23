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

import java.io.IOException;
import java.util.Base64;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.shipping.model.crew.Crew;
import com.shipping.model.crew.Photo;
import com.shipping.service.crew.CrewService;
import com.shipping.service.crew.PhotoService;

@Controller
@RequestMapping(value = "/crew")
public class CrewController {
	@Autowired
	private CrewService crewService;
	@Autowired
	private PhotoService photoService;

	@GetMapping(value = "/crew_list")
	public ModelAndView crewList(Model model) {
		ModelAndView mv = new ModelAndView("crew/crew_list");
		List<Crew> list = crewService.getCrewList(new Crew());
		mv.addObject("list", list);
		return mv;
	}

	@GetMapping(value = "/add_crew")
	public ModelAndView addCrew(Model model) {
		ModelAndView mv = new ModelAndView("crew/add_crew");
		return mv;
	}

	@PostMapping(value = "/add_crew", consumes = { MediaType.MULTIPART_FORM_DATA_VALUE })
	public ModelAndView addCrew(@RequestParam("fName") String fName, 
			@RequestParam("mName") String mName, 
			@RequestParam("lName") String lName, 
			@RequestParam("rankId") int rankId, 
			@RequestParam("genderId") int genderId, 
			@RequestParam("manningOffice") String manningOffice, 
			@RequestParam("image") MultipartFile image, 
			Model model) {
		ModelAndView mv = new ModelAndView("/crew/add_employment");
		System.out.println("add_crew: " + fName);
		System.out.println("image: " + image);
		
		Crew crew = new Crew();
		crew.setfName(fName); 
		crew.setlName(lName);
		crew.setmName(mName);
		crew.setRankId(rankId);
		crew.setGenderId(genderId);
		crewService.addCrew(crew);
		
		long crewId = crew.getId();
		System.out.println("New crewId ---> " + crewId);
		mv.addObject("crewId", crewId);
		
		try {
			Photo photo = new Photo(crewId, fName + " " +mName +" "+ lName);
			String photoId = photoService.addPhoto(photo, image);
			System.out.println("CrewId ---> " + crewId + " Photo ID: "+photoId);
			
			photo = photoService.getPhoto(photoId);
			//model.addAttribute("title", photo.getTitle());
			mv.addObject("image", Base64.getEncoder().encodeToString(photo.getImage().getData()));
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
//		return "redirect:/photos/" + id;


		return mv;
	}

	@GetMapping(value = "/add_employment")
	public ModelAndView addEmployment(Model model) {
		ModelAndView mv = new ModelAndView("crew/add_employment");
		return mv;
	}

	@PostMapping(value = "/add_employment")
	public ModelAndView addEmployment(HttpServletRequest req) {
		ModelAndView mv = new ModelAndView("crew/add_employment");
		int crewId = Integer.parseInt(req.getParameter("crewId"));
		return mv;
	}

	@GetMapping(value = "/add_education")
	public ModelAndView addEducation(Model model) {
		ModelAndView mv = new ModelAndView("crew/add_education");
		return mv;
	}

	@GetMapping(value = "/add_passport_visa")
	public ModelAndView addPassportVisa(Model model) {
		ModelAndView mv = new ModelAndView("crew/add_passport_visa");
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
	public String getPhoto(@PathVariable String id, Model model) {
		Photo photo = photoService.getPhoto(id);
		model.addAttribute("title", photo.getTitle());
		model.addAttribute("image", Base64.getEncoder().encodeToString(photo.getImage().getData()));
		return "photos";
	}

	@GetMapping("/photos/upload")
	public String uploadPhoto(Model model) {
		model.addAttribute("message", "hello");
		return "uploadPhoto";
	}

	/*
	 * @PostMapping("/photos/add") public String addPhoto(@RequestParam("title")
	 * String title, @RequestParam("image") MultipartFile image, Model model) throws
	 * IOException { String id = photoService.addPhoto(title, image); return
	 * "redirect:/photos/" + id; }
	 */
}
