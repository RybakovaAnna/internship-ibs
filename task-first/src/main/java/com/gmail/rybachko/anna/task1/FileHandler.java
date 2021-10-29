package com.gmail.rybachko.anna.task1;

import java.io.FileReader;
import java.util.List;

public interface FileHandler {
    public List<String> process(FileReader fileReader);
}
