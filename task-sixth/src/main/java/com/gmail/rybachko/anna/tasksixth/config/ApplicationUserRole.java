package com.gmail.rybachko.anna.tasksixth.config;

import com.google.common.collect.Sets;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.Set;
import java.util.stream.Collectors;

import static com.gmail.rybachko.anna.tasksixth.config.ApplicationUserPermission.EMPLOYEE_READ;
import static com.gmail.rybachko.anna.tasksixth.config.ApplicationUserPermission.EMPLOYEE_WRITE;
import static com.gmail.rybachko.anna.tasksixth.config.ApplicationUserPermission.TASK_READ;
import static com.gmail.rybachko.anna.tasksixth.config.ApplicationUserPermission.TASK_WRITE;
import static com.gmail.rybachko.anna.tasksixth.config.ApplicationUserPermission.TOKEN_GET;

public enum ApplicationUserRole {
    EMPLOYEE(Sets.newHashSet(EMPLOYEE_READ, TASK_READ, TASK_WRITE,TOKEN_GET)),
    MANAGER(Sets.newHashSet(EMPLOYEE_READ, EMPLOYEE_WRITE, TASK_READ, TASK_WRITE,TOKEN_GET)),
    TRAINEE(Sets.newHashSet(TASK_READ, EMPLOYEE_READ,TOKEN_GET)),
    SCRUM_MASTER(Sets.newHashSet(TASK_WRITE,TASK_READ,EMPLOYEE_READ,TOKEN_GET));


    private final Set<ApplicationUserPermission> permissions;

    ApplicationUserRole(Set<ApplicationUserPermission> permissions) {
        this.permissions = permissions;
    }

    public Set<ApplicationUserPermission> getPermissions() {
        return permissions;
    }

    public Set<SimpleGrantedAuthority> getAuthorities() {
        Set<SimpleGrantedAuthority> permissions = getPermissions().stream()
                .map(permission -> new SimpleGrantedAuthority(permission.getPermission()))
                .collect(Collectors.toSet());
        permissions.add(new SimpleGrantedAuthority("ROLE_" + this.name()));
        return permissions;
    }
}
