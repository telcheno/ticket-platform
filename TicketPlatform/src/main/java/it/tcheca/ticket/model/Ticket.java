package it.tcheca.ticket.model;


import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;


@Entity //define l'enetita della tabella
@Table(name = "ticket") //define ilnome della tabella
public class Ticket{
	
	@Id //define colllona della tabella come ID
	@GeneratedValue(strategy = GenerationType.IDENTITY) //define il valre autoincrement
	private Integer id; //la collona prende il nome del atributo

	//per definire gli atrubuti nelle collone uso @Column e @NotNull o @NotBlank per la validazione
	@NotBlank(message = "Il titolo non puo esere null")
	@Column(name = "titolo", nullable = false)
	private String titolo;

	@NotBlank(message = "Il stato non puo esere null")
	@Column(name = "stato", nullable = false) // nullable define il vallore not null 
	private String stato;
			
	//si puo personalizare il nome della collona del DB
	@Column(name = "operatore", nullable = false) 
	private String operatore;
			
	@NotBlank(message = "Il categoria non puo esere null")
	@Column(name = "categoria", nullable = false)
	private String categoria;
	
	@Column(name = "nota")
	private String nota;
	
	@OneToMany(mappedBy = "ticket")
	private List<Operatore> operatores; 
	
	//getter e setter
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTitolo() {
		return titolo;
	}

	public void setTitolo(String titolo) {
		this.titolo = titolo;
	}

	public String getStato() {
		return stato;
	}

	public void setStato(String stato) {
		this.stato = stato;
	}

	public String getOperatore() {
		return operatore;
	}

	public void setOperatore(String operatore) {
		this.operatore = operatore;
	}

	public String getCategoria() {
		return categoria;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}

	public String getNota() {
		return nota;
	}

	public void setNota(String nota) {
		this.nota = nota;
	}

	public List<Operatore> getOperatores() {
		return operatores;
	}

	public void setOperatores(List<Operatore> operatores) {
		this.operatores = operatores;
	}
	
	
	
	
}
