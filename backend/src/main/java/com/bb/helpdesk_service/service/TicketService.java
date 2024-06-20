package com.bb.helpdesk_service.service;

import com.bb.helpdesk_service.model.Ticket;
import com.bb.helpdesk_service.repository.TicketRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import java.util.List;

@Service
@Validated
public class TicketService {
    private static final Logger logger = LoggerFactory.getLogger(TicketService.class);

    @Autowired
    private TicketRepository ticketRepository;

    // GET REQUESTS
    public List<Ticket> getAllTickets() {
        logger.info("Entering getAllTickets...");
        return ticketRepository.findAllByOrderById();
    }

    // PUT REQUESTS
    public Ticket updateTicket(Ticket ticket) {
        logger.info("Entering updateTicket...");

        return ticketRepository.save(ticket);
    }

    // POST REQUESTS
    public Ticket createTicket(Ticket ticket) {
        logger.info("Entering createTicket...");

        return ticketRepository.save(ticket);
    }
}
