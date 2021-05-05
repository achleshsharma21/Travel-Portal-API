package com.nagarro.travelapi.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nagarro.travelapi.entity.Ticket;
import com.nagarro.travelapi.repository.TicketRepository;

@Service
public class TicketService {

	@Autowired
	private TicketRepository repository;

	public Ticket saveTicket(Ticket userTicket) {
		return repository.save(userTicket);
	}

	public List<Ticket> getTickets() {
		return repository.findAll();
	}

	public List<Ticket> getTicketById(int id) {
		return repository.getTicketByUserId(id);
	}

	public Ticket getTicketByTicketId(int id) {
		return repository.getTicketById(id);
	}
}
