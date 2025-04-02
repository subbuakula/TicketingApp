package com.application.TicketingApp.model;

import org.springframework.hateoas.RepresentationModel;

import jakarta.xml.bind.annotation.XmlRootElement;
import lombok.Data;
import lombok.EqualsAndHashCode;

@SuppressWarnings("rawtypes")
@Data
@EqualsAndHashCode(callSuper=false)
@XmlRootElement(name = "tourist")
public class TouristBean extends RepresentationModel
{
	
	private Integer tid;
	
	private String name;
	private String city;
	private String packageType;
	private Double budget;
}
