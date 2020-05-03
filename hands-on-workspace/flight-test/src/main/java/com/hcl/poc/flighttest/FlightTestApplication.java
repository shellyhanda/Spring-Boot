package com.hcl.poc.flighttest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan({"com.hcl.poc.controller","com.hcl.poc.repo"})
@EntityScan("com.hcl.poc.model")
@EnableJpaRepositories({"com.hcl.poc.repo"})
public class FlightTestApplication {

	public static void main(String[] args) {
		SpringApplication.run(FlightTestApplication.class, args);
	}

}
