package com.stage.libri.service;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Service;

import com.stage.libri.exceptions.LibroNotFoundException;
import com.stage.libri.model.Libro;
import com.stage.libri.repository.LibriRepository;

@Service
public class LibriService {

	private final LibriRepository libroR;
	private static final Logger logger = LogManager.getLogger(LibriService.class);

	public LibriService(LibriRepository libroR) {
		this.libroR = libroR;
	}

	public List<Libro> getLibri() {
		return libroR.findAll();
	}

	public Libro getLibroById(Long id) {
		return libroR.findById(id).orElseThrow(() -> {
			logger.error("Libro con ID {} non trovato", id);
			return new LibroNotFoundException("Libro con ID " + id + " non trovato");
		});
	}

	public Libro insert(Libro libro) {
		
		libroR.save(libro);
		logger.info("Libro con ID {} inserito correttamente", libro.getid());
		return libro;
	}

	public Libro update(Libro libro, Long id) {
		if (libro == null) {
			logger.error("Tentativo di aggiornare un libro null");
			throw new IllegalArgumentException("Il libro non può essere null");
		}

		if (!libroR.existsById(id)) {
			logger.error("Libro con ID {} non trovato per l'aggiornamento", libro.getid());
			throw new LibroNotFoundException("Libro con ID " + id + " non trovato");
		}

		Libro updatedLibro = libroR.save(libro);
		logger.info("Libro con ID {} aggiornato correttamente", libro.getid());
		return updatedLibro;
	}

	public void delete(Long id) {
		if (!libroR.existsById(id)) {
			logger.error("Libro con ID {} non trovato per la cancellazione", id);
			throw new LibroNotFoundException("Libro con ID " + id + " non trovato");
		}
		libroR.deleteById(id);
		logger.info("Libro con ID {} cancellato correttamente", id);
	}
}
