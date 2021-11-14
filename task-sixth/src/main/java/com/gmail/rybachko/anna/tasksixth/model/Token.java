package com.gmail.rybachko.anna.tasksixth.model;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

@ToString
@Getter
@RequiredArgsConstructor
public class Token {
    private final String access;
    private final String refresh;
}
