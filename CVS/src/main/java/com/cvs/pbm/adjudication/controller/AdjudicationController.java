package com.cvs.pbm.adjudication.controller;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.cvs.pbm.adjudication.entity.AdjudicationRequest;
import com.cvs.pbm.adjudication.entity.AdjudicationResponse;
import com.cvs.pbm.adjudication.service.AdjudicationService;
import com.fasterxml.jackson.annotation.JacksonInject.Value;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/adjudication")
public class AdjudicationController {
	
	private final AdjudicationService adjudicationService;
	
	public AdjudicationController(AdjudicationService adjudicationService) {
		this.adjudicationService = adjudicationService;
	}
	
	@PostMapping("/status")
	@ResponseStatus(value = org.springframework.http.HttpStatus.CREATED)
	public AdjudicationResponse processClaim(@Valid @RequestBody AdjudicationRequest request) {
		return adjudicationService.processClaim(request);
	}
		

}
