package com.CVS.PBM.adjudication.utility;

public interface DataProvider {
	
	public boolean checkPatientEligibility(String patientId);
	public boolean isDrugCovered(String drugCode);
	public double calculateCopay(String drugCode, int quantity);
	public boolean requiresPriorAuthorization(String drugCode);
	
	
}
