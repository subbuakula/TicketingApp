package com.application.TicketingApp.model;

import java.util.Set;

import lombok.Data;

@Data
public class PersonModel {
	private int id;
	private String name;
	private String locality;
	private Set<PhoneNumberModel> contact;
}

