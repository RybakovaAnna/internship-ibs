package com.gmail.rybachko.anna.taskfifth.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;

//@RestController
//public class CarController {
//
//    @GetMapping(api/car/read)
//    public String getCar(){
//        try {
//            String file = "File.json";
//            String json = new String(Files.readAllBytes(Paths.get("classes", file)));
//            try (PrintWriter writer = response.getWriter()) {
//                writer.println(json);
//            }
//        } catch (Exception e) {
//            response.sendError(500, "Unexpected error: " + e.getMessage());
//        }
//    }
//}
