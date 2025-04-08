package com.application.TicketingApp;

import org.springframework.boot.Banner;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.servers.Server;

@SpringBootApplication
@OpenAPIDefinition(
		info=@Info(title="Ticket Booking API",
				   version="1.0",
				   description="This is Sample application"),
		servers=@Server(url="http://localhost:8080/TicketingApp",
						description="This is the location where the application is being deployed.")
		)

public class TicketingAppApplication {

	public static void main(String[] args) 
	{
		new SpringApplicationBuilder(TicketingAppApplication.class)
		      .bannerMode(Banner.Mode.CONSOLE)
		      .run(args);
	}
}
