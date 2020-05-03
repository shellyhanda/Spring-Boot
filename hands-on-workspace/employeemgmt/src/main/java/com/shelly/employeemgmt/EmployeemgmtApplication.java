package com.shelly.employeemgmt;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@SpringBootApplication
@EnableJpaAuditing
public class EmployeemgmtApplication {

	public static void main(String[] args) {
		SpringApplication.run(EmployeemgmtApplication.class, args);
	}

}
