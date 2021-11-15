package com.gmail.rybachko.anna.tasksixth.service;

import com.gmail.rybachko.anna.tasksixth.model.entities.Employee;
import com.gmail.rybachko.anna.tasksixth.repositories.EmployeeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {
    private final EmployeeRepository repository;

    @Override
    public Employee getEmployeeById(Long id) {
        Optional<Employee> employee = repository.findById(id);
        return employee.orElseThrow(() -> new IllegalArgumentException(
                "Employee " + id + " not found"));
    }

    @Override
    public void deleteById(Long id) {
        System.out.println("Emplyee " + id + "is fired");
    }
}
