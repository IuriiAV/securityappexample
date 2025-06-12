package de.telran.ticketapp.service;

import de.telran.ticketapp.entity.Ticket;

import java.util.List;

public interface TicketService {

    List<Ticket> getAll();

    Ticket create(Ticket ticket);

    Ticket getById(Long id);
}
