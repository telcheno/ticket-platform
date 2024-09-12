package it.tcheca.ticket.model;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name = "operatore")
public class Operatore {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@NotBlank(message = "Dato obbligatorio")
	@Column(name = "nome", nullable = false)
	private String nome;

	@NotBlank(message = "Dato obbligatorio")
	@Column(name = "cognome", nullable = false)
	private String cognome;
	
	@NotBlank(message = "Dato obbligatorio")
	@Column(name = "password", nullable = false, unique = true)
	private String password;
	
	@NotBlank(message = "Dato obbligatorio")
	@Column(name = "stato", nullable = false)
	private String stato;

	@NotBlank(message = "Dato obbligatorio")
	@Column(name = "email", nullable = false, unique = true)
	private String email;
	
	@NotNull(message = "La data di inizio obbligatoria")
	@Column(name = "inizio_gestione", nullable = false)
	private LocalDate dataInizioGestione;
	
	@Column(name = "fine_gestione")
	private LocalDate dataFineGestione;
	
	@Column(name = "note")
	private String note;

	@Column(name = "ruolo", nullable = false)
	private String ruolo;
	
	@ManyToOne
	@JoinColumn(name = "id_ticket", nullable = false)
	private Ticket ticket;

	//getter e setter
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Ticket getTicket() {
		return ticket;
	}

	public void setTicket(Ticket ticket) {
		this.ticket = ticket;
	}


	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCognome() {
		return cognome;
	}

	public void setCognome(String cognome) {
		this.cognome = cognome;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getStato() {
		return stato;
	}

	public void setStato(String stato) {
		this.stato = stato;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public LocalDate getDataInizioGestione() {
		return dataInizioGestione;
	}

	public void setDataInizioGestione(LocalDate dataInizioGestione) {
		this.dataInizioGestione = dataInizioGestione;
	}

	public LocalDate getDataFineGestione() {
		return dataFineGestione;
	}

	public void setDataFineGestione(LocalDate dataFineGestione) {
		this.dataFineGestione = dataFineGestione;
	}

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}

	public String getRuolo() {
		return ruolo;
	}

	public void setRuolo(String ruolo) {
		this.ruolo = ruolo;
	}
		
}
