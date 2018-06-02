package cl.vs.versus2.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import cl.vs.versus2.entity.Tournament;
import cl.vs.versus2.entity.User;
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
		return "admin/addTournament";
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
		modelAndView.addObject("allTournament", tournamentService.getAllTournament());
		return modelAndView;
	}

	@GetMapping("admin/tournamentDetail/{id}")
	public String findTournamentDetail(@PathVariable int id, Model model) {
		model.addAttribute("tournamentDetail", tournamentRepository.findById(id));
		return "admin/tournamentDetail";
	}

	@GetMapping("admin/tournamentDetail/edit/{id}")
	public String editTournament(@PathVariable int id, Model model) {
		model.addAttribute("tournament", tournamentRepository.findById(id));
		return "/admin/editTournament";
	}

	@PostMapping("admin/tournamentDetail/edit")
	public String saveEditedTournament(@Valid Tournament tournament, BindingResult result) {
		if (result.hasErrors()) {
			return "/admin/editTournament";
		}
		tournamentRepository.save(tournament);
		return "redirect:/admin/allTournament";
	}

	@GetMapping("admin/tournamentDetail/remove/{id}")
	public String removeUser(@PathVariable int id) {
		tournamentRepository.deleteById(id);
		return "redirect:/admin/allTournament";
	}

//	@GetMapping("admin/tournamentDetail/attend")
//	public String assignParticipant(User user, Tournament tournament, Model model) {
//		tournament.
//		
//		
//		return "redirect:/admin/allTournament";
//	}
	
}
