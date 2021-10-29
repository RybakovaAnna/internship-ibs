package com.gmail.rybachko.anna.task1;

public class ContentHandlerImpl implements ContentHandler {
    public static final String ERROR_MSG = "Файл не соответствует условиям задания. Программа завершается";

    public String process(String content) {
        int number;
        try {
            number = Integer.parseInt(content);
        } catch (NumberFormatException e) {
            throw new NumberFormatException(ERROR_MSG);
        }

        if (number % 5 == 0 && number % 3 == 0) {
            return "FizzBuzz";
        } else if (number % 3 == 0) {
            return "Fizz";
        } else if (number % 5 == 0) {
            return "Buzz";
        } else {
            return Integer.toString(number);
        }
    }
}
