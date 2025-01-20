package com.stage.libri.model;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "libro")

public class Libro implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "titolo", nullable = false)
	@Size(min = 1, max = 100, message = "Il titolo deve avere un minimo e massimo numero di caratteri")
	private String titolo;

	@Column(name = "autore", nullable = false)
	@Size(min = 1, max = 50, message = "L'autore deve avere un minimo e massimo numero di caratteri")
	private String autore;

	@Column(name = "anno_pubblicazione", nullable = false)
	@Min(value = 0, message = "L'anno di pubblicazione deve essere maggiore o uguale a 0")
	private int anno_pubblicazione;

	@Column(name = "categoria", nullable = false)
	@Size(min = 1, max = 50, message = "La categoria deve avere un minimo e massimo numero di caratteri")
	private String categoria;

	@Column(name = "prezzo", nullable = false)
	@Min(value = (long) 0.5, message = "Il prezzo deve essere almeno di 50 centesimi")
	private double prezzo;

	public Libro() {

	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
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
