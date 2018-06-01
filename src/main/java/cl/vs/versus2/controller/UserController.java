package cl.vs.versus2.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import cl.vs.versus2.repository.UserRepository;

@Controller
public class UserController {

	@Autowired
	UserRepository userRepository;

	@GetMapping("admin/profile/{id}")
	public String findUserProfile(@PathVariable int id, Model model) {
		model.addAttribute("userData", userRepository.findById(id));
		return "admin/profile";
	}

	@GetMapping("/remove/{id}")
	public String removeUser(@PathVariable int id) {
		userRepository.deleteById(id);
		return "redirect:/user/all";
	}

}
