package com.application.TicketingApp.serviceimpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.application.TicketingApp.dao.TouristDao;
import com.application.TicketingApp.entity.Tourist;
import com.application.TicketingApp.exception.TouristNotfoundException;
import com.application.TicketingApp.model.TouristBean;
import com.application.TicketingApp.model.TouristBeanList;
import com.application.TicketingApp.service.TouristService;
import com.application.TicketingApp.utils.Utility;

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
	public TouristBeanList findAll() {
		
		List<Tourist> touristList =  repo.findAll();		
		ArrayList<TouristBean> beanList = new ArrayList<>();
		for(Tourist tourist : touristList)
		{
			beanList.add(Utility.entityToBean(tourist));
		}
		
		return new TouristBeanList(beanList);
//		return  (ArrayList<TouristBean>) touristList.stream().map(TouristUtils::entityToBean).toList();
	}

	@Override
	public TouristBean findById(int id) {
		
		Tourist tourist = repo.findById(id)
				   .orElseThrow(() -> new TouristNotfoundException("Tourist with ID "+id+" not found."));
		return Utility.entityToBean(tourist);
	}

	public TouristBeanList findByPackageType(String packageType)
	{
		List<Tourist> touristList =  repo.findByPackageType(packageType)
				.orElseThrow(() -> new TouristNotfoundException("Tourists with package "+packageType+" are not found."));
		
		return  new TouristBeanList(new ArrayList<TouristBean>(touristList.stream().map(Utility::entityToBean).toList()));
	}

	@Override
	public TouristBeanList findByBudgetBetween(Double budget1, Double budget2) {
		// TODO Auto-generated method stub
		List<Tourist> touristList = repo.findByBudgetBetween(budget1, budget2)
				.orElseThrow(() -> new TouristNotfoundException("Tourists not found"));
		return new TouristBeanList(new ArrayList<TouristBean>(touristList.stream().map(Utility::entityToBean).toList()));
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
