package it.tcheca.ticket.controller;

import java.util.ArrayList;
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
import org.springframework.web.bind.annotation.RequestParam;

import it.tcheca.ticket.model.Ticket;
import it.tcheca.ticket.repository.RepoTickect;
import jakarta.validation.Valid;

@Controller
@RequestMapping("/tickets")
public class TicketController {

 	//define la implementazione dellla classe concreta della interfacia tramite IoC 
	//e la classe viene ignetata tramite Dependency Injection
	@Autowired
	private RepoTickect repoTicket;
	
	//metodo di acceso
	@GetMapping
	public String index(Model model) {
		
		List<Ticket> tickets = repoTicket.findAll();
		
		model.addAttribute("list", tickets);
		
		return "/homeTemplates/index";
	}
	
	@GetMapping("/show/{id}")
	public String show(@PathVariable("id") Integer id, Model model) {
	
		model.addAttribute("ticket", repoTicket.getReferenceById(id));
		
		return "/homeTemplates/ticket";
	}
	
	@GetMapping("/create")
	
	public String create(Model model) {
	
		model.addAttribute("ticket", new Ticket());
	
		return "/homeTemplates/create";
	}
	
	//metodo di acceso
	@PostMapping("/create")
	public String store(
		//recupero i dati del from valorizati e vailidati tramite le anotasion
		@Valid @ModelAttribute("ticket") Ticket formTicket,
		
		//ascolta e intercetta il sumit del form
		BindingResult bindingResult,
		Model model){
		
		//se intercetta errori resta nella pagina
		if(bindingResult.hasErrors()) {
		return "/homeTemplates/create";
		}
		
		//se non ci sono errori sala i dati e torna nel index
		repoTicket.save(formTicket);
		return "redirect:/tickets";
	}
}
