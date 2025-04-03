package com.application.TicketingApp.service;

import java.util.List;

import org.springframework.data.repository.query.Param;

import com.application.TicketingApp.entity.Tourist;
import com.application.TicketingApp.model.TouristBean;
import com.application.TicketingApp.model.TouristBeanList;

public interface TouristService 
{
	Integer registerTourist(Tourist tourist);
	TouristBeanList findAll();
	TouristBean findById(int id);
	TouristBeanList findByPackageType(String packageType);
	TouristBeanList findByBudgetBetween(Double budget1,Double budget2);
	List<String> findTouristswithPackage(String package1, String package2);
	List<Tourist> findTouristswithNamePattern(@Param("pattern")String pattern);
	//Update Methods
	String updateTouristInfo(Tourist tourist);
	String updateTouristBudgetById(Integer id, Double budget);
	//Delete methods
	String deleteById(int id);
	List<String> findAvaialablePacakges();
	
}
