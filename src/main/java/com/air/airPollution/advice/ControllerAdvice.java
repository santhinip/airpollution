package com.air.airPollution.advice;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.air.airPollution.model.Response;


@RestControllerAdvice
public class ControllerAdvice {
	
	
	@ExceptionHandler(Exception.class)
	public ResponseEntity<?> getFailureResponse(Exception e) {
		
		return ResponseEntity.status(400).body(new Response("FAILURE",e.getMessage()));
	}

}
