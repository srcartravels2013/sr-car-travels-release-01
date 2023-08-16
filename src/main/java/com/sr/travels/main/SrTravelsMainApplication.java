package com.sr.travels.main;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication()
@ComponentScan("com.sr.travels")
public class SrTravelsMainApplication {

	public static void main(String[] args) {
		SpringApplication.run(SrTravelsMainApplication.class, args);
	}

}
