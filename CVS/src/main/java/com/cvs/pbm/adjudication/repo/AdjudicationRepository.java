package com.cvs.pbm.adjudication.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cvs.pbm.adjudication.entity.AdjudicationRequest;

@Repository
public interface AdjudicationRepository extends JpaRepository<AdjudicationRequest, String> {

}
