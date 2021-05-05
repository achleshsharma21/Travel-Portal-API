package com.nagarro.travelapi.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.nagarro.travelapi.repository.UserRepository;
import com.nagarro.travelapi.utils.EmailSender;
import com.nagarro.travelapi.utils.PasswordGenerator;

import com.nagarro.travelapi.entity.User;

@Service
public class UserService {

	@Autowired
	private UserRepository repository;

	@Autowired
	private PasswordGenerator passwordGenerate;

	@Autowired
	private EmailSender emailSender;

	public User saveUser(User user) {

		user.setPassword(passwordGenerate.generatePassword());
		emailSender.sendMail(user.getUserEmail(), user.getPassword());
		return repository.save(user);
	}

	public List<User> getAllUsers() {
		return repository.findAll();
	}

}
