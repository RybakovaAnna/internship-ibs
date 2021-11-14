package com.gmail.rybachko.anna.tasksixth.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.gmail.rybachko.anna.tasksixth.model.Task;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/api/task")
@PreAuthorize("hasAnyRole('EMPLOYEE','TRAINEE')")
public class TaskController {

    private static final List<Task> TASKS = Arrays.asList(
            new Task(1L, "Create app", "Need new application"),
            new Task(2L , "Update properties", "Update properties of db in dev stand")
    );

    @GetMapping("{id}")
    public Task getTask(@PathVariable("id") Long taskId) {
        return TASKS.stream()
                .filter(task -> taskId.equals(task.getId()))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException(
                        "Task " + taskId + "not found"
                ));
    }

    @PreAuthorize("hasAuthority('task:write')")
    @PutMapping("{id}")
    public void updateTask(@PathVariable("id") Long taskId) {
        System.out.println("Task updated");
    }

}
