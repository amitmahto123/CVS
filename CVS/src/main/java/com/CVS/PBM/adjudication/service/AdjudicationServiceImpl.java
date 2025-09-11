package com.CVS.PBM.adjudication.service;


import org.springframework.stereotype.Service;

import com.CVS.PBM.adjudication.entity.AdjudicationRequest;
import com.CVS.PBM.adjudication.entity.AdjudicationResponse;
import com.CVS.PBM.adjudication.utility.DataProvider;


@Service
public class AdjudicationServiceImpl implements AdjudicationService{
	
	private final DataProvider dataProvider;
	
	public AdjudicationServiceImpl(DataProvider dataProvider) {
		this.dataProvider=dataProvider;
	}

	@Override
	public AdjudicationResponse processClaim(AdjudicationRequest request) {
		
		boolean eligible = dataProvider.checkPatientEligibility(request.getPatientId());
		if(!eligible)
		{
			return new AdjudicationResponse("Denied",0.0,"Patient is not Eligibale");
		}
		
		boolean drugCovered = dataProvider.isDrugCovered(request.getDrugId());
		if (!drugCovered) {
			return new AdjudicationResponse("Denied", 0.0, " Drug : " + request.getDrugId() + " is not Covered");
		}

		boolean requiresPriorAuthorization = dataProvider.requiresPriorAuthorization(request.getDrugId());
		if (requiresPriorAuthorization) {
			
			return new AdjudicationResponse("DENIED", 0.0,"Prior Authorization is required for this drug : " + request.getDrugId());
		}

		double copay = dataProvider.calculateCopay(request.getDrugId(), request.getQuantity());
		
		return new AdjudicationResponse("Approved",copay, "Claim approved Successfully");
	}
	
	


}
