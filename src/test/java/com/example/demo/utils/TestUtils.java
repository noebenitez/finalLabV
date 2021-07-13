package com.example.demo.utils;

import com.example.demo.models.Logger;
import com.example.demo.models.Tickets;

import java.time.LocalDateTime;
import java.util.UUID;

public class TestUtils {

    public static final UUID UUID_UNO = UUID.fromString("UUID-1");
    public static final Integer DISCOUNT_UNO = 100;
    public static final LocalDateTime DATE_UNO = LocalDateTime.of(2020, 10, 10, 12, 12);

    public static Tickets aTicket(){
        return new Tickets(UUID_UNO, DISCOUNT_UNO);
    }

    public static Logger aLogger(){
        return new Logger(UUID_UNO, DISCOUNT_UNO, DATE_UNO);
    }
}
