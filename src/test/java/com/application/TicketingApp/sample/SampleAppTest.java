package com.application.TicketingApp.sample;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class SampleAppTest {

	@Test
	void test() 
	{
		SampleApp app = new SampleApp();
		assertEquals("ubbuS",app.ReverseString("Subbu"));

	}
	
	

}
