package com.application.TicketingApp.utils;

import com.application.TicketingApp.entity.CourseEntity;
import com.application.TicketingApp.entity.Tourist;
import com.application.TicketingApp.model.Course;
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

}
