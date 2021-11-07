package com.gmail.rybachko.anna.taskfourth.service;

import org.springframework.stereotype.Service;

@Service
public class PetrolEngineService implements EngineService {
    @Override
    public String powerUp() {
        return "Petrol";
    }

    @Override
    public String currentType() {
        return "petrol";
    }
}
