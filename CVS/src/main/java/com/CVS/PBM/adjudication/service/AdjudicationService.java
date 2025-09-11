package com.CVS.PBM.adjudication.service;

import com.CVS.PBM.adjudication.entity.AdjudicationRequest;
import com.CVS.PBM.adjudication.entity.AdjudicationResponse;

public interface AdjudicationService {
	
	public AdjudicationResponse processClaim(AdjudicationRequest request);
	
	

}
