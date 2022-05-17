package com.air.airPollution.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.air.airPollution.entity.UserRegistrationRequest;

public interface UserRegistrationRepo extends JpaRepository<UserRegistrationRequest, String>  {

}
