package cl.vs.versus2.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import cl.vs.versus2.repository.UserRepository;
import cl.vs.versus2.service.UserService;

public class RankingController {

	@Autowired
	UserRepository userRepository;

	@Autowired
	UserService userService;

	@GetMapping("/admin/ranking")
	public ModelAndView rankingPage() {
		ModelAndView modelAndView = new ModelAndView();
//		model.addAttribute("allUsersRating", userRepository.findAllOrderByEloRating());
		modelAndView.addObject("allUsersRating", userRepository.findAllOrderByEloRating());
		return modelAndView;
	}

}
