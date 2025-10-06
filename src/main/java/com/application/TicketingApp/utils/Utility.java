package com.application.TicketingApp.utils;

import java.util.HashSet;
import java.util.Set;

import com.application.TicketingApp.entity.CourseEntity;
import com.application.TicketingApp.entity.PersonEntity;
import com.application.TicketingApp.entity.PhoneNumber;
import com.application.TicketingApp.entity.Tourist;
import com.application.TicketingApp.model.Course;
import com.application.TicketingApp.model.PersonModel;
import com.application.TicketingApp.model.TouristBean;

public class Utility 
{
	public static TouristBean entityToBean(Tourist e)
	{
		TouristBean bean = new TouristBean();
		bean.setTid(e.getTid());
		bean.setName(e.getName());
		bean.setCity(e.getCity());
		bean.setPackageType(e.getPackageType());
		bean.setBudget(e.getBudget());
		return bean;
	}
	
	public static Course entityToBean(CourseEntity e)
	{
		Course course = new Course();
		course.setCid(e.getCid());
		course.setCname(e.getCname());
		course.setCprice(e.getCprice());
		course.setCproctor(e.getCproctor());
		return course;
	}

	public static PersonModel personEntityToModel(PersonEntity pe)
	{
		PersonModel pm = new PersonModel();
		pm.setId(pe.getId());
		pm.setName(pe.getName());
		pm.setLocality(pe.getLocality());
		Set<PhoneNumber> pns = new HashSet<>();
		pe.getContact().stream().map(n -> pns.add(n));
//		for(PhoneNumber pn : pe.getContact())
//		{
//			pns.add(pn);
//		}
		//pm.setContact(pns);
		return pm;
	}
	
	
}
