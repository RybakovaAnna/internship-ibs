package com.gmail.rybachko.anna.tasksixth.config;

public enum ApplicationUserPermission {
    EMPLOYEE_READ("employee:read"),
    EMPLOYEE_WRITE("employee:write"),
    TASK_READ("task:read"),
    TASK_WRITE("task:write"),
    TOKEN_GET("token:get");

    private final String permission;

    ApplicationUserPermission(String permission) {
        this.permission = permission;
    }

    public String getPermission() {
        return permission;
    }
}
