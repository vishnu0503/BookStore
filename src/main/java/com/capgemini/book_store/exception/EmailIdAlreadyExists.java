package com.capgemini.book_store.exception;

public class EmailIdAlreadyExists extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public EmailIdAlreadyExists(String message) {
		
		super(message);		
	
	}

}
