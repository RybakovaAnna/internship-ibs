package com.gmail.rybachko.anna.taskfourth.service;

import org.springframework.stereotype.Service;

@Service
public class DieselEngineService implements EngineService {
    @Override
    public String powerUp() {
        return "Diesel";
    }

    @Override
    public String currentType() {
        return "diesel";
    }
}
