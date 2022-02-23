package com.shipping.service.settings;

import java.io.IOException;
import java.util.Base64;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.shipping.model.crew.Crew;
import com.shipping.model.crew.Photo;
import com.shipping.model.crew.Rank;

@Controller
@RequestMapping(value = "/settings")
public class RankController {
	@Autowired
	private RankService rankService;
	
	@GetMapping(value = "/ranks")
	public ModelAndView rankList(Model model) {
		ModelAndView mv = new ModelAndView("settings/rank_list");
		List<Rank> list = rankService.getRankList(new Rank());
		//list.forEach(i -> System.out.println("-----%%%%%%%%%%% "+i.getName()));
		mv.addObject("list", list);
		return mv;
	}
	
	@GetMapping(value = "/add_rank")
	public ModelAndView addRank(Model model) {
		ModelAndView mv = new ModelAndView("settings/add_rank");
		return mv;
	}
	
	@PostMapping(value = "/add_rank")
	public ModelAndView addRank(@RequestParam("rankName") String rankName, 
			@RequestParam("rankCategoryId") int rankCategoryId, 
			@RequestParam("rankSubCategoryId") int rankSubCategoryId) {
		ModelAndView mv = new ModelAndView("settings/rank_list");
		System.out.println("rankName: " + rankName);
		
		Rank rank = new Rank();
		rank.setName(rankName);
		rank.setRankCategoryId(rankCategoryId);
		rank.setRankSubCategoryId(rankSubCategoryId);
		rankService.addRank(rank);
		int rankId = (int) rank.getId();
		System.out.println("New rankId ---> " + rankId);
		mv.addObject("crewId", rankId);
		return mv;
	}

}
