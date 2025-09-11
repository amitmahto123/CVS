package com.cvs.pbm.adjudication.entity;

public class AdjudicationResponse {

	private String status;
	private double copayAmount;
	private String message;
	
	
	
	
	public AdjudicationResponse() {
		super();
	}
	
	
	public AdjudicationResponse(String status, double copayAmount, String message) {
		super();
		this.status = status;
		this.message = message;
		this.copayAmount = copayAmount;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public double getCopayAmount() {
		return copayAmount;
	}
	public void setCopayAmount(double copayAmount) {
		this.copayAmount = copayAmount;
	}
	
	

		
}
