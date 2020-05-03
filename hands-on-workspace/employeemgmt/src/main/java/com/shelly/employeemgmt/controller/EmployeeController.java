package com.shelly.employeemgmt.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.shelly.employeemgmt.DAO.EmployeeDAO;
import com.shelly.employeemgmt.model.Employee;

@RestController
@RequestMapping("/company")
public class EmployeeController {
	
  private Logger logger = LogManager.getLogger(this.getClass().getName());  
	
	@Autowired
   EmployeeDAO employeeDAO;
	
	@PostMapping("/employees")
	public Employee createEmployee(@Valid @RequestBody Employee emp) {
		
		return employeeDAO.save(emp);
	}
	
	@GetMapping("/employees")
	public List<Employee> getAllEmployees(){
		
		return employeeDAO.findAll();
	}
	
	@GetMapping("/employees/{id}")
	public ResponseEntity<Optional<Employee>> getEmployeeById(@PathVariable(value="id") Long empId) {
		
		Optional<Employee> emp =employeeDAO.findOne(empId);
		logger.trace("mytrace="+ResponseEntity.notFound().build());
		return ResponseEntity.ok().body(emp);
	}
	
	@PutMapping("/employees/{id}")
	public ResponseEntity<Optional<Employee>> updateEmployee(@PathVariable(value="id") Long empId,@Valid @RequestBody Employee empDetails){
		Optional<Employee> emp =employeeDAO.findOne(empId);
		Employee e=emp.get();
		e.setEmpId(empDetails.getEmpId());
		e.setFirstName(empDetails.getFirstName());
		employeeDAO.save(e);
		return ResponseEntity.ok(emp);
	}
	
	@DeleteMapping("/employees/{id}")
	public ResponseEntity<Optional<Employee>> deleteEmployee(@PathVariable(value="id") Long empId){
		Optional<Employee> emp =employeeDAO.findOne(empId);
		employeeDAO.delete(emp.get());
		return ResponseEntity.ok().body(emp);
		
	}
	
	
}
