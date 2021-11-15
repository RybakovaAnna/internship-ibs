package com.gmail.rybachko.anna.tasksixth.repositories;

import com.gmail.rybachko.anna.tasksixth.model.entities.Token;
import org.springframework.data.repository.CrudRepository;

public interface TokenRepository extends CrudRepository<Token, Long> {
    Token getTokenByUsername(String username);
}
