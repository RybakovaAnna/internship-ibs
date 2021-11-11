package com.gmail.rybachko.anna.taskfifth.controllers;

import com.gmail.rybachko.anna.taskfifth.exception.EntityNotFoundException;
import com.gmail.rybachko.anna.taskfifth.jpa.entity.Piston;
import com.gmail.rybachko.anna.taskfifth.jpa.entity.SteeringWheel;
import com.gmail.rybachko.anna.taskfifth.jpa.repositories.PistonRepository;
import com.gmail.rybachko.anna.taskfifth.jpa.repositories.SteeringWheelRepository;
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
@RequestMapping("/api/steeringwheel")
public class SteeringWheelController {
    private final SteeringWheelRepository repository;

    @PostMapping("create")
    public void create(@RequestBody SteeringWheel steeringWheel) {
        repository.save(steeringWheel);
    }

    @GetMapping(value = {"read", "read/{id}"})
    public List<SteeringWheel> get(@PathVariable(required = false) Long id) {
        if (Objects.nonNull(id)) {
            return repository.findById(id).stream().collect(Collectors.toList());
        } else {
            return (List<SteeringWheel>) repository.findAll();
        }
    }

    @PostMapping("update/{id}")
    public SteeringWheel update(@PathVariable Long id, @RequestBody SteeringWheel steeringWheel) {
        repository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException(id));
        return repository.save(steeringWheel);
    }

    @PostMapping("delete/{id}")
    public void delete(@PathVariable Long id) {
        repository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException(id));
        repository.deleteById(id);
    }
}