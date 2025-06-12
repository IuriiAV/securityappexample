package de.telran.ticketapp.service;

import de.telran.ticketapp.entity.Ticket;
import de.telran.ticketapp.exception.TicketNotFoundException;
import de.telran.ticketapp.repository.TicketRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TicketServiceImpl implements TicketService {

    @Autowired
    private TicketRepository ticketRepository;

    @Override
    public List<Ticket> getAll() {
        return ticketRepository.findAll();
    }

    @Override
    public Ticket create(Ticket ticket) {
        return ticketRepository.save(ticket);
    }

    @Override
    public Ticket getById(Long id) {
        return ticketRepository.findById(id)
                .orElseThrow(() -> new TicketNotFoundException("Ticket with id " + id + " not found"));
    }
}
