package com.gmail.rybachko.anna.tasksecond;

import org.apache.commons.lang3.StringUtils;

import java.util.Arrays;

public class App {
    public static void main(String[] args) {
        Arrays.stream(args).map(StringUtils::upperCase)
                .forEach(System.out::println);
    }
}

