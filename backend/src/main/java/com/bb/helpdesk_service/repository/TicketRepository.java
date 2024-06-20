package com.bb.helpdesk_service.repository;

import com.bb.helpdesk_service.model.Ticket;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TicketRepository extends CrudRepository<Ticket, String> {

    List<Ticket> findAllByOrderById();
}