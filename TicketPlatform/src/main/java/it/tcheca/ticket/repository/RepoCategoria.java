package it.tcheca.ticket.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import it.tcheca.ticket.model.Categoria;

public interface RepoCategoria extends JpaRepository<Categoria, Integer> {

}
