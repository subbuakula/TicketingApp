package com.application.TicketingApp.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentMatchers;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.application.TicketingApp.entity.Tourist;
import com.application.TicketingApp.service.TouristService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@WebMvcTest(TouristController.class)
class TouristControllerTest 
{
	@MockitoBean
	private TouristService service;
	@Autowired
	private MockMvc mockMvc;
	
	@BeforeAll
	static void setUpBeforeClass() throws Exception 
	{
		System.out.println("Testing initiated..");
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception 
	{
		System.out.println("Testing initiated..");
	}

	@Test
	void test() 
	{
		try 
		{
			Tourist tourist = new Tourist(1,"subbu","Amp","Daimond",3000.0);
			Mockito.when(service.registerTourist(ArgumentMatchers.any())).thenReturn(1);
			ObjectMapper mapper = new ObjectMapper();
		    String touristJson = null;
			
			touristJson = mapper.writeValueAsString(tourist);
//			Creating Mock HTTP request
		    MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.post("/api/register")
   			                                                     		 .contentType(MediaType.APPLICATION_JSON)
   					                                                     .content(touristJson);
//		   mockMvc.perform(reqBuilder) executes the mock HTTP request against API. 
//		   ResultActions result object captures the response after executing the request.
           ResultActions result = mockMvc.perform(requestBuilder);		
//         result.andReturn() method retrieves the result of the API call
//         mvcResult object stores the result, which contains response details.
           MvcResult mvcResult = result.andReturn();
//         mvcResult.getResponse() extracts the response from mvcResult
//         response object stores the response.
           MockHttpServletResponse response = mvcResult.getResponse();
           int status = response.getStatus();
           
           assertEquals(200, status);
           
		} catch (JsonProcessingException e) 
		{
			System.out.println(e.getMessage());
			e.printStackTrace();
		}catch(Exception e)
		{
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
	}

}
