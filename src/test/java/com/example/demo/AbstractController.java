package com.example.demo;

import org.apache.catalina.startup.ContextConfig;
import org.junit.jupiter.api.TestInstance;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureWebMvc;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;

@AutoConfigureWebMvc
@AutoConfigureMockMvc
@ContextConfiguration
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class AbstractController {

    @MockBean
    private ContextConfig contextConfig;

    public ContextConfig givenContext(){

    }
}
