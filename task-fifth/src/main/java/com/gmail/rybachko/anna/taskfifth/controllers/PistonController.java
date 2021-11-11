package com.gmail.rybachko.anna.taskfifth.controllers;

import com.gmail.rybachko.anna.taskfifth.exception.EntityNotFoundException;
import com.gmail.rybachko.anna.taskfifth.jpa.entity.Piston;
import com.gmail.rybachko.anna.taskfifth.jpa.repositories.PistonRepository;
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
@RequestMapping("/api/piston")
public class PistonController {
    private final PistonRepository repository;

    @PostMapping("create")
    public void create(@RequestBody Piston piston) {
        repository.save(piston);
    }

    @GetMapping(value = {"read", "read/{id}"})
    public List<Piston> get(@PathVariable(required = false) Long id) {
        if (Objects.nonNull(id)) {
            return repository.findById(id).stream().collect(Collectors.toList());
        } else {
            return (List<Piston>) repository.findAll();
        }
    }

    @PostMapping("update/{id}")
    public Piston update(@PathVariable Long id, @RequestBody Piston piston) {
        repository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException(id));
        return repository.save(piston);
    }

    @PostMapping("delete/{id}")
    public void delete(@PathVariable Long id) {
        repository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException(id));
        repository.deleteById(id);
    }
}