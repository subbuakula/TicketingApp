package com.application.TicketingApp.model;

import java.util.ArrayList;

import jakarta.xml.bind.annotation.XmlRootElement;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@AllArgsConstructor
@NoArgsConstructor
@XmlRootElement(name = "tourists")
public class TouristBeanList
{
//	 @XmlElementWrapper(name = "tourists") // Wrapper element
//	 @XmlElement(name = "tourist") // Individual elements
	private ArrayList<TouristBean> beanList;	
}
