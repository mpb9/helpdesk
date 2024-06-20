package com.bb.helpdesk_service.controller;

import com.bb.helpdesk_service.model.Ticket;
import com.bb.helpdesk_service.service.TicketService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3000", maxAge = 3600)
@RequestMapping("/api/tickets")
@Validated
public class TicketController {
    private static final Logger logger = LoggerFactory.getLogger(TicketController.class);

    @Autowired
    private TicketService ticketService;

    // GET REQUESTS
    @GetMapping(name = "Get All Tickets", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Ticket>> getAllTickets() {
        logger.info("Entering getAllTickets...");

        List<Ticket> ticketList = ticketService.getAllTickets();

        logger.info("\nTicketList: {}", ticketList);
        return new ResponseEntity<>(ticketList, HttpStatus.OK);
    }

    // PUT REQUESTS
    @PutMapping(name = "Update Ticket", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Ticket> updateTicket(@RequestBody Ticket ticket) {
        logger.info("Entering updateTicket...");

        Ticket updatedTicket = ticketService.updateTicket(ticket);

        logger.info("\nupdatedTicket: {}", updatedTicket);
        return new ResponseEntity<>(updatedTicket, HttpStatus.OK);
    }

    // POST REQUESTS
    @PostMapping(name = "Create Ticket", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Ticket> createTicket(@RequestBody Ticket ticket) {
        logger.info("Entering createTicket...");

        Ticket newTicket = ticketService.createTicket(ticket);

        logger.info("\nnewTicket: {}", newTicket);
        return new ResponseEntity<>(newTicket, HttpStatus.CREATED);
    }
}
