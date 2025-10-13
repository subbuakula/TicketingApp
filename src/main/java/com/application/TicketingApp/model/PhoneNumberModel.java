package com.application.TicketingApp.model;

import lombok.Data;

@Data
public class PhoneNumberModel {
	private int id;
	private String provider;
	private long contact;
	
	private PersonModel person;
}

