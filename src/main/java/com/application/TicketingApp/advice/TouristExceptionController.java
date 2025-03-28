package com.application.TicketingApp.advice;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.application.TicketingApp.exception.TouristNotfoundException;

@RestControllerAdvice
public class TouristExceptionController 
{
	@ExceptionHandler(value = TouristNotfoundException.class,produces = {"application/xml","application/json"})
	public ResponseEntity<ErrorDetails> touristExceptionHandler(TouristNotfoundException e)
	{
		ErrorDetails details = new ErrorDetails("404 not found",e.getMessage(),LocalDateTime.now());
		 return ResponseEntity.status(HttpStatus.BAD_REQUEST)
//	                .contentType(MediaType.APPLICATION_JSON)
	                .body(details);			
	}
	@ExceptionHandler(value = Exception.class,produces = {"application/xml","application/json"})
	public ResponseEntity<ErrorDetails> touristGenericExceptionHandler(Exception e)
	{
		e.printStackTrace();
		ErrorDetails details = new ErrorDetails("404 not found",e.getMessage(),LocalDateTime.now());
		   return ResponseEntity.status(HttpStatus.BAD_REQUEST)
//	                .contentType(MediaType.APPLICATION_JSON)
	                .body(details);	
	}
}
