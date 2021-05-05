package com.nagarro.travelapi.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nagarro.travelapi.entity.Admin;
import com.nagarro.travelapi.repository.AdminRepository;

@Service
public class AdminService {

	@Autowired
	private AdminRepository repository;

	public Admin saveAdmin(Admin admin) {
		return repository.save(admin);
	}

}
