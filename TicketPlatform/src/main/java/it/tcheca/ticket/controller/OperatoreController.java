package it.tcheca.ticket.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;

import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import it.tcheca.ticket.model.Operatore;
import it.tcheca.ticket.repository.RepoOperatore;
import jakarta.validation.Valid;

@Controller
@RequestMapping("/operatori")
public class OperatoreController {
	
	@Autowired
	private RepoOperatore repoOperatore;
	
	@PostMapping("/create")
	public String store(
		@Valid
		@ModelAttribute("operatore") Operatore operatore, Model model,
			
		BindingResult bindingResult) {
		if(bindingResult.hasErrors()) {
				
		return "/gestori/operatore";
	}
		
		repoOperatore.save(operatore);
		
		return "/ticket/show/" + operatore.getTicket().getId();
	}
	
	
}
