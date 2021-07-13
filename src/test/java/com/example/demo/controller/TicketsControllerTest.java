package com.example.demo.controller;

import com.example.demo.service.TicketsService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoSettings;
import org.springframework.boot.test.context.TestComponent;

@MockitoSettings
public class TicketsControllerTest {

    @InjectMocks
    private TicketsController ticketsController;
    @Mock
    private TicketsService ticketsService;


}
