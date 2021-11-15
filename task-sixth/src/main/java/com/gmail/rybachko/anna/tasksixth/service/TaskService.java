package com.gmail.rybachko.anna.tasksixth.service;

import com.gmail.rybachko.anna.tasksixth.model.entities.Task;

public interface TaskService {
    Task getTaskById(Long id);

    void createTask(String taskId, Task task);

    void updateTask(Long taskId);
}
