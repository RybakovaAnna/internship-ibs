package com.gmail.rybachko.anna.taskthird.servlets;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;

@WebServlet(name = "GreetingsServlet", value = "/get")
public class GetJsonServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        try {
            String file = "File.json";
            String json = new String(Files.readAllBytes(Paths.get("classes", file)));
            try (PrintWriter writer = response.getWriter()) {
                writer.println(json);
            }
        } catch (Exception e) {
            response.sendError(500, "Unexpected error: " + e.getMessage());
        }
    }
}
