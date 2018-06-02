package cl.vs.versus2.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import cl.vs.versus2.pojo.MatchResult;
import cl.vs.versus2.service.RankingService;
import cl.vs.versus2.service.UserService;

@Controller
public class RankingController {

	@Autowired
	private UserService userService;
	
	@Autowired
	private RankingService rankingService;

	@GetMapping("/admin/ranking")
	public ModelAndView rankingPage() {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("allUsersRating", userService.getAllUsers());
		return modelAndView;
	}
	
	@GetMapping("/admin/matchResult")
	public ModelAndView showResultForm() {
		ModelAndView mav = new ModelAndView("/admin/matchResult");
		MatchResult matchResult = new MatchResult();
		mav.addObject("matchResult", matchResult);
		return mav;
	}
	
	@PostMapping("/admin/matchResult")
	public String saveEditedUserEloIncrease(@ModelAttribute MatchResult matchResult) {
		rankingService.increaseElo(matchResult.getEmailWinner());
		
		rankingService.decreaseElo(matchResult.getEmailDefeated());
		
		return "redirect:/admin/ranking";
	}
	
}
