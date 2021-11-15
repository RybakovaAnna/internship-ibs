package com.gmail.rybachko.anna.tasksixth.config;

import com.gmail.rybachko.anna.tasksixth.model.entities.ApplicationUser;
import com.gmail.rybachko.anna.tasksixth.model.entities.Employee;
import com.gmail.rybachko.anna.tasksixth.model.entities.Task;
import com.gmail.rybachko.anna.tasksixth.model.entities.UserRole;
import com.gmail.rybachko.anna.tasksixth.repositories.ApplicationUserRepository;
import com.gmail.rybachko.anna.tasksixth.repositories.EmployeeRepository;
import com.gmail.rybachko.anna.tasksixth.repositories.TaskRepository;
import com.gmail.rybachko.anna.tasksixth.repositories.UserRoleRepository;
import com.gmail.rybachko.anna.tasksixth.service.UserRoleService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.DependsOn;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.HashSet;
import java.util.List;

import static java.util.Arrays.asList;

@Configuration
public class AppConfig {
    @Bean
    public List<Employee> initEmployees(EmployeeRepository repository) {
        return (List<Employee>) repository.saveAll(asList(
                new Employee(1L, "Mr. Smith"),
                new Employee(2L, "Mr. Proper"),
                new Employee(3L, "Mr. Bean")
        ));
    }

    @Bean
    public List<Task> initTasks(TaskRepository repository) {
        return (List<Task>) repository.saveAll(asList(
                new Task(1L, "Create app", "Need new application"),
                new Task(2L, "Update properties", "Update properties of db in dev stand")
        ));
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }


    @Bean
    public List<UserRole> userRoles(UserRoleRepository userRoleRepository) {
        return (List<UserRole>) userRoleRepository.saveAll(asList(
                new UserRole(null, "employee:read", null),
                new UserRole(null, "employee:write", null),
                new UserRole(null, "task:read", null),
                new UserRole(null, "task:write", null),
                new UserRole(null, "token:get", null)
        ));
    }

    @Bean
    @DependsOn("userRoles")
    public List<ApplicationUser> applicationUsers(PasswordEncoder passwordEncoder, ApplicationUserRepository applicationUserRepository, UserRoleService userRoleService) {
        return (List<ApplicationUser>) applicationUserRepository.saveAll(asList(
                new ApplicationUser(
                        null,
                        "EMPLOYEE",
                        "oliver",
                        passwordEncoder.encode("password123"),
                        new HashSet<>(userRoleService.getUserRolesForEmployee()),
                        true,
                        true,
                        true,
                        true
                ),
                new ApplicationUser(
                        null,
                        "MANAGER",
                        "henry",
                        passwordEncoder.encode("password123"),
                        new HashSet<>(userRoleService.getUserRolesForManager()),
                        true,
                        true,
                        true,
                        true
                ),
                new ApplicationUser(
                        null,
                        "TRAINEE",
                        "emma",
                        passwordEncoder.encode("password123"),
                        new HashSet<>(userRoleService.getUserRolesForTrainee()),
                        true,
                        true,
                        true,
                        true
                ),
                new ApplicationUser(
                        null,
                        "SCRUM_MASTER",
                        "anna",
                        passwordEncoder.encode("password123"),
                        new HashSet<>(userRoleService.getUserRolesForScrumMaster()),
                        true,
                        true,
                        true,
                        true
                )
        ));
    }
}
