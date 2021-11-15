package com.gmail.rybachko.anna.tasksixth.service;

import com.gmail.rybachko.anna.tasksixth.model.entities.Employee;

public interface EmployeeService {
    Employee getEmployeeById(Long id);

    void deleteById(Long id);
}
