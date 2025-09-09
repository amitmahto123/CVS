package com.CVS.PBM.adjudication.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.CVS.PBM.adjudication.entity.AdjudicationRequest;

@Repository
public interface AdjudicationRepository extends JpaRepository<AdjudicationRequest, String> {

}
