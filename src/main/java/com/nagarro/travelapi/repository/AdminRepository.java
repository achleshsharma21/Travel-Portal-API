package com.nagarro.travelapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.nagarro.travelapi.entity.Admin;
import com.nagarro.travelapi.entity.User;

public interface AdminRepository extends JpaRepository<Admin, Integer> {

	@Query("FROM Admin WHERE admin_email=:email")
	public Admin getAdminByEmail(String email);

}
