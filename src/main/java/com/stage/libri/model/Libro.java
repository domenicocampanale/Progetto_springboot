package com.stage.libri.model;

import java.io.Serializable;

import org.apache.logging.log4j.core.config.plugins.validation.constraints.NotBlank;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Min;

@Entity
@Table(name = "libro")

public class Libro implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "titolo", nullable = false)
	@NotBlank(message = "Il titolo non può essere nullo o vuoto.")
	private String titolo;

	@Column(name = "autore", nullable = false)
	@NotBlank(message = "L'autore non può essere nullo o vuoto.")
	private String autore;

	@Column(name = "anno_pubblicazione", nullable = false)
	@Min(value = 0, message = "L'anno di pubblicazione deve essere maggiore o uguale a 0")
	private int anno_pubblicazione;

	@Column(name = "categoria", nullable = false)
	@NotBlank(message = "La categoria non può essere nulla o vuota.")
	private String categoria;

	@Column(name = "prezzo", nullable = false)
	@Min(value = (long) 0.5, message = "L'anno di pubblicazione deve essere maggiore o uguale a 50 centesimi")
	private double prezzo;

	public Libro() {

	}

	public Long getid() {
		return id;
	}

	public void setid(Long id) {
		this.id = id;
	}

	public String getTitolo() {
		return titolo;
	}

	public void setTitolo(String titolo) {
		this.titolo = titolo;
	}

	public String getAutore() {
		return autore;
	}

	public void setAutore(String autore) {
		this.autore = autore;
	}

	public int getAnno_pubblicazione() {
		return anno_pubblicazione;
	}

	public void setAnno_pubblicazione(int anno_pubblicazione) {
		this.anno_pubblicazione = anno_pubblicazione;
	}

	public String getCategoria() {
		return categoria;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}

	public double getPrezzo() {
		return prezzo;
	}

	public void setPrezzo(double prezzo) {
		this.prezzo = prezzo;
	}

}
