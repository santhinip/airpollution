package com.air.airPollution.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.air.airPollution.entity.UserRegistrationRequest;
import com.air.airPollution.model.AddToFavCitiesRequest;
import com.air.airPollution.model.AdminLoginRequest;
import com.air.airPollution.model.UserActivationRequest;
import com.air.airPollution.model.UserLoginRequest;
import com.air.airPollution.model.UserLoginResponse;
import com.air.airPollution.model.UserRecord;
import com.air.airPollution.model.ViewCitiesRequest;
import com.air.airPollution.service.AddToFavService;
import com.air.airPollution.service.UserRegistrationService;
import com.air.airPollution.service.ViewCitiesService;
import com.air.airPollution.util.JWTUtil;

@RestController
public class Controller {

	@Autowired
	private JWTUtil jwtTokenUtil;

	@Autowired
	private UserRegistrationService registrationService;

	@Autowired
	private ViewCitiesService viewService;

	@Autowired
	private AddToFavService addToFavService;

	@PostMapping("/userlogin")
	public ResponseEntity<?> userLogin(@RequestBody UserLoginRequest request) throws Exception {
		String loginStatus = registrationService.userLogin(request);
		if (loginStatus.equalsIgnoreCase("Failed")) {
			return new ResponseEntity<String>("Login Failed! Invalid username or password", HttpStatus.BAD_REQUEST);
		} else if (loginStatus.equalsIgnoreCase("Inactive")) {
			return new ResponseEntity<String>("Login Failed! User Inactive", HttpStatus.BAD_REQUEST);
		}

		UserDetails userDetails = registrationService.loadUserByUsername(request.getUsername());
		final String jwtToken = jwtTokenUtil.generateToken(userDetails);
		return ResponseEntity.ok(new UserLoginResponse(jwtToken, "SUCCESS", "User logined successfully"));
	}

	@PostMapping("/usersignUp")
	public ResponseEntity<String> addUser(@RequestBody UserRegistrationRequest user) throws Exception {
		return registrationService.addUser(user);
	}

	@PostMapping("/adminlogin")
	public ResponseEntity<?> adminLogin(@RequestBody AdminLoginRequest request) throws Exception {

		String loginStatus = registrationService.adminLogin(request);
		if (loginStatus.equalsIgnoreCase("Failed")) {
			return new ResponseEntity<String>("Login Failed! Invalid username or password", HttpStatus.BAD_REQUEST);
		}

		UserDetails userDetails = registrationService.loadUserByUsername(request.getUsername());
		final String jwtToken = jwtTokenUtil.generateToken(userDetails);
		return ResponseEntity.ok(new UserLoginResponse(jwtToken, "SUCCESS", "Admin logined successfully"));
	}

	@GetMapping("/adminviewuserlist")
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	public List<UserRecord> viewAllUsers(Authentication auth) throws Exception {
		if(auth.getName().equalsIgnoreCase("admin")) {
		return registrationService.viewAllUsers();
		}
		else {
			throw new Exception("Access Denied");
		}
	}

	@PutMapping("/adminactivateuser")
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	public ResponseEntity<?> activateUser(@RequestBody UserActivationRequest request,Authentication auth) throws Exception {
		if(auth.getName().equalsIgnoreCase("admin")) {
		return registrationService.activateUser(request);
		}else {
			throw new Exception("Access Denied");
		}
	}

	@GetMapping("/userviewcities")
	public ResponseEntity<?> viewCities(@RequestBody ViewCitiesRequest request) throws Exception {
		return viewService.viewCities(request);

	}

	@PutMapping("/useraddToFavorite")
	public ResponseEntity<?> addToFavorite(@RequestBody AddToFavCitiesRequest request, Authentication auth) {
		return addToFavService.addToFav(request, auth.getName());
	}

}
