package com.gmail.rybachko.anna.taskthird;

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.webapp.WebAppContext;

import java.io.File;

public class Main {
    public static void main(String[] args) throws Exception {
        System.out.println("Start main class");
        Server server = new Server(8081);
        final String webAppPath = new File(Main.class.getProtectionDomain().getCodeSource().getLocation()
                .toURI()).getPath();
        WebAppContext webapp = new WebAppContext(webAppPath, "/");
        server.setHandler(webapp);
        server.start();
        System.out.println("OK: server started");
    }
}
