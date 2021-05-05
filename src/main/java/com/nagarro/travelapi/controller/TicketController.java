package com.nagarro.travelapi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.nagarro.travelapi.entity.Ticket;
import com.nagarro.travelapi.entity.User;
import com.nagarro.travelapi.repository.TicketRepository;
import com.nagarro.travelapi.repository.UserRepository;
import com.nagarro.travelapi.service.TicketService;

@CrossOrigin
@RestController
public class TicketController {

	@Autowired
	private TicketService service;

	@Autowired
	private TicketRepository ticketRepository;

	@Autowired
	private UserRepository userRepository;

	@PostMapping("/addticket/{email}")
	public Ticket addTicket(@PathVariable(value = "email") String email, @RequestBody Ticket ticket) {
		User user = userRepository.getUserByEmail(email);
		ticket.setUser(user);
		ticket.setTicketStatus("SUBMITTED");
		return ticketRepository.save(ticket);
	}

	// **UPDATE TICKET**
	@PutMapping("/updateticket/{id}")
	public Ticket updateTicket(@PathVariable(value = "id") int id, @RequestBody Ticket newTicket) {
		Ticket ticket = ticketRepository.getTicketById(id);
		if (!ticket.getTicketStatus().equals("DONE")) {
			ticket.setReqType(newTicket.getReqType());
			ticket.setTicketPriority(newTicket.getTicketPriority());
			ticket.setTravelCity(newTicket.getTravelCity());
			ticket.setFromCity(newTicket.getFromCity());
			ticket.setFromDate(newTicket.getFromDate());
			ticket.setToDate(newTicket.getToDate());
			ticket.setPassportNumber(newTicket.getPassportNumber());
			ticket.setProjectName(newTicket.getProjectName());
			ticket.setExpenseBorne(newTicket.getExpenseBorne());
			ticket.setTravelApproveBy(newTicket.getTravelApproveBy());
			ticket.setTravelDuration(newTicket.getTravelDuration());
			ticket.setUpperBoundExpense(newTicket.getUpperBoundExpense());
			ticket.setAdditionalDetails(newTicket.getAdditionalDetails());
			if (ticket.getTicketStatus().equals("IN PROCESS") || ticket.getTicketStatus().equals("RESUBMITTED")) {
				ticket.setTicketStatus("RESUBMITTED");
			}
		}
		return ticketRepository.save(ticket);
	}

	@PutMapping("/admin/updatestatus/{id}")
	public Ticket updateTicketByAdmin(@PathVariable(value = "id") int id, @RequestBody Ticket newTicket) {
		Ticket ticket = ticketRepository.getTicketById(id);
		if (!ticket.getTicketStatus().equals("DONE")) {
			ticket.setTicketStatus(newTicket.getTicketStatus());
		}
		ticket.setAdminComment(newTicket.getAdminComment());
		return ticketRepository.save(ticket);
	}

	@GetMapping("/alltickets")
	public List<Ticket> getAllTickets() {
		return service.getTickets();
	}

	@GetMapping("/ticketbyemail/{email}")
	public List<Ticket> getTicketByEmail(@PathVariable(value = "email") String email) {

		return service.getTicketById(userRepository.getUserByEmail(email).getId());

	}

	@GetMapping("/ticketbyid/{id}")
	public Ticket getTicketById(@PathVariable(value = "id") int id) {
		return service.getTicketByTicketId(id);
	}
}
