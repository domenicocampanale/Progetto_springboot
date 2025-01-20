package com.stage.libri.service;

import java.util.List;
import java.util.stream.Collectors;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.stage.libri.dto.LibroDto;
import com.stage.libri.exceptions.LibroNotFoundException;
import com.stage.libri.mapper.LibroMapper;
import com.stage.libri.model.Libro;
import com.stage.libri.repository.LibriRepository;

@Service
public class LibriService {

	private final LibriRepository libroRepository;
	private final LibroMapper libroMapper;
	private static final Logger logger = LogManager.getLogger(LibriService.class);

	public LibriService(LibriRepository libroRepository, LibroMapper libroMapper) {
		this.libroRepository = libroRepository;
		this.libroMapper = libroMapper;
	}

	public List<LibroDto> getLibri() {
		List<Libro> libri = libroRepository.findAll();
		return libri.stream().map(libroMapper::toLibroDto).collect(Collectors.toList());
	}

	public LibroDto getLibroById(Long id) {
		Libro libro = libroRepository.findById(id).orElseThrow(() -> {
			logger.error("Libro con ID {} non trovato", id);
			return new LibroNotFoundException("Libro con ID " + id + " non trovato");
		});
		return libroMapper.toLibroDto(libro);
	}

	public LibroDto insert(Libro libro) {
		libroRepository.save(libro);
		logger.info("Libro con ID {} inserito correttamente", libro.getId());
		return libroMapper.toLibroDto(libro);
	}

	public LibroDto update(Libro libro, Long id) {

		if (!libroRepository.existsById(id)) {
			logger.error("Libro con ID {} non trovato per l'aggiornamento", id);
			throw new LibroNotFoundException("Libro con ID " + id + " non trovato");
		}

		libroRepository.save(libro);
		logger.info("Libro con ID {} aggiornato correttamente", libro.getId());
		return libroMapper.toLibroDto(libro);
	}

	public ResponseEntity<String> delete(Long id) {
		if (!libroRepository.existsById(id)) {
			logger.error("Libro con ID {} non trovato per la cancellazione", id);
			throw new LibroNotFoundException("Libro con ID " + id + " non trovato");
		}
		libroRepository.deleteById(id);
		logger.info("Libro con ID {} cancellato correttamente", id);
		return new ResponseEntity<String>("Cancellazione effettuata con successo del libro con id " + id, HttpStatus.OK);
	}

}
