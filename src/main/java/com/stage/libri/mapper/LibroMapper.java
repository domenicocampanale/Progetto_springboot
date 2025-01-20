package com.stage.libri.mapper;

import org.mapstruct.Mapper;

import com.stage.libri.dto.LibroDto;
import com.stage.libri.model.Libro;

@Mapper(componentModel = "spring")
public interface LibroMapper {

	LibroDto toLibroDto(Libro libro);

	Libro toLibro(LibroDto libroDto);
}
