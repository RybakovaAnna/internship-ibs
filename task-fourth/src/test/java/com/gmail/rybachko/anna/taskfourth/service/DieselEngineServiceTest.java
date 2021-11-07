package com.gmail.rybachko.anna.taskfourth.service;


import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import static org.junit.Assert.*;


@SpringBootTest
public class DieselEngineServiceTest {
    @Autowired
    private EngineService dieselEngineService;

    @Test
    public void powerUpPositive() {
        assertEquals("Diesel", dieselEngineService.powerUp());
    }
}