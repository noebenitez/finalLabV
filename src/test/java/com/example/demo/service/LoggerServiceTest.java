package com.example.demo.service;

import com.example.demo.models.Logger;
import com.example.demo.models.Tickets;
import com.example.demo.repository.LoggerRepository;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;

import java.time.LocalDateTime;
import java.util.UUID;

import static com.example.demo.utils.TestUtils.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class LoggerServiceTest {

    @InjectMocks
    private LoggerService loggerService;
    @Mock
    private LoggerRepository loggerRepository;
    @Mock
    private TicketsService ticketsService;

    @Test
    public void addLogTest() throws Exception{
        UUID param = UUID_UNO;
        Mockito.when(ticketsService.getById(param)).thenReturn(aTicket());
        Mockito.when(loggerRepository.save(Mockito.any(Logger.class))).thenReturn(aLogger());
        Mockito.when(LocalDateTime.now()).thenReturn(DATE_UNO);

        Logger response = loggerService.addLog(param);

        assertEquals(response.getTickerNumber(), UUID_UNO);
        assertEquals(response.getDiscount(), DISCOUNT_UNO);
        assertEquals(response.getDate(), DATE_UNO);

    }
}
