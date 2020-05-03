package com.hcl.poc.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Airplane implements Serializable {

	private static final long serialVersionUID = 570235488278506106L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long airplaneId;
	private String model;
	private String macNo;
	private String facility;
	
	public String getModel() {
		return model;
	}
	public void setModel(String model) {
		this.model = model;
	}
	public String getMacNo() {
		return macNo;
	}
	public void setMacNo(String macNo) {
		this.macNo = macNo;
	}
	public String getFacility() {
		return facility;
	}
	public long getAirplaneId() {
		return airplaneId;
	}
	public void setAirplaneId(long airplaneId) {
		this.airplaneId = airplaneId;
	}
	public void setFacility(String facility) {
		this.facility = facility;
	}

	
	
}
