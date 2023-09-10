package com.sr.travels.main;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication()
@ComponentScan("com.sr.travels")
public class SrTravelsMainApplication extends SpringBootServletInitializer {

	public static void main(String[] args) {
		SpringApplication.run(SrTravelsMainApplication.class, args);
	}

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(SrTravelsMainApplication.class);
	}

}
