package com.intuitbrains.web.crew;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.intuitbrains.model.crew.Rank;

@Controller
@RequestMapping(value = "/settings")
public class RankController {

	@GetMapping(value = "/ranks")
	public ModelAndView rankList(Model model) {
		ModelAndView mv = new ModelAndView("settings/rank_list");
		List<Rank> list = Rank.getList();
		mv.addObject("list", list);
		return mv;
	}

	@GetMapping(value = "/add_rank")
	public ModelAndView addRank(Model model) {
		ModelAndView mv = new ModelAndView("settings/add_rank");
		return mv;
	}
	
	/*
	 * @PostMapping(value = "/add_rank") public ModelAndView
	 * addRank(@RequestParam("rankName") String rankName,
	 * 
	 * @RequestParam("rankCategoryId") int rankCategoryId,
	 * 
	 * @RequestParam("rankSubCategoryId") int rankSubCategoryId) { ModelAndView mv =
	 * new ModelAndView("settings/rank_list"); System.out.println("rankName: " +
	 * rankName);
	 * 
	 * Rank rank = new Rank(); rank.setName(rankName);
	 * rank.setRankCategoryId(rankCategoryId);
	 * rank.setRankSubCategoryId(rankSubCategoryId); rankService.addRank(rank); int
	 * rankId = (int) rank.getId(); System.out.println("New rankId ---> " + rankId);
	 * mv.addObject("crewId", rankId); return mv; }
	 */
	
	/*
	 * @GetMapping(value = "/assign_medicals") public ModelAndView
	 * assignMedicals(@RequestParam("rankId") int rankId, Model model) { Rank rank =
	 * new Rank(rankId); rank.setId(rankId); Optional<Rank> optRank =
	 * rankService.get(rank); rank = optRank.get(); ModelAndView mv = new
	 * ModelAndView("settings/assign_medicals"); mv.addObject("rank", rank);
	 * 
	 * List<Rank> list = rankService.getRankList(new Rank()); mv.addObject("list",
	 * list); return mv; }
	 * 
	 * @GetMapping(value = "/assign_licenses") public ModelAndView
	 * assignLicenses(@RequestParam("rankId") int rankId, Model model) { Rank rank =
	 * new Rank(); rank.setId(rankId); Optional<Rank> optRank =
	 * rankService.get(rank); rank = optRank.get(); ModelAndView mv = new
	 * ModelAndView("settings/assign_licenses"); mv.addObject("rank", rank);
	 * 
	 * List<Rank> list = rankService.getRankList(new Rank()); mv.addObject("list",
	 * list); return mv; }
	 * 
	 * @GetMapping(value = "/assign_documents") public ModelAndView
	 * assignDocuments(@RequestParam("rankId") int rankId, Model model) { Rank rank
	 * = new Rank(); rank.setId(rankId); Optional<Rank> optRank =
	 * rankService.get(rank); rank = optRank.get(); ModelAndView mv = new
	 * ModelAndView("settings/assign_documents"); mv.addObject("rank", rank);
	 * 
	 * List<Rank> list = rankService.getRankList(new Rank()); mv.addObject("list",
	 * list); return mv; }
	 * 
	 * @GetMapping(value = "/assign_surveys") public ModelAndView
	 * assignSurveys(@RequestParam("rankId") int rankId, Model model) { Rank rank =
	 * new Rank(); rank.setId(rankId); Optional<Rank> optRank =
	 * rankService.get(rank); rank = optRank.get(); ModelAndView mv = new
	 * ModelAndView("settings/assign_surveys"); mv.addObject("rank", rank);
	 * 
	 * List<Rank> list = rankService.getRankList(new Rank()); mv.addObject("list",
	 * list); return mv; }
	 */
	@PostMapping(value = "/assign_training_courses")
	public ModelAndView assignTrainingCourseToRank(Model model) {
		ModelAndView mv = new ModelAndView("settings/assign_training_courses");
		return mv;
	}
	

}
