package com.CVS.PBM.adjudication.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.CVS.PBM.adjudication.entity.AdjudicationRequest;
import com.CVS.PBM.adjudication.entity.AdjudicationResponse;

import io.swagger.v3.oas.annotations.servers.Server;

@Service
public class AdjudicationServiceImpl implements AdjudicationService{

	@Override
	public AdjudicationResponse processClaim(AdjudicationRequest request) {
		
		boolean eligible = checkPatientEligibility(request.getPatientId());
		if(!eligible)
		{
			return new AdjudicationResponse("Denied",0.0,"Patient is not Eligibale");
		}
		
		boolean drugCovered = isDrugCovered(request.getDrugId());
		if (!drugCovered) {
			return new AdjudicationResponse("Denied", 0.0, " Drug : " + request.getDrugId() + " is not Covered");
		}

		boolean requiresPriorAuthorization = requiresPriorAuthorization(request.getDrugId());
		if (requiresPriorAuthorization) {
			
			return new AdjudicationResponse("DENIED", 0.0,"Prior Authorization is required for this drug : " + request.getDrugId());
		}

		double copay = calculateCopay(request.getDrugId(), request.getQuantity());
		
		return new AdjudicationResponse("Approved",copay, "Claim approved Successfully");
	}
	
	

	@Override
	public boolean checkPatientEligibility(String patientId) {
		
		return !"INELIGIBLE_PATIENT".equals(patientId);
	}

	@Override
	public boolean isDrugCovered(String drugId) {
		List<String> coveredDrugList=List.of("DRUG1","DRUG2","DRUG3","DRUG4","DRUG5","DRUG6");
		return coveredDrugList.contains(drugId);
	}

	@Override
	public double calculateCopay(String drugId, int quantity) {
		
		return quantity*10;
	}

	@Override
	public boolean requiresPriorAuthorization(String drugId) {
		
		return "DRUG1".equals(drugId);
	}

	

}
