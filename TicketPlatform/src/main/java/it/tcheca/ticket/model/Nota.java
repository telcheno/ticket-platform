package it.tcheca.ticket.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "nota")
public class Nota {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name = "titolo", nullable = false)
	private String titolo;
	
	@Column(name = "stato", nullable = false)
	private String stato;

	@Column(name = "testo", nullable = false)
	private String testo;
}
