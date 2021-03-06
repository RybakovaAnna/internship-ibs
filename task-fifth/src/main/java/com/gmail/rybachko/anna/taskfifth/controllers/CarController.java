package com.gmail.rybachko.anna.taskfifth.controllers;

import com.gmail.rybachko.anna.taskfifth.exception.EntityNotFoundException;
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
import java.util.stream.Collectors;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/car")
public class CarController {
    private final CarRepository repository;

    @PostMapping("create")
    public void create(@RequestBody Car car) {
        repository.save(car);
    }

    @GetMapping(value = {"read", "read/{id}"})
    public List<Car> get(@PathVariable(required = false) Long id) {
        if (Objects.nonNull(id)) {
            return repository.findById(id).stream().collect(Collectors.toList());
        } else {
            return (List<Car>) repository.findAll();
        }
    }

    @PostMapping("update/{id}")
    public Car update(@PathVariable Long id, @RequestBody Car car) {
        repository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException(id));
        return repository.save(car);
    }

    @PostMapping("delete/{id}")
    public void delete(@PathVariable Long id) {
        repository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException(id));
        repository.deleteById(id);
    }
}