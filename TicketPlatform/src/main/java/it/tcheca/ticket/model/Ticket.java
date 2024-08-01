package it.tcheca.ticket.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "ticket")
public class Ticket{

	//anotazione come id
	@Id
	//amotazione auto increment
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Column(name = "titolo", nullable = false)
	private Boolean titolo;
			
	@Column(name = "id_operatore", nullable = false)
	private Integer idOperatore;
			
	@Column(name = "id_categoria", nullable = false)
	private Integer idCategoria;
	
	@Column(name = "id_nota", nullable = false)
	private Integer idNota;

	
	
	//getter e setter
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Boolean getTitolo() {
		return titolo;
	}

	public void setTitolo(Boolean titolo) {
		this.titolo = titolo;
	}

	public Integer getIdOperatore() {
		return idOperatore;
	}

	public void setIdOperatore(Integer idOperatore) {
		this.idOperatore = idOperatore;
	}

	public Integer getIdCategoria() {
		return idCategoria;
	}

	public void setIdCategoria(Integer idCategoria) {
		this.idCategoria = idCategoria;
	}

	public Integer getIdNota() {
		return idNota;
	}

	public void setIdNota(Integer idNota) {
		this.idNota = idNota;
	}
	
	
}
