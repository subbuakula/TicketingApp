package com.application.TicketingApp.service;

import java.util.List;

import com.application.TicketingApp.model.Course;

public interface CourseService 
{
	Course findById(int id);
	List<Course> findAll();
	List<Course> findByProctor(String name);
	List<Course> CourseByPrice(int price);
	
	Integer addCourse(Course course);
	Course updateCourse(Course course);
}
