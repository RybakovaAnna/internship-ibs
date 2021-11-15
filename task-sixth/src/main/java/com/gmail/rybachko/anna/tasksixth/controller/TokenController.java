package com.gmail.rybachko.anna.tasksixth.controller;


import com.gmail.rybachko.anna.tasksixth.jwt.JwtProvider;
import com.gmail.rybachko.anna.tasksixth.model.entities.Token;
import com.gmail.rybachko.anna.tasksixth.service.TokenService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@PreAuthorize("hasAuthority('token:get')")
public class TokenController {
    private final JwtProvider jwtProvider;
    private final TokenService tokenService;

    @GetMapping("/update/token")
    public Token getToken(Authentication authResult) {
        Token token = new Token(null, authResult.getName(), jwtProvider.createAccessToken(authResult), jwtProvider.createRefreshToken(authResult));
        return tokenService.update(token);
    }
}
