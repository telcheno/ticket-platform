package it.tcheca.ticket.controller;

import java.time.LocalDate;
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

import it.tcheca.ticket.model.Operatore;
import it.tcheca.ticket.model.Ticket;
import it.tcheca.ticket.repository.RepoOperatore;
import it.tcheca.ticket.repository.RepoTickect;
import jakarta.validation.Valid;

@Controller
@RequestMapping("/tickets")
public class TicketController {

 	//define la implementazione dellla classe concreta della interfacia tramite IoC 
	//e la classe viene ignetata tramite Dependency Injection
	@Autowired
	private RepoTickect repoTicket;
	
	@Autowired
	private RepoOperatore repoOperatore;
	
	//metodo di acceso
	@GetMapping
	public String index(Model model,
			@RequestParam(name = "titolo", required = false) String stato) {
		
		List<Ticket> tickets = new ArrayList<>();
		
		if(stato == null || stato.isBlank()) {
		
			tickets = repoTicket.findAll();
		
		} else {
		
			tickets = repoTicket.findByStatoOrderByIdDesc(stato);
		}
		
		model.addAttribute("list", tickets);
		
		return "/homeTemplates/index";
	}
	
	@GetMapping("/show/{id}")
	public String show(@PathVariable("id") Integer id, Model model) {
	
		model.addAttribute("ticket", repoTicket.getReferenceById(id));
		
		return "/homeTemplates/ticket";
	}
	
	//metodo di acceso per creare il ticket
	@GetMapping("/create")
	
	public String create(Model model) {
	
		model.addAttribute("ticket", new Ticket());
	
		return "/homeTemplates/create";
	}
	
	@PostMapping("/create")
	public String store(
		//recupero i dati del from valorizati e vailidati tramite le anotasion
		@Valid @ModelAttribute("ticket") Ticket formTicket,
		Model model,
		
		//ascolta e intercetta il sumit del form
		BindingResult bindingResult){
		
		//se intercetta errori resta nella pagina
		if(bindingResult.hasErrors()) {
		return "/homeTemplates/create";
		}
		
		//se non ci sono errori salva i dati e torna nel index
		repoTicket.save(formTicket);
		return "redirect:/tickets";
	}
	
	//metodo di acceso per aggiornare il ticket
	@GetMapping("/edit/{id}")
	public String edit(@PathVariable("id") Integer id, Model model) {
	
		model.addAttribute("ticket", repoTicket.getReferenceById(id));
		
		return " ";
	}
	
	@PostMapping("/edit/{id}")
	public String update(
		
		@Valid @ModelAttribute("ticket") Ticket ticket,
			
		BindingResult bindingResult,
		Model model){
			
		if(bindingResult.hasErrors()) {
		
		return "/homeTemplates/edit";
		}
			
		repoTicket.save(ticket);
			
		return "redirect:/tickets";
		
	}
	
	//metodo di acceso per cancellare il ticket
	@PostMapping("/delete/{id}")
	public String delete(@PathVariable("id") Integer id) {
		
		repoTicket.deleteById(id);
		
		return "redirect:/tickets";
	}
	
	
	//metodo di acceso alle relazioni
	@GetMapping("/{id}/operatore")
	public String operatore(@PathVariable("id") Integer id, Model model) {
		
		Operatore operatore =new Operatore();
		operatore.setDataInizioGestione(LocalDate.now());
		operatore.setTicket(repoTicket.getReferenceById(id));
		
		model.addAttribute("operatore", operatore);
		
		return "operatore/edit";
	}
		
	
	
	
}
