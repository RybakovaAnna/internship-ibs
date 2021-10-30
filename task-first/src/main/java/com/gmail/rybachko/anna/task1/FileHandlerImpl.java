package com.gmail.rybachko.anna.task1;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import static com.gmail.rybachko.anna.task1.ContentHandlerImpl.ERROR_MSG;

public class FileHandlerImpl implements FileHandler {
    private final ContentHandlerImpl contentHandler = new ContentHandlerImpl();

    public List<String> process(FileReader fileReader) {
        if (Objects.nonNull(fileReader)) {
            BufferedReader br = new BufferedReader(fileReader);
            try {
                return br.lines()
                        .map(contentHandler::process)
                        .collect(Collectors.toList());
            } catch (NumberFormatException e) {
                return Collections.singletonList(ERROR_MSG);
            }
        }
        return Collections.emptyList();
    }
}
