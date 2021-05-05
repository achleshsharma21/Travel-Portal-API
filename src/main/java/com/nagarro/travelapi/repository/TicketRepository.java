package com.nagarro.travelapi.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.nagarro.travelapi.entity.Ticket;

public interface TicketRepository extends JpaRepository<Ticket, Integer> {

	@Query("FROM Ticket WHERE user_id=:id")
	public List<Ticket> getTicketByUserId(Integer id);

	@Query("FROM Ticket WHERE ticketid=:id")
	public Ticket getTicketById(Integer id);

}
