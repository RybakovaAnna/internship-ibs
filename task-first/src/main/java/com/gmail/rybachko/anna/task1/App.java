package com.gmail.rybachko.anna.task1;

import java.io.FileReader;
import java.util.List;
import java.util.Scanner;

public class App {
    private final ReaderService readerService = new ReaderServiceImpl();
    private final FileHandlerImpl fileHandler = new FileHandlerImpl();

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Введите путь к файлу: ");
        String pathFile = in.nextLine();
        App app = new App();
        FileReader reader = (FileReader) app.readerService.getReader(pathFile);
        List<String> processed = app.fileHandler.process(reader);
        processed.forEach(System.out::println);
    }

}
