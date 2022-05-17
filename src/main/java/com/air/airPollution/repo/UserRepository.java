package com.air.airPollution.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.air.airPollution.entity.User;

public interface UserRepository extends JpaRepository<User, String> {

}
