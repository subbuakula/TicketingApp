package com.application.TicketingApp.model;

import com.application.TicketingApp.model.TouristBean;

import jakarta.xml.bind.annotation.XmlRootElement;
import lombok.Data;

@Data
@XmlRootElement(name = "tourist")
public class TouristBean {
	
	private Integer tid;
	
	private String name;
	private String city;
	private String packageType;
	private Double budget;
}
