package com.application.TicketingApp.entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "PhoneNumber")
@Data
public class PhoneNumber 
{
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private String provider;
	private long contact;
	
	@ManyToOne(targetEntity = PersonEntity.class, cascade = CascadeType.ALL)
	@JoinColumn(name = "person_id", referencedColumnName = "id")
	private PersonEntity person;

}
