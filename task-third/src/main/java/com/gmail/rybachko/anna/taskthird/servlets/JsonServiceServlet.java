package com.gmail.rybachko.anna.taskthird.servlets;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.exc.UnrecognizedPropertyException;
import com.gmail.rybachko.anna.taskthird.dto.FileTemplate;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Objects;

@WebServlet(name = "JsonServiceServlet", value = "/jsonService")
public class JsonServiceServlet extends HttpServlet {
    /**
     * http://localhost:8081/get?fileName=<fileName>
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        try {
            String fileName = request.getParameter("fileName");
            if (Objects.isNull(fileName)) {
                response.sendError(400, "fileName is empty");
                return;
            } else {
                fileName += ".json";
            }
            String json = new String(Files.readAllBytes(Paths.get("classes", fileName)));
            try (PrintWriter writer = response.getWriter()) {
                writer.println(json);
            }
        } catch (Exception e) {
            response.sendError(500, "Unexpected error: " + e.getMessage());
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        try {
            ObjectMapper mapper = new ObjectMapper();
            FileTemplate fileTemplate = mapper.readValue(request.getReader(), FileTemplate.class);
            if (Objects.isNull(fileTemplate.getFileName())) {
                response.sendError(400, "fileName is empty");
                return;
            }
            mapper.writeValue(new File(Paths.get("classes", fileTemplate.getFileName() + ".json").toUri()), fileTemplate.getContent());
        } catch (UnrecognizedPropertyException e) {
            response.sendError(400, "Invalid json format. The correct format looks like this: \n {\nfileName:\ncontent:{}\n}");
        } catch (Exception e) {
            response.sendError(500, "Unexpected error: " + e.getMessage());
        }
    }

    @Override
    protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws IOException {
        try {
            String fileName = request.getParameter("fileName");
            if (Objects.isNull(fileName)) {
                response.sendError(400, "fileName is empty");
                return;
            } else {
                fileName += ".json";
            }
            Files.delete(Paths.get("classes", fileName));
        } catch (Exception e) {
            response.sendError(500, "Unexpected error: " + e.getMessage());
        }
    }

    @Override
    protected void doPut(HttpServletRequest request, HttpServletResponse response) throws IOException {
        try {
            ObjectMapper mapper = new ObjectMapper();
            FileTemplate fileTemplate = mapper.readValue(request.getReader(), FileTemplate.class);
            if (Objects.isNull(fileTemplate.getFileName())) {
                response.sendError(400, "fileName is empty");
                return;
            }
            mapper.writeValue(new File(Paths.get("classes", fileTemplate.getFileName() + ".json").toUri()), fileTemplate.getContent());
        } catch (UnrecognizedPropertyException e) {
            response.sendError(400, "Invalid json format. The correct format looks like this: \n {\nfileName:\ncontent:{}\n}");
        } catch (Exception e) {
            response.sendError(500, "Unexpected error: " + e.getMessage());
        }
    }
}
