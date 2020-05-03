package com.hcl.poc.controller;

import javax.sql.DataSource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.hcl.poc.model.Airplane;
import com.hcl.poc.repo.AirplaneRepository;
import com.hcl.poc.repo.AirplaneSP;

@RestController
@RequestMapping(path="/demo") 
public class FlightController {
	private final Logger LOGGER = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	@Autowired
	private AirplaneRepository airplaneRepository;
	@Autowired
	DataSource source;
	@Autowired
	AirplaneSP sproc;
	
	public void setDataSource(DataSource source){ 
		this.jdbcTemplate = new JdbcTemplate(source); 
	    this.sproc = new AirplaneSP(jdbcTemplate.getDataSource());
	  }

	
	@GetMapping("/add")
	public boolean addNewAirplane(@RequestParam String model,@RequestParam String macNo,@RequestParam String facility) {
		Airplane airplane=new Airplane();
		airplane.setFacility(facility);
		airplane.setMacNo(macNo);
		airplane.setModel(model);
		System.out.println("Data found-->"+facility+ "::"+model+"::"+macNo);
		airplaneRepository.save(airplane);
		LOGGER.debug("Airplane Saved.....");
		return true;
	}
	
	@GetMapping("/all")
	public @ResponseBody Iterable<Airplane> getAllAirplanes() {
		LOGGER.info("Inside getAllAirplanes.....");
		//System.out.println("Procedure result--"+sproc.execute(2));
		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();

		return airplaneRepository.findAll();
	}
	
	
	/*
	 * @GetMapping("/hello") public FlightData index() { return new
	 * FlightData("787","2.3"); }
	 */
	
	  public void init() {
		  System.out.println("I m in init method**************@@@///???");
	  }

}
