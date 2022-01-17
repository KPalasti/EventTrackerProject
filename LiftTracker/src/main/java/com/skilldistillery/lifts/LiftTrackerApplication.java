package com.skilldistillery.lifts;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication
public class LiftTrackerApplication extends SpringBootServletInitializer {
	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(LiftTrackerApplication.class);
	}

	public static void main(String[] args) {
		SpringApplication.run(LiftTrackerApplication.class, args);
	}

}
