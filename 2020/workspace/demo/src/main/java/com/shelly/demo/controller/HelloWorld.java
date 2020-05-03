package com.shelly.demo.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.shelly.demo.service.MyService;

@RestController
@RequestMapping("/demo")
public class HelloWorld {
	
	private static final Logger LOGGER=LoggerFactory.getLogger(HelloWorld.class);
	
	@Value("${spring.application.name:demoDefaultservice}")
	private String appName;
	@Autowired
	private Environment environment;
	@Autowired
	MyService myService;
	
	@GetMapping("/hello")
	public String welcome(){
		LOGGER.info("----My add-->"+myService.addition());
		LOGGER.info("My Profile-->"+environment.getDefaultProfiles().length);
		
		return "Hello World!!" +"**"+appName ;
		
	}
    @Bean
	public MyService getMyService(){
		return new MyService();
	}
}
