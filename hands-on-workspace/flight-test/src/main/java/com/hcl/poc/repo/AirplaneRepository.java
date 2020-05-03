package com.hcl.poc.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hcl.poc.model.Airplane;

@Repository
public interface AirplaneRepository extends JpaRepository<Airplane, Long>{
	
	

}
