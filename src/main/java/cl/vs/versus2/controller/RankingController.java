package cl.vs.versus2.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.servlet.ModelAndView;

import cl.vs.versus2.pojo.MatchResult;
import cl.vs.versus2.service.RankingService;
import cl.vs.versus2.service.UserService;

@Controller
public class RankingController {

	@Autowired
	UserService userService;
	
	@Autowired
	RankingService rankingService;

	@GetMapping("/admin/ranking")
	public ModelAndView rankingPage() {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("allUsersRating", userService.getAllUsers());
		return modelAndView;
	}
	
	@GetMapping("/admin/matchResult")
	public String showResultForm() {
		return "/admin/matchResult";
	}
	
	@PostMapping("/admin/matchResult")
	public String saveEditedUserEloIncrease(@RequestBody MatchResult matchResult) {
		System.out.println(matchResult.getEmailDefeated());
		System.out.println(matchResult.getEmailWinner());
		rankingService.increaseElo(matchResult.getEmailWinner());
		
		rankingService.decreaseElo(matchResult.getEmailDefeated());
		
		return "redirect:/admin/ranking";
	}
	
}
