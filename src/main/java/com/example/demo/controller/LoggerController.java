package com.example.demo.controller;

import com.example.demo.exception.IdNotFoundException;
import com.example.demo.models.Logger;
import com.example.demo.models.Tickets;
import com.example.demo.service.LoggerService;
import com.example.demo.service.TicketsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.time.LocalDateTime;
import java.util.UUID;

@RestController
@RequestMapping("/loggers")
public class LoggerController {

    private static final String LOGGER_PATH = "loggers";
    @Autowired
    private LoggerService loggerService;
    @Autowired
    private TicketsService ticketsService;


    @PostMapping
    public ResponseEntity addLog(UUID idTicket) throws IdNotFoundException {
        Logger newLog = loggerService.addLog(idTicket);
        return ResponseEntity.created(URI.create(
                                    ServletUriComponentsBuilder
                                    .fromCurrentRequest()
                                    .path(LOGGER_PATH + "/" + newLog.getTickerNumber())
                                    .buildAndExpand().toString()))
                                .build();

    }

}
