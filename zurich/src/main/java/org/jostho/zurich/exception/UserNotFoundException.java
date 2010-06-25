package org.jostho.zurich.exception;

public class UserNotFoundException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2694679164775610152L;

	public UserNotFoundException() {
		super() ;
	}
	
	public UserNotFoundException(String message) {
		super(message) ;
	}

}
