package com.medicline.spring.models.exceptions;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;


@ResponseStatus(value= HttpStatus.NOT_FOUND)
public class ResorceNotFoundException extends Exception {

	private static final long serialVersionUID = 1L;
	
	public ResorceNotFoundException(String message) {
		
		super(message);
	}
	
	
}
