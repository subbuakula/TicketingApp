package com.application.TicketingApp.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.application.TicketingApp.model.Course;
import com.application.TicketingApp.service.CourseService;

@WebMvcTest(CourseController.class)
class CourseControllerTest {

	@MockitoBean
	private CourseService service;
	@Autowired
	private MockMvc mockMvc;
	@BeforeAll
	static void setUpBeforeClass() throws Exception {
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
	}

	@Test
	void getAllCoursesTest() 
	{
		try {
			Course c1 = new Course(101, "Java Programming", 5000, "John Doe");
			Course c2 = new Course(102, "Spring Boot", 6000, "Jane Smith");
			Course c3 = new Course(103, "Database Management", 4500, "Michael Johnson");
			Course c4 = new Course(104, "Web Development", 5500, "Emily Davis");
			Course c5 = new Course(105, "Machine Learning", 7000, "Robert Brown");
			List<Course> list = Arrays.asList(c1,c2,c3,c4,c5);
			
			
			Mockito.when(service.findAll()).thenReturn(list);
			
			MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/course-api/getAllCourses");
			
			ResultActions result = mockMvc.perform(requestBuilder);
			
			MvcResult mvcResult = result.andReturn();
			
			MockHttpServletResponse response = mvcResult.getResponse();
			
			int status = response.getStatus();
			
			assertEquals(200, status);
			
		} catch (Exception e) 
		{
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
		
	}

}
