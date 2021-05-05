package com.nagarro.travelapi.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;

@Entity
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	@Email(message = "Not a valid Email.")
	@Column(nullable = false)
	private String userEmail;
	@Column(nullable = false)
	private String fName;
	@Column(nullable = false)
	private String lName;
	@Column(nullable = false)
	private String businessUnit;
	@Column(nullable = false)
	private String userTitle;
	@Column(nullable = false)
	private String userTelephone;
	@Column(nullable = false)
	private String userAddress;
	@Column(nullable = false)
	private String userCity;
	@Column(nullable = false)
	private String userState;
	@Column(nullable = false)
	private String userZip;
	@Column(nullable = false)
	private String userCountry;
	@Column(nullable = false)
	private String password;

	public String getUserEmail() {
		return userEmail;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getfName() {
		return fName;
	}

	public void setfName(String fName) {
		this.fName = fName;
	}

	public String getlName() {
		return lName;
	}

	public void setlName(String lName) {
		this.lName = lName;
	}

	public String getBusinessUnit() {
		return businessUnit;
	}

	public void setBusinessUnit(String businessUnit) {
		this.businessUnit = businessUnit;
	}

	public String getUserTitle() {
		return userTitle;
	}

	public void setUserTitle(String userTitle) {
		this.userTitle = userTitle;
	}

	public String getUserTelephone() {
		return userTelephone;
	}

	public void setUserTelephone(String userTelephone) {
		this.userTelephone = userTelephone;
	}

	public String getUserAddress() {
		return userAddress;
	}

	public void setUserAddress(String userAddress) {
		this.userAddress = userAddress;
	}

	public String getUserCity() {
		return userCity;
	}

	public void setUserCity(String userCity) {
		this.userCity = userCity;
	}

	public String getUserState() {
		return userState;
	}

	public void setUserState(String userState) {
		this.userState = userState;
	}

	public String getUserZip() {
		return userZip;
	}

	public void setUserZip(String userZip) {
		this.userZip = userZip;
	}

	public String getUserCountry() {
		return userCountry;
	}

	public void setUserCountry(String userCountry) {
		this.userCountry = userCountry;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}

	public User(int id, @NotNull String userEmail, String fName, String lName, String businessUnit, String userTitle,
			String userTelephone, String userAddress, String userCity, String userState, String userZip,
			String userCountry, String password) {
		super();
		this.id = id;
		this.userEmail = userEmail;
		this.fName = fName;
		this.lName = lName;
		this.businessUnit = businessUnit;
		this.userTitle = userTitle;
		this.userTelephone = userTelephone;
		this.userAddress = userAddress;
		this.userCity = userCity;
		this.userState = userState;
		this.userZip = userZip;
		this.userCountry = userCountry;
		this.password = password;
	}

	public User() {
		super();
		// TODO Auto-generated constructor stub
	}

}
