package com.gmail.rybachko.anna.tasksixth.repositories;

import com.gmail.rybachko.anna.tasksixth.model.entities.Employee;
import org.springframework.data.repository.CrudRepository;

public interface EmployeeRepository extends CrudRepository<Employee, Long> {
}
