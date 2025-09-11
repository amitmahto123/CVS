package com.CVS.PBM.adjudication.controller;

import java.util.Map;

import org.springframework.context.annotation.Lazy;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.CVS.PBM.adjudication.dto.AuthRequest;
import com.CVS.PBM.adjudication.exceptions.InvalidCredentialsException;
import com.CVS.PBM.adjudication.security.JwtUtil;

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
	public Map<String, String> login(@RequestBody AuthRequest authRequest) {
		if ("user".equals(authRequest.username()) && "password".equals(authRequest.password())) {
			String token = jwtUtil.generateToken(authRequest.username());
			System.out.println(token);
			System.out.println(authRequest.username());
			System.out.println(authRequest.password());
			
			return Map.of("token", token);
		} else {
			throw new InvalidCredentialsException("Invalid credentials");
		}
	}
		
	

}
