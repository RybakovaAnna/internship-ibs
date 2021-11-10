package com.gmail.rybachko.anna.taskfifth.controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.gmail.rybachko.anna.taskfifth.jpa.entity.Car;
import com.gmail.rybachko.anna.taskfifth.jpa.repositories.CarRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/car")
public class CarController {
    private final CarRepository repository;
    private final ObjectMapper objectMapper;

    @PostMapping("create")
    public void createCar(@RequestBody Car car) {
        repository.save(car);
    }


    @GetMapping(value = {"read", "read/{id}"})
    public List<Car> getCar(@PathVariable(required = false) Long id) {
        if (Objects.nonNull(id)) {
            return repository.findById(id).stream().collect(Collectors.toList());
        } else {
            return (List<Car>) repository.findAll();
        }
        //  .orElseThrow(() -> new EmployeeNotFoundException(id));
    }

    @PostMapping("update/{id}")
    public void update(@PathVariable Long id, @RequestBody Car car) {
        repository.findById(id).orElseThrow(() -> new RuntimeException("Объект с id = " + id + " не найден."));
        repository.save(car);
    }

}
