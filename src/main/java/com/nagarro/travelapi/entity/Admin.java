package com.nagarro.travelapi.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Admin {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int adminID;

	@Column(nullable = false)
	private String adminEmail;

	@Column(nullable = false)
	private String adminPassword;

	public int getAdminID() {
		return adminID;
	}

	public void setAdminID(int adminID) {
		this.adminID = adminID;
	}

	public String getAdminEmail() {
		return adminEmail;
	}

	public void setAdminEmail(String adminEmail) {
		this.adminEmail = adminEmail;
	}

	public String getAdminPassword() {
		return adminPassword;
	}

	public void setAdminPassword(String adminPassword) {
		this.adminPassword = adminPassword;
	}

	public Admin(int adminID, String adminPassword) {
		super();
		this.adminID = adminID;
		this.adminPassword = adminPassword;
	}

	public Admin() {
		super();
		// TODO Auto-generated constructor stub
	}

}
