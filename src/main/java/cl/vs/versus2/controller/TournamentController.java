package cl.vs.versus2.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import cl.vs.versus2.entity.Tournament;
import cl.vs.versus2.repository.TournamentRepository;
import cl.vs.versus2.service.TournamentService;

@Controller
public class TournamentController {

	@Autowired
	TournamentRepository tournamentRepository;
	
	@Autowired
	TournamentService tournamentService;
	
	@GetMapping("/admin/addTournament")
	public String getTournamentForm(Model model) {
		model.addAttribute(new Tournament());
		return "admin/allTournament";
	}

	@PostMapping("/admin/addTournament")
	public String processTournamentForm(@Valid Tournament tournament, BindingResult result) {
		if (result.hasErrors()) {
			return "admin/addTournament";
		}
		tournamentRepository.save(tournament);
		System.out.println(tournament.getId() + " " + tournament.getName() + " " + tournament.getDescription());
		return "admin/allTournament";
	}
	
	@GetMapping("/admin/allTournament")
	public ModelAndView allTournamentPage() {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("allUsersRating", tournamentService.getAllTournament());
		return modelAndView;
	}
	
}
