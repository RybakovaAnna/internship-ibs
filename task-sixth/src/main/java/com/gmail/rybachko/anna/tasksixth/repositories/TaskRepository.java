package com.gmail.rybachko.anna.tasksixth.repositories;

import com.gmail.rybachko.anna.tasksixth.model.entities.Task;
import org.springframework.data.repository.CrudRepository;

public interface TaskRepository extends CrudRepository<Task, Long> {
}
