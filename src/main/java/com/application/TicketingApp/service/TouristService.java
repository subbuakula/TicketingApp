package com.application.TicketingApp.service;

import java.util.List;

import org.springframework.data.repository.query.Param;

import com.application.TicketingApp.model.Tourist;

public interface TouristService 
{
	Integer registerTourist(Tourist tourist);
	List<Tourist> findAll();
	Tourist findById(int id);
	List<Tourist> findByPackageType(String packageType);
	List<Tourist> findByBudgetBetween(Double budget1,Double budget2);
	List<String> findTouristswithPackage(String package1, String package2);
	List<Tourist> findTouristswithNamePattern(@Param("pattern")String pattern);
	//Update Methods
	String updateTouristInfo(Tourist tourist);
	String updateTouristBudgetById(Integer id, Double budget);
	//Delete methods
	String deleteById(int id);
}
