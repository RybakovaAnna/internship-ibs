package com.gmail.rybachko.anna.tasksixth.service;

import com.gmail.rybachko.anna.tasksixth.model.entities.Token;

public interface TokenService {

    Token update(Token token);

    Token saveOrUpdateByUsername(Token token);
}
