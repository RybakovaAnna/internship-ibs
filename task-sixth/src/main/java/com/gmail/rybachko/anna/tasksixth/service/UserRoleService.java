package com.gmail.rybachko.anna.tasksixth.service;

import com.gmail.rybachko.anna.tasksixth.model.entities.UserRole;

import java.util.List;

public interface UserRoleService {
    List<UserRole> getUserRolesForEmployee();

    List<UserRole> getUserRolesForManager();

    List<UserRole> getUserRolesForTrainee();

    List<UserRole> getUserRolesForScrumMaster();
}
