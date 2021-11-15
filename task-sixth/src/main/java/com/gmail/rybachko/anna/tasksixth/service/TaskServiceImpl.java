package com.gmail.rybachko.anna.tasksixth.service;

import com.gmail.rybachko.anna.tasksixth.model.entities.Task;
import com.gmail.rybachko.anna.tasksixth.repositories.TaskRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class TaskServiceImpl implements TaskService {
    private final TaskRepository repository;

    @Override
    public Task getTaskById(Long id) {
        Optional<Task> employee = repository.findById(id);
        return employee.orElseThrow(() -> new IllegalArgumentException(
                "Task " + id + " not found"
        ));
    }

    @Override
    public void createTask(String taskId, Task task) {
        System.out.println("Created new task " + task);
    }

    @Override
    public void updateTask(Long taskId) {
        System.out.println("Task updated " + taskId);
    }
}
