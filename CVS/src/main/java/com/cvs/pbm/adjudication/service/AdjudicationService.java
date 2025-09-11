package com.cvs.pbm.adjudication.service;

import com.cvs.pbm.adjudication.entity.AdjudicationRequest;
import com.cvs.pbm.adjudication.entity.AdjudicationResponse;

public interface AdjudicationService {
	
	public AdjudicationResponse processClaim(AdjudicationRequest request);
	
	

}
