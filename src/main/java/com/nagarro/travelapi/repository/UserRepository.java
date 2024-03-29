package com.nagarro.travelapi.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.nagarro.travelapi.entity.Ticket;
import com.nagarro.travelapi.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

	@Query("FROM User WHERE user_email=:email")
	public User getUserByEmail(String email);

	@Query("SELECT password FROM User WHERE user_email=:email")
	public String getUserPassword(String email);

}
