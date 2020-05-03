package com.shelly.employeemgmt.DAO;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shelly.employeemgmt.model.Employee;
import com.shelly.employeemgmt.repository.EmployeeRepository;

@Service
public class EmployeeDAO {

    @Autowired
	EmployeeRepository employeeRepository;
    
    /**
     * To Save an Employee
     */
    public Employee save(Employee emp) {
    	System.out.println("my name in DAO"+emp.getFirstName());
    	return employeeRepository.save(emp);
    }
    
    /**
     * Search all Employee
     */
    
    public List<Employee> findAll(){
    	
    	return employeeRepository.findAll();
    }
    
    /**
     * To get an Employee
     */
    public Optional<Employee> findOne(Long empId) {
    	
    	return employeeRepository.findById(empId);
    }
    
    /**
     * To Delete an Employee
     */
    public void delete(Employee emp) {
    	employeeRepository.delete(emp);
    }
}
