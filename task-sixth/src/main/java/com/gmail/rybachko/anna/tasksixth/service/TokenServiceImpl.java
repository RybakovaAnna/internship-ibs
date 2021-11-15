package com.gmail.rybachko.anna.tasksixth.service;

import com.gmail.rybachko.anna.tasksixth.model.entities.Token;
import com.gmail.rybachko.anna.tasksixth.repositories.TokenRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import static java.util.Objects.nonNull;

@Service
@RequiredArgsConstructor
public class TokenServiceImpl implements TokenService {
    private final TokenRepository repository;


    @Override
    public Token update(Token token) {
        Token tokenByUsername = repository.getTokenByUsername(token.getUsername());
        if (nonNull(tokenByUsername)) {
            return repository.save(tokenByUsername.toBuilder().accessToken(token.getAccessToken()).refreshToken(token.getRefreshToken()).build());
        } else {
            throw new RuntimeException("Error");
        }
    }

    @Override
    public Token saveOrUpdateByUsername(Token token) {
        Token tokenByUsername = repository.getTokenByUsername(token.getUsername());
        if (nonNull(tokenByUsername)) {
            return repository.save(tokenByUsername.toBuilder().accessToken(token.getAccessToken()).refreshToken(token.getRefreshToken()).build());
        } else {
            return repository.save(token);
        }
    }
}
