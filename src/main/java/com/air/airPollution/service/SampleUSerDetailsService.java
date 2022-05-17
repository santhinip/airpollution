package com.air.airPollution.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.air.airPollution.repo.UserRepository;

@Service
public class SampleUSerDetailsService implements UserDetailsService{

	@Autowired
	private UserRepository userRepo;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		com.air.airPollution.entity.User user = userRepo.getById(username);
		
		// TODO Auto-generated method stub
		return new User(user.getUsername(),user.getPassword(),new ArrayList<>());
	}

}
