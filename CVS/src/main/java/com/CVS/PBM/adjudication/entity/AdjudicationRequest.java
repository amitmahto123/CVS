package com.CVS.PBM.adjudication.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;


@Entity
public class AdjudicationRequest {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private String patientId;
	
	private String DrugId;
	private int quantity;
	private String pharmacyId;
	
	
	 
	
	public String getPatientId() {
		return patientId;
		
		
	}
	public void setPatientId(String patientId) {
		this.patientId = patientId;
	}
	public String getDrugId() {
		return DrugId;
	}
	public void setDrugId(String drugId) {
		DrugId = drugId;
		
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public String getPharmacyId() {
		return pharmacyId;
	}
	public void setPharmacyId(String pharmacyId) {
		this.pharmacyId = pharmacyId;
	}
	
	
		
	

}
