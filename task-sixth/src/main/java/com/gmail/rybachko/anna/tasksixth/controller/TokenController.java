package com.gmail.rybachko.anna.tasksixth.controller;


import com.gmail.rybachko.anna.tasksixth.jwt.JwtProvider;
import com.gmail.rybachko.anna.tasksixth.model.Token;
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

    @GetMapping("/update/token")
    public Token getToken(Authentication authResult) {
        return new Token(jwtProvider.createAccessToken(authResult), jwtProvider.createRefreshToken(authResult));
    }

}
