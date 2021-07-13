package com.example.demo.service;

import com.example.demo.exception.IdNotFoundException;
import com.example.demo.models.Tickets;
import com.example.demo.repository.TicketsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Random;
import java.util.UUID;

@Service
public class TicketsService {

    @Autowired
    private TicketsRepository ticketsRepository;

    public Tickets generateRandom() {
        Integer num = Math.toIntExact(Math.round(Math.random()));
        Tickets t = new Tickets(UUID.randomUUID(), num);
        return ticketsRepository.save(t);
    }

    public Tickets getById(UUID id) throws IdNotFoundException {
        return ticketsRepository.findById(id)
                .orElseThrow(() -> new IdNotFoundException());
    }
}
