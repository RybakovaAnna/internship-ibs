package com.gmail.rybachko.anna.taskfifth.controllers;

import com.gmail.rybachko.anna.taskfifth.exception.EntityNotFoundException;
import com.gmail.rybachko.anna.taskfifth.jpa.entity.Gear;
import com.gmail.rybachko.anna.taskfifth.jpa.repositories.GearRepository;
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
@RequestMapping("/api/gear")
public class GearController {
    private final GearRepository repository;

    @PostMapping("create")
    public void create(@RequestBody Gear gear) {
        repository.save(gear);
    }

    @GetMapping(value = {"read", "read/{id}"})
    public List<Gear> get(@PathVariable(required = false) Long id) {
        if (Objects.nonNull(id)) {
            return repository.findById(id).stream().collect(Collectors.toList());
        } else {
            return (List<Gear>) repository.findAll();
        }
    }

    @PostMapping("update/{id}")
    public Gear update(@PathVariable Long id, @RequestBody Gear gear) {
        repository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException(id));
        return repository.save(gear);
    }

    @PostMapping("delete/{id}")
    public void delete(@PathVariable Long id) {
        repository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException(id));
        repository.deleteById(id);
    }
}