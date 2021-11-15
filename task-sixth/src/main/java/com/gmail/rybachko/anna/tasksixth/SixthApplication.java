package com.gmail.rybachko.anna.tasksixth;

import com.gmail.rybachko.anna.tasksixth.config.AppSecurityConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;

@Import(AppSecurityConfig.class)
@SpringBootApplication
public class SixthApplication {

    public static void main(String[] args) {
        SpringApplication.run(SixthApplication.class, args);
    }

}
