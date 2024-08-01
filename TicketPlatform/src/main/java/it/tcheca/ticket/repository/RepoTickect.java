package it.tcheca.ticket.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import it.tcheca.ticket.model.Ticket;

public interface RepoTickect extends JpaRepository<Ticket, Integer>{

}
