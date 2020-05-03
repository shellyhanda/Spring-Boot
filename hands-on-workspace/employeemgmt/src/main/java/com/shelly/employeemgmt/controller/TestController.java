package com.shelly.employeemgmt.controller;

import java.util.LinkedHashMap;

import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
/**
 * This class is to test the various return types of the Spring boot controllers
 * @author zh722e
 * There are many return types are available for a controller method in Spring MVC which is annotated by @RequestMapping inside the controller. Some of the popular ones are:
	String
	void
	View
	ModelAndView (Class)
	Model (Interface)
	Map
	HttpEntity<?> or ResponseEntity<?>
	HttpHeaders

 *
 */

import com.shelly.employeemgmt.model.Employee;
@RestController
public class TestController {
	
	 private final Logger LOGGER = LogManager.getLogger(this.getClass().getName());
	 
	 @Value("${mymessage}")
	  private String myMessage;
	
	@GetMapping("/str")
	public String stringMethod() {
		return "hello";
	}
	@GetMapping("/hello")
	public void voidMethod() {
		System.out.println("Hello World!!");	
		LOGGER.trace("I m logging trace Shelly");
	}
	
	/*
	 * @GetMapping("/hello") public View viewMethod() {
	 * System.out.println("Hello World!!"); }
	 */
	 
	
	@GetMapping("/mv")
	public ModelAndView modelAndViewMethod() {
		 
		  String helloWorldMessage = "Hello world from java2blog!";
		  return new ModelAndView("hello", "message", helloWorldMessage);
		 }
	
	@GetMapping("/model")
	public String modelMethod(Model model) {
		 
		 model.addAttribute("message", "Hello FRom Model");
		  return "hello";
		 }
	
	@GetMapping("/modelmap")
	public String modelMethod(ModelMap modelMap) {
			modelMap.addAttribute("message", myMessage);
		  return "hello";
		 }
	
	@GetMapping("/hello1")
	public Map<String,String> mapMethod() {
		
		Map<String,String> empMap= new LinkedHashMap();
		empMap.put("key", "I am map value");
		return empMap;
	}
	
	@GetMapping("/re")
	public ResponseEntity<Employee> responseMethod(){
		
		Employee emp= new Employee();
		emp.setEmpId(1);
		emp.setFirstName("Shelly");
		emp.setLastName("Handa");
		
		return ResponseEntity.ok().body(emp);
	}

}
