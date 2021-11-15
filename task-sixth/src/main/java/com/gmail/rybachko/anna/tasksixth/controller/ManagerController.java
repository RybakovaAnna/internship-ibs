package com.gmail.rybachko.anna.tasksixth.controller;

import com.gmail.rybachko.anna.tasksixth.model.entities.Employee;
import com.gmail.rybachko.anna.tasksixth.model.entities.Task;
import com.gmail.rybachko.anna.tasksixth.service.EmployeeService;
import com.gmail.rybachko.anna.tasksixth.service.TaskService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/manager/api")
@PreAuthorize("hasAnyRole('MANAGER','SCRUM_MASTER')")
public class ManagerController {
    private final EmployeeService employeeService;
    private final TaskService taskService;

    @GetMapping("/employee/{id}")
    public Employee getEmployee(@PathVariable("id") Long employeeId) {
        return employeeService.getEmployeeById(employeeId);
    }

    @GetMapping("/task/{id}")
    public Task getTask(@PathVariable("id") Long taskId) {
        return taskService.getTaskById(taskId);
    }

    @PreAuthorize("hasAuthority('employee:write')")
    @DeleteMapping("/employee/{id}")
    public void fireEmployee(@PathVariable("id") Long employeeId) {
        employeeService.deleteById(employeeId);
    }

    @PostMapping("/task/{id}")
    public void createTask(@PathVariable("id") String taskId, @RequestBody Task task) {
        taskService.createTask(taskId, task);
    }
}
