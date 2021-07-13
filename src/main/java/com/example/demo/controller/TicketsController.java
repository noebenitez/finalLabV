package com.example.demo.controller;

import com.example.demo.exception.IdNotFoundException;
import com.example.demo.models.Tickets;
import com.example.demo.service.TicketsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.UUID;

@RestController
@RequestMapping("/tickets")
public class TicketsController {

    private static final String TICKETS_PATH = "tickets";
    @Autowired
    private TicketsService ticketsService;

    @PostMapping("/random")
    public ResponseEntity generateRandom(){
        Tickets newTicket = ticketsService.generateRandom();
        return ResponseEntity.created(URI.create(
                ServletUriComponentsBuilder
                        .fromCurrentRequest()
                        .path("/" + TICKETS_PATH + "/" + newTicket.getTicketNumber())
                        .buildAndExpand().toString()))
                .build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Tickets> getById(@PathVariable UUID id) throws IdNotFoundException {
        return ResponseEntity.ok(ticketsService.getById(id));
    }
}
