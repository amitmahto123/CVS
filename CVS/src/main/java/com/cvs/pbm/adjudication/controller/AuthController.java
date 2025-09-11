package com.cvs.pbm.adjudication.controller;

import java.util.Map;

import org.springframework.context.annotation.Lazy;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.cvs.pbm.adjudication.dto.AuthRequest;
import com.cvs.pbm.adjudication.exceptions.InvalidCredentialsException;
import com.cvs.pbm.adjudication.security.JwtUtil;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/auth")
public class AuthController {
	
	private final JwtUtil jwtUtil;
	
	public AuthController(JwtUtil jwtUtil) {
		this.jwtUtil = jwtUtil;
	}
	
	// Add endpoints for login, token generation, etc.
	@PostMapping
	@ResponseStatus(HttpStatus.OK)
	public Map<String, String> login(@Valid @RequestBody AuthRequest authRequest) {
		if ("user".equals(authRequest.getUsername()) && "password".equals(authRequest.getPassword())) {
			String token = jwtUtil.generateToken(authRequest.getUsername());
			
			
			return Map.of("token", token);
		} else {
			throw new InvalidCredentialsException("Invalid credentials");
		}
	}
		
	

}
