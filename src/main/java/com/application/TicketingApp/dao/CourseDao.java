package com.application.TicketingApp.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.application.TicketingApp.entity.CourseEntity;

public interface CourseDao extends JpaRepository<CourseEntity, Integer> 
{
	

}
