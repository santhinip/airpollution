package com.air.airPollution.impl;


import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import com.air.airPollution.entity.UserRegistrationRequest;
import com.air.airPollution.model.AdminLoginRequest;
import com.air.airPollution.model.UserActivationRequest;
import com.air.airPollution.model.UserActivationResponse;
import com.air.airPollution.model.UserLoginRequest;
import com.air.airPollution.model.UserRecord;
import com.air.airPollution.repo.UserRegistrationRepo;
import com.air.airPollution.service.UserRegistrationService;
import com.air.airPollution.util.CommonUtil;

@Service
public class UserRegistrationServiceImpl implements UserRegistrationService{

	@Autowired
	private UserRegistrationRepo repo;
	
	@Autowired
	private CommonUtil commonUtil;
	
	@Override
	public ResponseEntity<String> addUser(UserRegistrationRequest user) {
		List<UserRegistrationRequest> userDetails = repo.findAll();
		Iterator<UserRegistrationRequest> itr = userDetails.iterator();
		while (itr.hasNext()) {
			UserRegistrationRequest us = itr.next();
			if (null != us && us.getRole().equalsIgnoreCase("USER") && us.getEmail().equalsIgnoreCase(user.getEmail())) {
				return new ResponseEntity<>("User already exists! ", HttpStatus.BAD_REQUEST);

			}
		}
		user.setUsername(user.getEmail());
		user.setEnabled("false");
		user.setRole("USER");
		repo.save(user);
		return new ResponseEntity<>("User created successfully! UserId: " + user.getUsername(), HttpStatus.OK);
	}
	
	@Override
	public String userLogin(UserLoginRequest user) {
		List<UserRegistrationRequest> userDetails = repo.findAll();
		String status = "Failed";
			Iterator<UserRegistrationRequest> iterator = userDetails.iterator();
			while(iterator.hasNext()) {
				UserRegistrationRequest userrec = iterator.next();
				if (userrec.getRole().equalsIgnoreCase("USER") && userrec.getUsername().equals(user.getUsername())
						&& userrec.getPassword().equals(user.getPassword())) {
					if(userrec.getEnabled().equalsIgnoreCase("false")) {
						return "Inactive";
					}
					return "Success";
				}
			}
		return status;
	}

	@Override
	public UserDetails loadUserByUsername(String userName) {
		UserRegistrationRequest userDetails = repo.getById(userName);
		return new User(userDetails.getUsername(), userDetails.getPassword(), commonUtil.getAthorities(userDetails.getRole()));
	}

	@Override
	public List<UserRecord> viewAllUsers() throws Exception {
		List<UserRegistrationRequest> userDetails = repo.findAll();
		List<UserRecord> usersList = new ArrayList<>();
			Iterator<UserRegistrationRequest> iterator = userDetails.iterator();
			while(iterator.hasNext()) {
				UserRegistrationRequest userrec = iterator.next();
				UserRecord user = new UserRecord();
				if(userrec.getRole().equalsIgnoreCase("USER")) {
					user.setEmail(userrec.getEmail());
					user.setIsActive(userrec.getEnabled());
					user.setPhone(userrec.getPhone());
					user.setUsername(userrec.getUsername());
					usersList.add(user);
				}
			}
		if (!usersList.isEmpty()) {
			return usersList;
		} else {
			throw new Exception("No User Records Available");
		}
	}

	@Override
	public ResponseEntity<?> activateUser(UserActivationRequest userActivationRequest) {
		List<UserRegistrationRequest> userDetails = repo.findAll();
			Iterator<UserRegistrationRequest> iterator = userDetails.iterator();
			while(iterator.hasNext()) {
				UserRegistrationRequest userrec = (UserRegistrationRequest) iterator.next();
				if(null != userrec) {
					if(userrec.getEnabled().equalsIgnoreCase("true")) {
						return new ResponseEntity<>(new UserActivationResponse("Success","USER already Activated"), HttpStatus.OK);
					}
					else if(userrec.getEnabled().equalsIgnoreCase("false") && userrec.getUsername().equalsIgnoreCase(userActivationRequest.getUsername())) {
						userrec.setEnabled("true");
						repo.save(userrec);
						return new ResponseEntity<>(new UserActivationResponse("Success","USER Activated"), HttpStatus.OK);
					}
				}	
			}
		return new ResponseEntity<>(new UserActivationResponse("Failure","User with username "+ userActivationRequest.getUsername()+" not exist"), HttpStatus.BAD_REQUEST);
	}

	@Override
	public String adminLogin(AdminLoginRequest admin) {
		String loginStatus = "Failed";
		UserRegistrationRequest userDetails = repo.getById(admin.getUsername());
		if(userDetails.getRole().equalsIgnoreCase("ADMIN")&& userDetails.getUsername().equals(admin.getUsername()) &&
				userDetails.getPassword().equals(admin.getPassword())) {
			loginStatus = "Success";
		}
		return loginStatus;
	}


}
