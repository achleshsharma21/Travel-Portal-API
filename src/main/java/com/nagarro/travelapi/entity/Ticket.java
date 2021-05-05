package com.nagarro.travelapi.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Ticket {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int ticketid;

	@Column(nullable = false)
	private String reqType;

	@Column(nullable = false)
	private String ticketPriority;

	@Column(nullable = false)
	private String travelCity;

	@Column(nullable = false)
	private String fromCity;

	@Column(nullable = false)
	private String fromDate;

	@Column(nullable = false)
	private String toDate;

	@Column(nullable = false)
	private String passportNumber;

	@Column(nullable = false)
	private String projectName;

	@Column(nullable = false)
	private String expenseBorne;

	@Column(nullable = false)
	private String travelApproveBy;

	@Column(nullable = false)
	private String travelDuration;

	@Column(nullable = false)
	private String upperBoundExpense;

	@Column(nullable = false)
	private String additionalDetails;
	
	@Column(nullable = false)
	private String ticketStatus;
	
	@Column
	private String adminComment;

	@ManyToOne
	@JoinColumn(name = "userId", nullable = false)
	private User user;

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public int getTicketid() {
		return ticketid;
	}

	public void setTicketid(int ticketid) {
		this.ticketid = ticketid;
	}

	public String getReqType() {
		return reqType;
	}

	public void setReqType(String reqType) {
		this.reqType = reqType;
	}

	public String getTicketPriority() {
		return ticketPriority;
	}

	public void setTicketPriority(String ticketPriority) {
		this.ticketPriority = ticketPriority;
	}

	public String getTravelCity() {
		return travelCity;
	}

	public void setTravelCity(String travelCity) {
		this.travelCity = travelCity;
	}

	public String getFromCity() {
		return fromCity;
	}

	public void setFromCity(String fromCity) {
		this.fromCity = fromCity;
	}

	public String getFromDate() {
		return fromDate;
	}

	public void setFromDate(String fromDate) {
		this.fromDate = fromDate;
	}

	public String getToDate() {
		return toDate;
	}

	public void setToDate(String toDate) {
		this.toDate = toDate;
	}

	public String getPassportNumber() {
		return passportNumber;
	}

	public void setPassportNumber(String passportNumber) {
		this.passportNumber = passportNumber;
	}

	public String getProjectName() {
		return projectName;
	}

	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}

	public String getExpenseBorne() {
		return expenseBorne;
	}

	public void setExpenseBorne(String expenseBorne) {
		this.expenseBorne = expenseBorne;
	}

	public String getTravelApproveBy() {
		return travelApproveBy;
	}

	public void setTravelApproveBy(String travelApproveBy) {
		this.travelApproveBy = travelApproveBy;
	}

	public String getTravelDuration() {
		return travelDuration;
	}

	public void setTravelDuration(String travelDuration) {
		this.travelDuration = travelDuration;
	}

	public String getUpperBoundExpense() {
		return upperBoundExpense;
	}

	public void setUpperBoundExpense(String upperBoundExpense) {
		this.upperBoundExpense = upperBoundExpense;
	}

	public String getAdditionalDetails() {
		return additionalDetails;
	}

	public void setAdditionalDetails(String additionalDetails) {
		this.additionalDetails = additionalDetails;
	}
	
	public String getTicketStatus() {
		return ticketStatus;
	}

	public void setTicketStatus(String ticketStatus) {
		this.ticketStatus = ticketStatus;
	}
	
	public String getAdminComment() {
		return adminComment;
	}

	public void setAdminComment(String adminComment) {
		this.adminComment = adminComment;
	}

	public Ticket(int ticketid, String reqType, String ticketPriority, String travelCity, String fromCity,
			String fromDate, String toDate, String passportNumber, String projectName, String expenseBorne,
			String travelApproveBy, String travelDuration, String upperBoundExpense, String additionalDetails, User user) {
		super();
		this.ticketid = ticketid;
		this.reqType = reqType;
		this.ticketPriority = ticketPriority;
		this.travelCity = travelCity;
		this.fromCity = fromCity;
		this.fromDate = fromDate;
		this.toDate = toDate;
		this.passportNumber = passportNumber;
		this.projectName = projectName;
		this.expenseBorne = expenseBorne;
		this.travelApproveBy = travelApproveBy;
		this.travelDuration = travelDuration;
		this.upperBoundExpense = upperBoundExpense;
		this.additionalDetails = additionalDetails;
		this.user = user;
	}

	public Ticket() {
		super();
		// TODO Auto-generated constructor stub
	}

}
