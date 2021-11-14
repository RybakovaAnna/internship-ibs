package com.gmail.rybachko.anna.tasksixth.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.gmail.rybachko.anna.tasksixth.model.Employee;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/api/employee")
@PreAuthorize("hasAnyRole('EMPLOYEE','TRAINEE')")
public class EmployeeController {

    private static final List<Employee> EMPLOYEES = Arrays.asList(
            new Employee(1, "Mr. Smith"),
            new Employee(2, "Mr. Proper"),
            new Employee(3, "Mr. Bean")
    );

    @GetMapping("{id}")
    public Employee getEmployee(@PathVariable("id") Integer employeeId) {
        return EMPLOYEES.stream()
                .filter(employee -> employeeId.equals(employee.getId()))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException(
                        "Employee " + employeeId + "not found"
                ));
    }
}
