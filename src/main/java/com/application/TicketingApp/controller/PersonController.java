package com.application.TicketingApp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.application.TicketingApp.model.PersonModel;
import com.application.TicketingApp.serviceimpl.PersonServiceImpl;

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

}
