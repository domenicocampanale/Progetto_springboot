package com.stage.libri.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.stage.libri.model.Libro;

public interface LibriRepository extends JpaRepository<Libro, Long> {

}
