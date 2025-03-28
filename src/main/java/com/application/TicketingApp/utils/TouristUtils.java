package com.application.TicketingApp.utils;

import com.application.TicketingApp.entity.Tourist;
import com.application.TicketingApp.model.TouristBean;

public class TouristUtils 
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

}
