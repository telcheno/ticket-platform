 package it.tcheca.ticket.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import it.tcheca.ticket.model.Operatore;
import it.tcheca.ticket.repository.RepoOperatore;
import jakarta.validation.Valid;


@Controller
@RequestMapping("/home")
public class HomeController {
	
	@Autowired
	private RepoOperatore repository;
	
	
	@GetMapping
	public String index(Model model) {
		
		List<Operatore> operatori = repository.findAll();  
		
		model.addAttribute("list", operatori);
		
		return "/homeTemplates/index";
	}
	
	@GetMapping("/show/{id}")
	public String show(@PathVariable("id") Integer idOperatore, Model model) {
	
		model.addAttribute("operatore", repository.getReferenceById(idOperatore));
		
		return "/homeTemplates/operatore";
	}
	
	@GetMapping("/create")
	public String create(Model model) {
		
		model.addAttribute("operatore", new Operatore());
		
		return "/home/Templates/createOperatore";
	}
	
	@PostMapping("/create")
	public String store(
		
		@Valid
		@ModelAttribute("operatore") Operatore formBook, 
		BindingResult bindingResult, Model model){
	
		if(bindingResult.hasErrors()) {
	
		return "/home/create";
	}
		repository.save(formBook);
		
		return "redirect:/home";
	}
}
