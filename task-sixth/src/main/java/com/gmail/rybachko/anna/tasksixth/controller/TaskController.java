package com.gmail.rybachko.anna.tasksixth.controller;

import com.gmail.rybachko.anna.tasksixth.model.entities.Task;
import com.gmail.rybachko.anna.tasksixth.service.TaskService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/task")
@PreAuthorize("hasAnyRole('EMPLOYEE','TRAINEE')")
public class TaskController {
    private final TaskService taskService;

    @GetMapping("{id}")
    public Task getTask(@PathVariable("id") Long taskId) {
        return taskService.getTaskById(taskId);
    }

    @PreAuthorize("hasAuthority('task:write')")
    @PutMapping("{id}")
    public void updateTask(@PathVariable("id") Long taskId) {
        taskService.updateTask(taskId);
    }
}
