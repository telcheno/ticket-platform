package it.tcheca.ticket.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import it.tcheca.ticket.model.Ticket;
import it.tcheca.ticket.repository.RepoTickect;

@Controller
@RequestMapping("/tickets")
public class TicketController {

	@Autowired
	private RepoTickect repoTicket;
	
	public String tickets(Model model) {
		
		List<Ticket> tickets = repoTicket.findAll();
		
		model.addAttribute("list", tickets);
		
		return "/homeTemplates/ticket";
	}
}
