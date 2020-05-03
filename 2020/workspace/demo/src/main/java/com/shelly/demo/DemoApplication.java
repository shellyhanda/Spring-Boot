package com.shelly.demo;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class DemoApplication implements CommandLineRunner{ //ApplicationRunner {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	/*@Override
	public void run(ApplicationArguments args) throws Exception {
	
		System.out.println("I am in  ApplicationRunner method ..."+args.toString());
		
	}*/

	@Override
	public void run(String... args) throws Exception {
		System.out.println("I am in  CommandLineRunner method ..."+args.toString());
		
	}

}
