package com.gmail.rybachko.anna.tasksixth.controller;

import com.gmail.rybachko.anna.tasksixth.model.entities.Employee;
import com.gmail.rybachko.anna.tasksixth.service.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/employee")
@PreAuthorize("hasAnyRole('EMPLOYEE','TRAINEE')")
public class EmployeeController {
    private final EmployeeService employeeService;

    @GetMapping("{id}")
    public Employee getEmployee(@PathVariable("id") Long employeeId) {
        return employeeService.getEmployeeById(employeeId);
    }
}
