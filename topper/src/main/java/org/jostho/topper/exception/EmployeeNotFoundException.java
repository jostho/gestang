package org.jostho.topper.exception;

public class EmployeeNotFoundException extends RuntimeException {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 5308545703449373166L;

	public EmployeeNotFoundException() {
		super() ;
	}
	
	public EmployeeNotFoundException(String message) {
		super(message) ;
	}

	public EmployeeNotFoundException(String message, Throwable cause) {
		super(message, cause) ;
	}
	
}
