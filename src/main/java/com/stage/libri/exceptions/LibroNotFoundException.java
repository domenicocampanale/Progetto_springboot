package com.stage.libri.exceptions;

public class LibroNotFoundException extends RuntimeException {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1458488340100671889L;

	public LibroNotFoundException(String message) {
        super(message);
    }
}
