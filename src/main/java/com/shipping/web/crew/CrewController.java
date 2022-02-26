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
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.bson.BsonBinarySubType;
import org.bson.types.Binary;
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

import com.shipping.dao.crew.CrewRepository;
import com.shipping.dao.crew.PhotoRepository;
import com.shipping.model.crew.Crew;
import com.shipping.model.crew.CrewPhoto;
import com.shipping.model.crew.Rank;
import com.shipping.model.vessel.VesselSubType;
import com.shipping.service.common.SequenceGeneratorService;

@Controller
@RequestMapping(value = "/crew")
public class CrewController {
	@Autowired
	private CrewRepository crewDao;
    @Autowired
    private PhotoRepository photoDao;
	@Autowired
	private SequenceGeneratorService sequenceGenerator;	

	@GetMapping(value = "/crew_list")
	public ModelAndView crewList(Model model) {
		ModelAndView mv = new ModelAndView("crew/crew_list");
		List<Crew> list = crewDao.findAll();
		mv.addObject("list", list);
		return mv;
	}

	@GetMapping(value = "/add_crew")
	public ModelAndView addCrew(Model model) {
		ModelAndView mv = new ModelAndView("crew/add_crew");
		/*
		 * Map<String, List<Rank>> rankMap = Rank.getByGroup();
		 * rankMap.keySet().forEach(k->rankMap.get(k).forEach(v-> { System.out.println(k
		 * + " - " +v.getName()); }));
		 */
		
		mv.addObject("rankMap", Rank.getByGroup());
		return mv;
	}

	@PostMapping(value = "/add_crew", consumes = { MediaType.MULTIPART_FORM_DATA_VALUE })
	public ModelAndView addCrew(
			@RequestParam("fName") String fName, 
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
		crew.setRank(Rank.createFromId(rankId));
		crew.setGenderId(genderId);
		crew.setId(sequenceGenerator.generateSequence(Crew.SEQUENCE_NAME));
		crewDao.insert(crew);
		
		long crewId = crew.getId();
		System.out.println("New crewId ---> " + crewId);
		mv.addObject("crewId", crewId);
		
		try {
			CrewPhoto photo = new CrewPhoto(crewId, fName + " " +mName +" "+ lName);			
			photo.setId(sequenceGenerator.generateSequence(CrewPhoto.SEQUENCE_NAME));
	        photo.setImage(new Binary(BsonBinarySubType.BINARY, image.getBytes()));
	        photo = photoDao.insert(photo);
			System.out.println("CrewId ---> " + crewId + " Photo ID: "+photo.getId());
			
			photo = photoDao.findById(photo.getId()).get();
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

	/*
	 * @PostMapping("/photos/add") public String addPhoto(@RequestParam("title")
	 * String title, @RequestParam("image") MultipartFile image, Model model) throws
	 * IOException { String id = photoService.addPhoto(title, image); return
	 * "redirect:/photos/" + id; }
	 */
}
