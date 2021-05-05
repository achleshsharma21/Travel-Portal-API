package com.nagarro.travelapi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.nagarro.travelapi.entity.User;
import com.nagarro.travelapi.repository.UserRepository;
import com.nagarro.travelapi.service.UserService;
import com.nagarro.travelapi.utils.EmailSender;

@CrossOrigin
@RestController
public class UserController {

	@Autowired
	private UserService service;

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private EmailSender emailSender;

	@PostMapping("/adduser")
	public ResponseEntity<User> addUser(@RequestBody User user) {
		try {
			service.saveUser(user);
			return ResponseEntity.ok().body(user);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);
		}
	}

	@GetMapping("/allusers")
	public List<User> getAllUsers() {
		return service.getAllUsers();
	}

	@GetMapping("/userbyemail/{userEmail}")
	public ResponseEntity<User> getByEmail(@PathVariable(value = "userEmail") String email) {
		try {
			User user = userRepository.getUserByEmail(email);
			return ResponseEntity.ok().body(user);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
	}

	@GetMapping("/passbyemail/{userEmail}")
	public String passByEmail(@PathVariable(value = "userEmail") String email) {
		String password = "";
		try {
			password = userRepository.getUserPassword(email);
			return password;

		} catch (Exception e) {
			return "Wrong Email" + e;
		}
	}

	@GetMapping(value = "/forgotpass/{userEmail}")
	public boolean sendPassword(@PathVariable(value = "userEmail") String userEmail) {
		System.out.println(userEmail);
		try {
			User user = userRepository.getUserByEmail(userEmail);
			emailSender.sendForgetPasswordMail(user.getUserEmail(), user.getPassword());
			return true;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return false;
		}
	}
}
