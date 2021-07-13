package com.example.demo.service;

import com.example.demo.exception.IdNotFoundException;
import com.example.demo.models.Logger;
import com.example.demo.models.Tickets;
import com.example.demo.repository.LoggerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.UUID;

@Service
public class LoggerService {

    @Autowired
    private LoggerRepository loggerRepository;
    @Autowired
    private TicketsService ticketsService;

    public Logger addLog(UUID idTicket) throws IdNotFoundException {
        Tickets ticket = ticketsService.getById(idTicket);
        return loggerRepository.save(
                new Logger(ticket.getTicketNumber(), ticket.getDiscount(), LocalDateTime.now()));

    }
}
