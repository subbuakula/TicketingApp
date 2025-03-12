package com.application.TicketingApp.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.application.TicketingApp.dao.TouristDao;
import com.application.TicketingApp.exception.TouristNotfoundException;
import com.application.TicketingApp.model.Tourist;

@Service
public class TouristServiceImpl implements TouristService {

	@Autowired
	private TouristDao repo;
	
	@Override
	public Integer registerTourist(Tourist tourist) 
	{
		return repo.save(tourist).getTid();	 
	}

	@Override
	public List<Tourist> findAll() {
		
		return repo.findAll();		
	}

	@Override
	public Tourist findById(int id) {
		
		return repo.findById(id)
				   .orElseThrow(() -> new TouristNotfoundException("Tourist with ID "+id+" not found."));
	}

	public List<Tourist> findByPackageType(String packageType)
	{
		return repo.findByPackageType(packageType)
				.orElseThrow(() -> new TouristNotfoundException("Tourists with package "+packageType+" are not found."));
	}

	@Override
	public List<Tourist> findByBudgetBetween(Double budget1, Double budget2) {
		// TODO Auto-generated method stub
		return repo.findByBudgetBetween(budget1, budget2)
				.orElseThrow(() -> new TouristNotfoundException("Tourists not found"));
	}

	@Override
	public List<String> findTouristswithPackage(String package1, String package2) {
		return repo.findTouristswithPackage(package1, package2)
				.orElseThrow(() -> new TouristNotfoundException("No Tourist Available."));
	}

	@Override
	public List<Tourist> findTouristswithNamePattern(String pattern) {
		return repo.findTouristswithNamePattern(pattern)
				.orElseThrow(() -> new TouristNotfoundException("No Tourist Available."));
	}

	@Override
	public String updateTouristInfo(Tourist tourist) {
		if(repo.findById(tourist.getTid()).isPresent())
		{
			repo.save(tourist);
			return "Tourist with "+tourist.getTid()+" is Updated Successfully.";
		}
		else throw new TouristNotfoundException("Given Tourist is not Available."); 
		
	}

	@Override
	public String updateTouristBudgetById(Integer id, Double budget) {
		
		Optional<Tourist> obj = repo.findById(id);
		if(obj.isPresent())
		{
			Tourist tourist = obj.get();
			tourist.setBudget(budget);
			repo.save(tourist);
			return "Tourist with "+id+" is Updated Successfully.";
		}
		else throw new TouristNotfoundException("Given Tourist is not Available."); 
	}

	@Override
	public String deleteById(int id) {
		if(repo.findById(id).isPresent())
		{
			repo.deleteById(id);
			return "Tourist with "+id+" deleted Successfully.";
		}
		else throw new TouristNotfoundException("Given Tourist is not Available for Deletion."); 		
	}
}
