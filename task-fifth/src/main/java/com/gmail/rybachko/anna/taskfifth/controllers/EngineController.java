package com.gmail.rybachko.anna.taskfifth.controllers;

import com.gmail.rybachko.anna.taskfifth.exception.EntityNotFoundException;
import com.gmail.rybachko.anna.taskfifth.jpa.entity.Engine;
import com.gmail.rybachko.anna.taskfifth.jpa.repositories.EngineRepository;
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
@RequestMapping("/api/engine")
public class EngineController {
    private final EngineRepository repository;

    @PostMapping("create")
    public void createEngine(@RequestBody Engine engine) {
        repository.save(engine);
    }

    @GetMapping(value = {"read", "read/{id}"})
    public List<Engine> getCar(@PathVariable(required = false) Long id) {
        if (Objects.nonNull(id)) {
            return repository.findById(id).stream().collect(Collectors.toList());
        } else {
            return (List<Engine>) repository.findAll();
        }
    }

    @PostMapping("update/{id}")
    public Engine update(@PathVariable Long id, @RequestBody Engine engine) {
        repository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException(id));
        return repository.save(engine);
    }

    @PostMapping("delete/{id}")
    public void delete(@PathVariable Long id) {
        repository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException(id));
        repository.deleteById(id);
    }
}