package com.application.TicketingApp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.application.TicketingApp.entity.Tourist;
import com.application.TicketingApp.exception.TouristNotfoundException;
import com.application.TicketingApp.model.TouristBean;
import com.application.TicketingApp.model.TouristBeanList;
import com.application.TicketingApp.service.TouristService;

@RestController
@RequestMapping(value = "/api",produces = MediaType.APPLICATION_JSON_VALUE)
public class TouristController 
{
	@Autowired
	private TouristService service;
	
	@PostMapping("/register")
	public ResponseEntity<String> registerTourist(@RequestBody Tourist tourist)
	{
		try
		{
			int id = service.registerTourist(tourist);
			String msg = "Tourist registered successfully with id "+id;
			return new ResponseEntity<String>(msg,HttpStatus.OK);
		}catch(Exception e)
		{
			return new ResponseEntity<String>("Error happened while registering tourist",HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping(value="/gettourist/{id}", produces = {"application/xml","application/json"})
	public ResponseEntity<?> getTourist(@PathVariable("id") Integer id)
	{
		try
		{
			return new ResponseEntity<TouristBean>(service.findById(id),HttpStatus.OK);
		}catch(TouristNotfoundException e)
		{
			return new ResponseEntity<String>(e.getMessage(),HttpStatus.BAD_REQUEST);
		}
	}

	@GetMapping(value="alltourists", produces = {"application/xml","application/json"})
	public ResponseEntity<TouristBeanList> getAllTrourists()
	{
		return new ResponseEntity<TouristBeanList>(service.findAll(),HttpStatus.OK);
	}
	@GetMapping(value="/getTouristsbypackage/{packageType}", produces = {"application/xml","application/json"})
	public ResponseEntity<?> getTouristbyPackageType(@PathVariable("packageType") String packageType)
	{
		try
		{
			return new ResponseEntity<TouristBeanList>(service.findByPackageType(packageType),HttpStatus.OK);
		}catch(TouristNotfoundException e) 
		{
			return new ResponseEntity<String>(e.getMessage(),HttpStatus.BAD_REQUEST);
		}
	}

	@GetMapping(value = "/getTouristsBetweenBudget/{budget1}/{budget2}", produces = {"application/xml","application/json"})
	public ResponseEntity<?> getTouristsBetweenBudget(@PathVariable("budget1") Double budget1,@PathVariable("budget2") Double budget2)
	{
		try
		{
			return new ResponseEntity<TouristBeanList>(service.findByBudgetBetween(budget1,budget2),HttpStatus.OK);
		}catch(TouristNotfoundException e)
		{
			return new ResponseEntity<String>(e.getMessage(),HttpStatus.BAD_REQUEST);
		}
	}
	
	@GetMapping("/getTouristsWithPackages/{pack1}/{pack2}")
	public ResponseEntity<?> getTouristsBetweenBudget(@PathVariable("pack1") String pack1,@PathVariable("pack2") String pack2)
	{
		try
		{
			return new ResponseEntity<List<String>>(service.findTouristswithPackage(pack1,pack2),HttpStatus.OK);
		}catch(TouristNotfoundException e)
		{
			return new ResponseEntity<String>(e.getMessage(),HttpStatus.BAD_REQUEST);
		}
	}
	
	@GetMapping("/getTouristswithNamePattern/{pattern}")
	public ResponseEntity<?> getTouristswithNamePattern(@PathVariable("pattern") String pattern)
	{
		try
		{
			return new ResponseEntity<List<Tourist>>(service.findTouristswithNamePattern(pattern),HttpStatus.OK);
		}catch(TouristNotfoundException e)
		{
			return new ResponseEntity<String>(e.getMessage(),HttpStatus.BAD_REQUEST);
		} 
	}
	
	@PutMapping("/update")
	public ResponseEntity<String> updateTouristInfo(@RequestBody Tourist tourist)
	{
		return new ResponseEntity<String>(service.updateTouristInfo(tourist),HttpStatus.OK);
	}
	
	@PatchMapping("/updateBudgetByID/{id}/{budget}")
	public ResponseEntity<String> updateTouristBudgetById(@PathVariable("id") Integer id, @PathVariable("budget") Double budget)
	{
		try
		{
			return new ResponseEntity<String>(service.updateTouristBudgetById(id,budget),HttpStatus.OK);
		}catch(TouristNotfoundException e)
		{
			return new ResponseEntity<String>(e.getMessage(),HttpStatus.BAD_REQUEST);
		}
	}
	@DeleteMapping("/deleteTourist/{id}")
	public ResponseEntity<String> deleteTourist(@PathVariable("id") Integer id)
	{
		return new ResponseEntity<String>(service.deleteById(id),HttpStatus.OK);
	}
	
	@GetMapping(value = "/getException", produces={"application/xml","application/json"})
	public ResponseEntity<?> getException() throws Exception
	{
		throw new TouristNotfoundException("Custom exception");
	}
}
