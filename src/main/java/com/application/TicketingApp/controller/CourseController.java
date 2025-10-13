package com.application.TicketingApp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.application.TicketingApp.entity.CourseEntity;
import com.application.TicketingApp.model.Course;
import com.application.TicketingApp.service.CourseService;
import com.application.TicketingApp.utils.Utility;

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
	
	@PostMapping("/addCourse")
	public ResponseEntity<Integer> addCourse(@RequestBody Course course)
	{
		Integer courseId = service.addCourse(course);
		return new ResponseEntity<Integer>(courseId, HttpStatus.OK);
	}
	
	@PutMapping("/updateCourse")
	public ResponseEntity<Course> updateCourse(@RequestBody Course course)
	{
		Course updatedCourse = service.updateCourse(course);
		return new ResponseEntity<Course>(updatedCourse, HttpStatus.OK);				
	}

}
