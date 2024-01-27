package com.sipl.vehicle.manager.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sipl.vehicle.manager.model.User;

public interface UserRepository extends JpaRepository<User, Long>{
 
	Optional<User> findByEmail(String email);
	
}
