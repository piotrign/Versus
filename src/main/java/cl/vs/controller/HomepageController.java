package cl.vs.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomepageController {

	@GetMapping("/home")
	public String homePage() {
		System.out.println("strona online");
		return "forms/home";
	}
	
}
