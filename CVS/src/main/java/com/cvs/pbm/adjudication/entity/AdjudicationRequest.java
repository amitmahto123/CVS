package com.cvs.pbm.adjudication.entity;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;


@Entity
public class AdjudicationRequest {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private String patientId;
	
	@NotBlank(message = "DrugId is mandatory")
	private String DrugId;
	
	@Min(value = 1, message = "Quantity must be at least 1")
	@Max(value = 10, message = "Quantity must be less than or equal to 10")
	@Schema(description = "Quantity of the drug", defaultValue = "1")
	private int quantity;
	
	@NotBlank(message = "PharmacyId is mandatory")
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
