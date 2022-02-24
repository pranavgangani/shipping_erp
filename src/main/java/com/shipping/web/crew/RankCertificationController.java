package com.shipping.web.crew;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.shipping.model.crew.Rank;
import com.shipping.model.crew.RankCertification;
import com.shipping.service.crew.RankCertificationService;
import com.shipping.service.crew.RankService;

@Controller
@RequestMapping(value = "/settings")
public class RankCertificationController {
	@Autowired
	private RankCertificationService rankCertificationService;
	@Autowired
	private RankService rankService;
	
	@GetMapping(value = "/certifications")
	public ModelAndView rankList(Model model) {
		ModelAndView mv = new ModelAndView("settings/certification_list");
		List<RankCertification> list = rankCertificationService.getList(new RankCertification());
		//list.forEach(i -> System.out.println("-----%%%%%%%%%%% "+i.getName()));
		mv.addObject("list", list);
		return mv;
	}


	
	@GetMapping(value = "/assign_certifications")
	public ModelAndView assignCertifications(@RequestParam("rankId") int rankId, Model model) {
		Rank rank = new Rank();
		rank.setId(rankId);
		Optional<Rank> optRank = rankService.get(rank);
		rank = optRank.get();		
		ModelAndView mv = new ModelAndView("settings/assign_certifications");
		mv.addObject("rank", rank);
		
		List<Rank> list = rankService.getRankList(new Rank());
		mv.addObject("list", list);
		return mv;
	}
	
	@PostMapping(value = "/add_certification")
	public ModelAndView addRank(@RequestParam("certName") String certName,			
			@RequestParam("certDesc") String certDesc,
			@RequestParam("rankCategoryId") int rankCategoryId, 
			@RequestParam("rankSubCategoryId") int rankSubCategoryId,
			@RequestParam("rankId") int rankId) {
		ModelAndView mv = new ModelAndView("settings/certification_list");
		System.out.println("certName: " + certName);
		
		RankCertification cert = new RankCertification();
		cert.setName(certName);
		cert.setRankCategoryId(rankCategoryId);
		cert.setRankSubCategoryId(rankSubCategoryId);
		cert.setRankId(rankId);
		rankCertificationService.addCert(cert);
		long certId = cert.getId();
		System.out.println("New certId ---> " + certId);
		mv.addObject("certId", certId);
		return mv;
	}
	
	
	

}
