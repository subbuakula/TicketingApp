package com.application.TicketingApp.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.application.TicketingApp.dao.PersonRepository;
import com.application.TicketingApp.entity.PersonEntity;
import com.application.TicketingApp.model.PersonModel;
import com.application.TicketingApp.service.PersonService;
import com.application.TicketingApp.utils.Utility;
@Service
public class PersonServiceImpl implements PersonService 
{
	@Autowired 
	private PersonRepository repo;

	@Override
	public List<PersonModel> getAllPersons() 
	{
		List<PersonEntity> persons = repo.findAll();
		List<PersonModel> personModels = persons.stream().map(Utility::personEntityToModel).toList();
		return personModels;
	}

}
