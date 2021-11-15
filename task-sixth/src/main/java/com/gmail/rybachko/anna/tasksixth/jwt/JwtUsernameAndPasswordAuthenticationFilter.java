package com.gmail.rybachko.anna.tasksixth.jwt;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.gmail.rybachko.anna.tasksixth.model.entities.Token;
import com.gmail.rybachko.anna.tasksixth.service.TokenService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Slf4j
@RequiredArgsConstructor
public class JwtUsernameAndPasswordAuthenticationFilter extends UsernamePasswordAuthenticationFilter {

    private final AuthenticationManager authenticationManager;
    private final JwtProvider jwtProvider;
    private final TokenService service;

    @Override
    public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response) throws AuthenticationException {
        try {
            UsernamePasswordAuthRequest usernamePasswordAuthRequest = new ObjectMapper().readValue(request.getInputStream(), UsernamePasswordAuthRequest.class);
            Authentication authentication = new UsernamePasswordAuthenticationToken(usernamePasswordAuthRequest.getUsername(), usernamePasswordAuthRequest.getPassword());

            return authenticationManager.authenticate(authentication);
        } catch (IOException e) {
            log.error("Unexpected error", e);
            throw new RuntimeException(e);
        }
    }

    @Override
    protected void successfulAuthentication(HttpServletRequest request, HttpServletResponse response, FilterChain chain, Authentication authResult) throws IOException, ServletException {
        String access_token = jwtProvider.createAccessToken(authResult);
        String refresh_token = jwtProvider.createRefreshToken(authResult);
//         response.addHeader(HttpHeaders.AUTHORIZATION, access_token);
        response.setContentType("application/json");
        Token save = service.saveOrUpdateByUsername(new Token(null, authResult.getName(), access_token, refresh_token));
        new ObjectMapper().writeValue(response.getWriter(), save);
    }
}
