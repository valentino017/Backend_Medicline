package com.medicline.spring.models.exceptions;

import java.util.Date;

import org.springframework.boot.context.config.ConfigDataResourceNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;


@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {
    @ExceptionHandler(ResorceNotFoundException.class)
    
    public ResponseEntity<?> resourceNotFoundException(ResorceNotFoundException ex, WebRequest request){
    
    ErrorDetails errorDetails = new ErrorDetails(new Date(), ex.getMessage(), request.getDescription(false));
    
    System.err.println(errorDetails + "ERROR");
	
	return new  ResponseEntity<>(errorDetails, HttpStatus.NOT_FOUND);
	
	
}

}