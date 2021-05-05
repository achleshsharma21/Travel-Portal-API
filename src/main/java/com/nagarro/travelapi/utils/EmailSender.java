package com.nagarro.travelapi.utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailSender {

	@Autowired
	private JavaMailSender jms;

	public void sendMail(String email, String password) {
		SimpleMailMessage smm = new SimpleMailMessage();
		smm.setTo(email);
		smm.setSubject("Nagarro Travel Portal");
		smm.setText("Welcome to Nagarro Portal.\nYour Login credentials are\nUsername: " + email + "\nPassword: "
				+ password + "\n For any details contact Nagarro Travel Team.");
		jms.send(smm);
	}

	public void sendForgetPasswordMail(String email, String password) {
		SimpleMailMessage smm = new SimpleMailMessage();
		smm.setTo(email);
		smm.setSubject("Nagarro Travel Portal Information");
		smm.setText(
				"You have requested your user name and password for the your access to the Nagarro Travel Portal: \n\n"
						+ "Username: " + email + "\nPassword: " + password
						+ "\n\nPlease contact the Travel team if you have any questions."
						+ "\n\nThank you,\nNagarro Travel Team.");
		jms.send(smm);
	}

}
