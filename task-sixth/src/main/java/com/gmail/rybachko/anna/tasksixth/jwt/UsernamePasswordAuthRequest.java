package com.gmail.rybachko.anna.tasksixth.jwt;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class UsernamePasswordAuthRequest {

    private String username;
    private String password;
}
