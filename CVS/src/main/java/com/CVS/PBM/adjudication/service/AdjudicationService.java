package com.CVS.PBM.adjudication.service;

import com.CVS.PBM.adjudication.entity.AdjudicationRequest;
import com.CVS.PBM.adjudication.entity.AdjudicationResponse;

public interface AdjudicationService {
	
	public AdjudicationResponse processClaim(AdjudicationRequest request);
	public boolean checkPatientEligibility(String patientId);
	public boolean isDrugCovered(String drugCode);
	public double calculateCopay(String drugCode, int quantity);
	public boolean requiresPriorAuthorization(String drugCode);
	

}
