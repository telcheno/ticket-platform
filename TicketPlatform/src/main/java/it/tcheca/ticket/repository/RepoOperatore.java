package it.tcheca.ticket.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import it.tcheca.ticket.model.Operatore;

public interface RepoOperatore extends JpaRepository<Operatore, Integer>{

}
