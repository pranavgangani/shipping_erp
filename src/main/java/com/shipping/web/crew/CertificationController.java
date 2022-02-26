package com.shipping.web.crew;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.shipping.dao.crew.CertRepository;
import com.shipping.model.crew.Rank;
import com.shipping.model.crew.RankCategory;
import com.shipping.model.crew.RankSubCategory;
import com.shipping.model.common.DurationType;
import com.shipping.model.crew.Certification;
import com.shipping.service.common.SequenceGeneratorService;

@Controller
@RequestMapping(value = "/settings")
public class CertificationController {
	@Autowired
	private SequenceGeneratorService sequenceGenerator;
	@Autowired
	private CertRepository certRepository;

	@GetMapping(value = "/assign_certifications")
	public ModelAndView assignCertifications(@RequestParam("rankId") int rankId, Model model) {
		ModelAndView mv = new ModelAndView("settings/assign_certifications");
		mv.addObject("durationTypes", DurationType.getList());
		mv.addObject("rank", Rank.createFromId(rankId));
		mv.addObject("rankMap", Rank.getByGroup());
		return mv;
	}
	

	@PostMapping(value = "/add_certification")
	public ModelAndView addCertificationToRank(
			@RequestParam("rankId") int rankId,
			@RequestParam("rankCategoryId") int rankCategoryId,
			@RequestParam("rankSubCategoryId") int rankSubCategoryId,
			@RequestParam("certDuration") int certDuration,
			@RequestParam("durationTypeId") int durationTypeId,
			@RequestParam("certName") String certName,
			@RequestParam("certDesc") String certDesc) {
		ModelAndView mv = new ModelAndView("redirect:/settings/certifications");
		System.out.println("certName: " + certName);

		Certification cert = new Certification();
		cert.setId(sequenceGenerator.generateSequence(Certification.SEQUENCE_NAME));
		cert.setName(certName);
		cert.setRankCategoryId(rankCategoryId);
		cert.setRankSubCategoryId(rankSubCategoryId);
		cert.setRankId(rankId);
		cert.setValidity(certDuration);
		cert.setDurationType(DurationType.createFromId(durationTypeId));
		certRepository.insert(cert);
		long certId = cert.getId();
		System.out.println("New certId ---> " + certId);
		mv.addObject("certId", certId);
		return mv;
	}
	
	@GetMapping(value = "/certifications")
	public ModelAndView certList(Model model) {
		ModelAndView mv = new ModelAndView("settings/certification_list");
		List<Certification> list = certRepository.findAll();
		list.forEach(c->{		
			if(c.getRankId()>0) c.setRank(Rank.createFromId(c.getRankId()));
			if(c.getRankSubCategoryId()>0) c.setRankSubCategory(RankSubCategory.createFromId(c.getRankSubCategoryId()));
			if(c.getRankCategoryId()>0) c.setRankCategory(RankCategory.createFromId(c.getRankCategoryId()));
		});
		
		mv.addObject("list", list);
		return mv;
	}

}
