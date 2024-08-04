 package it.tcheca.ticket.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import it.tcheca.ticket.model.Operatore;
import it.tcheca.ticket.repository.RepoOperatore;



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
}
