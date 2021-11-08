package com.gmail.rybachko.anna.taskfourth.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.assertEquals;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class PetrolEngineServiceTest {
    @Autowired
    private EngineService petrolEngineService;

    @Test
    public void powerUpPositive() {
        assertEquals("Двигатель работает на бензиновом топливе\n", petrolEngineService.powerUp());
    }
}