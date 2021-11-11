package com.gmail.rybachko.anna.taskfifth.exception;

public class EntityNotFoundException extends RuntimeException {

    public EntityNotFoundException(Long id) {
        super("Объект с id = " + id + " не найден.");
    }
}
