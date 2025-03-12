package com.application.TicketingApp.advice;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.application.TicketingApp.exception.TouristNotfoundException;

@RestControllerAdvice
public class TouristExceptionController 
{
	@ExceptionHandler(TouristNotfoundException.class)
//	@ResponseStatus(HttpStatus.BAD_REQUEST)
//	@ResponseBody
	public ResponseEntity<ErrorDetails> touristExceptionHandler(TouristNotfoundException e)
	{
		ErrorDetails details = new ErrorDetails("404 not found",e.getMessage(),LocalDateTime.now());
		 return ResponseEntity.status(HttpStatus.BAD_REQUEST)
	                .contentType(MediaType.APPLICATION_JSON)
	                .body(details);			
	}
	@ExceptionHandler(Exception.class)
	public ResponseEntity<ErrorDetails> touristGenericExceptionHandler(Exception e)
	{
		ErrorDetails details = new ErrorDetails("404 not found",e.getMessage(),LocalDateTime.now());
		   return ResponseEntity.status(HttpStatus.BAD_REQUEST)
	                .contentType(MediaType.APPLICATION_JSON)
	                .body(details);	
	}
}
