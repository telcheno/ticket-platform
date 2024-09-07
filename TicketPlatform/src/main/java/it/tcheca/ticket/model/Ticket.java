package it.tcheca.ticket.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

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
	@Column(name = "id_operatore", nullable = false) 
	private Integer operatore;
			
	@NotBlank(message = "Il categoria non puo esere null")
	@Column(name = "id_categoria", nullable = false)
	private String categoria;
	
	@Column(name = "id_nota", nullable = false)
	private Integer nota;

	
	
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

	public Integer getOperatore() {
		return operatore;
	}

	public void setOperatore(Integer operatore) {
		this.operatore = operatore;
	}

	public String getCategoria() {
		return categoria;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}

	public Integer getNota() {
		return nota;
	}

	public void setNota(Integer nota) {
		this.nota = nota;
	}
	
	
}
