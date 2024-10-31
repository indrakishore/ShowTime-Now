package com.indra.book_my_show.Controllers;

import com.indra.book_my_show.Models.TicketEntity;
import com.indra.book_my_show.Request.BookTicketRequest;
import com.indra.book_my_show.Services.TicketService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/tickets")
public class TicketController {

    private final TicketService ticketService;

    public TicketController(TicketService ticketService) {
        this.ticketService = ticketService;
    }

    @PostMapping("/bookTicket")
    public ResponseEntity generateTicket(@RequestBody BookTicketRequest bookTicketRequest) {
        try {
            TicketEntity ticket = ticketService.bookTicket(bookTicketRequest);
            return new ResponseEntity(ticket, HttpStatus.CREATED);
        } catch (Exception e) {
            String errorMessage =  "Error while booking your tickets: " + e.getMessage();
            return new ResponseEntity(errorMessage, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
