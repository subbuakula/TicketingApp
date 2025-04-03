package com.application.TicketingApp.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.application.TicketingApp.entity.Tourist;
@Repository
public interface TouristDao extends JpaRepository<Tourist, Integer> 
{
	// Custom Finder Methods using Keywords to retrieve data 
	Optional<List<Tourist>> findByPackageType(String packageType);
	Optional<List<Tourist>> findByBudgetBetween(Double budget1,Double budget2);
	
	@Query("FROM Tourist WHERE name LIKE  %:pattern%")
	Optional<List<Tourist>> findTouristswithNamePattern(@Param("pattern")String pattern);
	
	@Query("SELECT name FROM Tourist WHERE packageType=:pack1 OR packageType=:pack2")
	Optional<List<String>> findTouristswithPackage(@Param("pack1")String package1, @Param("pack2")String package2);
	
	@Query("SELECT DISTINCT(packageType) from Tourist")
	Optional<List<String>> findAvailablePackages();
}
