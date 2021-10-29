package com.gmail.rybachko.anna.task1;

import java.io.FileNotFoundException;
import java.io.FileReader;

public class ReaderServiceImpl implements ReaderService {
    public FileReader getReader(String path) {
        try {
            return new FileReader(path);
        } catch (FileNotFoundException e) {
            System.out.println("Error: " + e.getMessage());
            return null;
        }
    }
}
