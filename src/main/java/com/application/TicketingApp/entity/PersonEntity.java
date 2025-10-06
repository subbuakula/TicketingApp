package com.application.TicketingApp.entity;

import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;
@Entity
@Table(name = "Person")
@Data
public class PersonEntity 
{
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	//@Column(name = "id")
	private int id;
	private String name;
	private String locality;
	
	@OneToMany(targetEntity = PhoneNumber.class, cascade = CascadeType.ALL)
	private Set<PhoneNumber> contact;
}
