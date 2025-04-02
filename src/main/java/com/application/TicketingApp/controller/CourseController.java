package com.application.TicketingApp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.application.TicketingApp.model.Course;
import com.application.TicketingApp.service.CourseService;

@RestController
@RequestMapping("/course-api")
public class CourseController 
{
	@Autowired
	private CourseService service;
	@GetMapping("/getAllCourses")
	public ResponseEntity<List<Course>> getAllCourses()
	{
		return new ResponseEntity<List<Course>>(service.findAll(), HttpStatus.OK);
	}

}
