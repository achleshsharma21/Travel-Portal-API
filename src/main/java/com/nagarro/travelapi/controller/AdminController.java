package com.nagarro.travelapi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.nagarro.travelapi.entity.Admin;
import com.nagarro.travelapi.repository.AdminRepository;

@CrossOrigin
@RestController
public class AdminController {

	@Autowired
	private AdminRepository adminRepo;

	@GetMapping("/getadmin/{adminEmail}")
	public ResponseEntity<Admin> getAdmin(@PathVariable(value = "adminEmail") String email) {
		try {
			Admin admin = adminRepo.getAdminByEmail(email);
			return ResponseEntity.ok().body(admin);
		} catch (Exception e) {
			// TODO: handle exception
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
}
