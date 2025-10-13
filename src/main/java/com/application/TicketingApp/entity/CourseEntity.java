package com.application.TicketingApp.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity(name="course")
@Table(name="course")
public class CourseEntity 
{
	@Id()
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int cid;
	private String cname;
	private int cprice;
	private String cproctor;
}
