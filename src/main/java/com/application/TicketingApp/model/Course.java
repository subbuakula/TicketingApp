package com.application.TicketingApp.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Course 
{
	private int cid;
	private String cname;
	private int cprice;
	private String cproctor;
}
