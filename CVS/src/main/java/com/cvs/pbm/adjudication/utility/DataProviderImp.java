package com.cvs.pbm.adjudication.utility;

import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class DataProviderImp implements DataProvider {

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
	public double calculateCopay(String drugCode, int quantity) {
		return quantity*10;
	}

	@Override
	public boolean requiresPriorAuthorization(String drugId) {
		return "DRUG1".equals(drugId);
		
	}

}
