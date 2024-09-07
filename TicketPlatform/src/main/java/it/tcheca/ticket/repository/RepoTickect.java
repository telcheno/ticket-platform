package it.tcheca.ticket.repository;



import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import it.tcheca.ticket.model.Ticket;



//si define l'interfaccia con oggetto del model e il suo tipo
public interface RepoTickect extends JpaRepository<Ticket, Integer>{

	//le query basiche le fa in automatiche
	//per fare le query personalizate si fa con i metodi
		
	public List<Ticket> findByStato(String stato);
	
	
	public List<Ticket> findByStatoOrderByIdDesc(String stato);
}
