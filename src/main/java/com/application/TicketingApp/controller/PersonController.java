package com.application.TicketingApp.controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.web.csrf.CsrfToken;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.application.TicketingApp.model.PersonModel;
import com.application.TicketingApp.serviceimpl.PersonServiceImpl;

import jakarta.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/person-api")
public class PersonController 
{
	@Autowired
	private PersonServiceImpl service;
	
	@GetMapping("/getAllPersons")
	public ResponseEntity<List<PersonModel>> getPersons()
	{
		return new ResponseEntity<List<PersonModel>>(service.getAllPersons(),HttpStatus.OK);
	}

	@GetMapping("getSessionId")
	public ResponseEntity<String> getSessionId(HttpServletRequest request)
	{
		return new ResponseEntity<String>("The session ID for the current session is "+request.getSession().getId(),HttpStatus.OK);
	}
	
	@GetMapping("csrf_token")
	public ResponseEntity<CsrfToken> getCsrfToken(HttpServletRequest request)
	{
		CsrfToken token = (CsrfToken) request.getAttribute("_csrf");
		return new ResponseEntity<CsrfToken>(token, HttpStatus.OK);		
	}
}
