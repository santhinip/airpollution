package com.air.airPollution.service;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import com.air.airPollution.entity.UserRegistrationRequest;
import com.air.airPollution.model.AdminLoginRequest;
import com.air.airPollution.model.UserActivationRequest;
import com.air.airPollution.model.UserLoginRequest;
import com.air.airPollution.model.UserRecord;

@Service
public interface UserRegistrationService {

	public ResponseEntity<String> addUser(UserRegistrationRequest user);

	public String userLogin(UserLoginRequest user);
	
	public UserDetails loadUserByUsername(String string);
	
	public List<UserRecord> viewAllUsers() throws Exception;
	
	public ResponseEntity<?> activateUser(UserActivationRequest userActivationRequest) throws Exception;
	
	public String adminLogin(AdminLoginRequest admin);
	
}
