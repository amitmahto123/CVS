
package com.cvs.pbm.adjudication.exceptions;


import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.server.MethodNotAllowedException;

import com.cvs.pbm.adjudication.dto.ErrorDetail;

@RestControllerAdvice
public class GlobalExceptionHandler {


	private static final Logger logger = LoggerFactory.getLogger(GlobalExceptionHandler.class);

	
	@ExceptionHandler(InvalidCredentialsException.class)
	public ErrorDetail handleInvalidCredentialsException(InvalidCredentialsException ex, WebRequest request) {
		logger.error("InvalidCredentialsException occurred: {}", ex.getMessage());
		String instance = request.getDescription(false);
		return new ErrorDetail("https://example.com/probs/invalid-credentials",
				"Validation Error",
				HttpStatus.UNAUTHORIZED.value(), 
				ex.getMessage(),
				instance);
	}
	
	@ExceptionHandler(MethodNotAllowedException.class)
	public ErrorDetail handleMethodNotAllowedException(MethodNotAllowedException ex, WebRequest request) {
		logger.error("MethodNotAllowedException occurred: {}", ex.getMessage());
		String instance = request.getDescription(false);
		return new ErrorDetail("https://example.com/probs/method-not-allowed", "Method Not Allowed",
				HttpStatus.METHOD_NOT_ALLOWED.value(), ex.getMessage(), instance);
	}
	
	
	@ExceptionHandler(Exception.class)
	public ErrorDetail handleGenericException(Exception ex, WebRequest request) {
		logger.error("An unexpected error occurred: {}", ex.getMessage(), ex);
		String instance = request.getDescription(false);
		
		return new ErrorDetail("https://example.com/probs/internal-server-error", 
				"Internal Server Error",
				HttpStatus.INTERNAL_SERVER_ERROR.value(),
				"An unexpected error occurred. Please try again later.",
				instance);
	}
}
