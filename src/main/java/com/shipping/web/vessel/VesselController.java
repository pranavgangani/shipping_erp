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
package com.shipping.web.vessel;


import java.io.IOException;
import java.util.Base64;
import java.util.HashMap;
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
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.shipping.dao.common.FlagRepository;
import com.shipping.dao.vessel.VesselOwnerPhotoRepository;
import com.shipping.dao.vessel.VesselOwnerRepository;
import com.shipping.dao.vessel.VesselPhotoRepository;
import com.shipping.dao.vessel.VesselRepository;
import com.shipping.model.crew.Crew;
import com.shipping.model.crew.CrewPhoto;
import com.shipping.model.vessel.Vessel;
import com.shipping.model.vessel.VesselOwner;
import com.shipping.model.vessel.VesselOwnerPhoto;
import com.shipping.model.vessel.VesselPhoto;
import com.shipping.model.vessel.VesselSubType;
import com.shipping.model.vessel.VesselType;
import com.shipping.service.common.SequenceGeneratorService;

@Controller
@RequestMapping(value="/vessel")
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
	
    @GetMapping(value = "/vessel_list")
    public ModelAndView vesselList(Model model) {
    	ModelAndView mv = new ModelAndView("vessel/vessel_list");
    	mv.addObject("list", vesselDao.findAll());
        return mv;
    }
    @GetMapping(value = "/vessel_owner_list")
    public ModelAndView vesselOwnerList(Model model) {
    	ModelAndView mv = new ModelAndView("vessel/vessel_owner_list");
    	mv.addObject("list", vesselOwnerDao.findAll());
        return mv;
    }
    
    @GetMapping(value = "/add_vessel")
    public ModelAndView addVessel(Model model) {
    	ModelAndView mv = new ModelAndView("vessel/add_vessel");
    	mv.addObject("flags", flagDao.findAll());
    	mv.addObject("vesselTypes", VesselType.getList());    	
    	mv.addObject("vesselSubTypeMap", VesselSubType.getByGroup());
    	mv.addObject("vesselOwners", vesselOwnerDao.findAll());
        return mv;
    }
    
    @GetMapping(value = "/add_vessel_owner")
    public ModelAndView addVesselManager(Model model) {
    	ModelAndView mv = new ModelAndView("vessel/add_vessel_owner");
        return mv;
    }
    
    @PostMapping(value = "/add_vessel", consumes = { MediaType.MULTIPART_FORM_DATA_VALUE })
	public ModelAndView addVessel(@RequestParam("vesselName") String vesselName, 
			@RequestParam("imo") String imo,
			@RequestParam("vesselOwnerId") long vesselOwnerId,
			@RequestParam("mmsi") String mmsi, 
			@RequestParam("flag") String flag,
			@RequestParam("callSign") String callSign,
			//@RequestParam("homePort") int homeportId, 
			//@RequestParam("vesselTypeId") int vesselTypeId, 
			@RequestParam("vesselSubTypeId") int vesselSubTypeId,
			@RequestParam("length") int length,
			@RequestParam("beam") int beam,
			@RequestParam("draught") int draught,
			@RequestParam("grossTon") int grossTon,
			@RequestParam("yearOfBuilt") int yearOfBuilt,
			@RequestParam("vesselDesc") String vesselDesc,			
			@RequestParam("image") MultipartFile image, 
			Model model) {
		ModelAndView mv = new ModelAndView("redirect:/vessel/vessel_list");
		System.out.println("vesselName: " + vesselName);
		
		Vessel vessel = new Vessel();
		vessel.setVesselName(vesselName);
		vessel.setVesselOwner(vesselOwnerDao.findById(vesselOwnerId).get());
		vessel.setImo(imo);
		vessel.setMmsi(mmsi);
		//vessel.setFlag(flag);
		//vessel.setVesselType(VesselType.createFromId(vesselTypeId));
		vessel.setVesselSubType(VesselSubType.createFromId(vesselSubTypeId));
		vessel.setLength(length);
		vessel.setBeam(beam);
		vessel.setDraught(draught);
		vessel.setCallSign(callSign);
		vessel.setGrossTonnage(grossTon);
		vessel.setYearOfBuilt(yearOfBuilt);
		vessel.setId(sequenceGenerator.generateSequence(Vessel.SEQUENCE_NAME));
		vesselDao.insert(vessel);
		
		long vesselId = vessel.getId();
		System.out.println("New vesselId ---> " + vesselId);
		mv.addObject("vesselId", vesselId);
		
		try {
			VesselPhoto photo = new VesselPhoto(vesselId, String.valueOf(vesselId));
			photo.setId(sequenceGenerator.generateSequence(VesselPhoto.SEQUENCE_NAME));
			photo.setImage(new Binary(BsonBinarySubType.BINARY, image.getBytes()));
			photo = vesselPhotoDao.insert(photo);
			long photoId = photo.getId(); 
			System.out.println("VesselId ---> " + vesselId + " Photo ID: "+photoId);
			
			photo = vesselPhotoDao.findById(photoId).get();
			//model.addAttribute("title", photo.getTitle());
			//mv.addObject("image", Base64.getEncoder().encodeToString(photo.getImage().getData()));
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return mv;
	}
    
    @PostMapping(value = "/add_vessel_owner", consumes = { MediaType.MULTIPART_FORM_DATA_VALUE })
	public ModelAndView addVesselOwner(@RequestParam("ownerName") String ownerName, 
			@RequestParam("website") String website, 
			@RequestParam("emailId") String emailId, 
			//@RequestParam("primaryFlag") String primaryFlag, 
			//@RequestParam("regFlag") String regFlag, 
			@RequestParam("primaryContact") String primaryContact,
			@RequestParam("regContact") String regContact,
			@RequestParam("primaryAddr") String primaryAddr,
			@RequestParam("regAddr") String regAddr,
			@RequestParam("yearOfStart") int yearOfStart,
			@RequestParam("image") MultipartFile image, 
			Model model) {
		ModelAndView mv = new ModelAndView("/vessel/vessel_owner_list");
		System.out.println("ownerName: " + ownerName);
		System.out.println("image: " + image);
		
		VesselOwner owner = new VesselOwner();
		owner.setOwnerName(ownerName); 
		owner.setWebsite(website);
		owner.setEmailId(emailId);
		//owner.setPrimaryCountry(primaryCountry);
		//owner.setFlag(primaryFlag);
		owner.setYearOfStart(yearOfStart);
		owner.setPrimaryAddress(primaryAddr);
		owner.setRegisterdAddress(regAddr);
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
			System.out.println("OwnerId ---> " + ownerId + " Photo ID: "+photoId);
			
			photo = vesselOwnerPhotoDao.findById(photoId).get();
			//model.addAttribute("title", photo.getTitle());
			mv.addObject("image", Base64.getEncoder().encodeToString(photo.getImage().getData()));
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return mv;
	}

}
