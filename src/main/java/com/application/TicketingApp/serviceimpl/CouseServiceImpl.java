package com.application.TicketingApp.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.application.TicketingApp.dao.CourseDao;
import com.application.TicketingApp.entity.CourseEntity;
import com.application.TicketingApp.model.Course;
import com.application.TicketingApp.service.CourseService;
import com.application.TicketingApp.utils.Utility;
@Service
public class CouseServiceImpl implements CourseService {

	@Autowired
	private CourseDao repo;
	@Override
	public Course findById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Course> findAll() {
		
		return repo.findAll().stream().map(Utility::entityToBean).toList();
	}

	@Override
	public List<Course> findByProctor(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Course> CourseByPrice(int price) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Integer addCourse(Course course) {
		 
		CourseEntity entity = Utility.beanToEntity(course);
		CourseEntity addedCourse = repo.save(entity);
		return addedCourse.getCid();
	}

	@Override
	public Course updateCourse(Course course) 
	{
		CourseEntity entity = Utility.beanToEntity(course);
		CourseEntity addedCourse = repo.save(entity);
		
		return Utility.entityToBean(addedCourse);
		
	}	
}
