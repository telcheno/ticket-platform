package it.tcheca.ticket.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import it.tcheca.ticket.model.Nota;

public interface RepoNota extends JpaRepository<Nota, Integer>{

}
