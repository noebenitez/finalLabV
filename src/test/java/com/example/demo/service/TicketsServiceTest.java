package com.example.demo.service;

import com.example.demo.exception.IdNotFoundException;
import com.example.demo.models.Tickets;
import com.example.demo.repository.TicketsRepository;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;

import java.util.Optional;
import java.util.UUID;

import static com.example.demo.utils.TestUtils.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class TicketsServiceTest {

    @InjectMocks
    private TicketsService ticketsService;
    @Mock
    private TicketsRepository ticketsRepository;


    @Test
    public void generateRandomHappyPath(){

        Mockito.when(UUID.randomUUID()).thenReturn(UUID_UNO);
        Mockito.when(Math.random()).thenReturn(DISCOUNT_UNO.doubleValue());
        Mockito.when(ticketsRepository.save(Mockito.any(Tickets.class))).thenReturn(aTicket());

        Tickets response = ticketsService.generateRandom();
        assertEquals(response.getTicketNumber(), UUID_UNO);
        assertEquals(response.getDiscount(), DISCOUNT_UNO);
    }

    @Test
    public void getByIdHappyPath() throws Exception{

        Mockito.when(ticketsRepository.findById(UUID_UNO)).thenReturn(Optional.of(aTicket()));

        Tickets ticket = ticketsService.getById(UUID_UNO);

        assertEquals(ticket.getTicketNumber(), UUID_UNO);
    }

    @Test
    public void getByIdThrowIdsException(){

        Mockito.when(ticketsRepository.findById(UUID_UNO)).thenReturn(Optional.empty());

        try {
            ticketsService.getById(UUID_UNO);
        } catch (IdNotFoundException e) {
            assertThrows(IdNotFoundException.class);
        };

    }
}
