package com.stage.libri.controller;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.stage.libri.dto.LibroDto;
import com.stage.libri.exceptions.LibroNotFoundException;
import com.stage.libri.model.Libro;
import com.stage.libri.service.LibriService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/libri")
public class LibriController {

	private static Logger logger = LogManager.getLogger(LibriController.class);

	private final LibriService libriService;

	public LibriController(LibriService libriService) {
		this.libriService = libriService;
	}

	@GetMapping
	public List<LibroDto> getLibri() {
		logger.info("Lista libri visualizzata correttamente");
		return libriService.getLibri();

	}

	@GetMapping("/{id}")
	public LibroDto getLibroById(@PathVariable Long id) throws LibroNotFoundException {
		return libriService.getLibroById(id);
	}

	@PostMapping
	public LibroDto insert(@Valid @RequestBody Libro l) {
		return libriService.insert(l);
	}

	@PutMapping("/{id}")
	public LibroDto update(@Valid @PathVariable Long id, @RequestBody Libro l) {
		return libriService.update(l, id);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<String> delete(@PathVariable Long id) {
		return libriService.delete(id);

	}

}
