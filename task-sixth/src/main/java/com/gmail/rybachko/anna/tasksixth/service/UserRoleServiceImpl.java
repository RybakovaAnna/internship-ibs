package com.gmail.rybachko.anna.tasksixth.service;

import com.gmail.rybachko.anna.tasksixth.model.entities.UserRole;
import com.gmail.rybachko.anna.tasksixth.repositories.UserRoleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

import static java.util.Arrays.asList;

@Service
@RequiredArgsConstructor
public class UserRoleServiceImpl implements UserRoleService {
    private final UserRoleRepository userRoleRepository;

    @Override
    public List<UserRole> getUserRolesForEmployee() {
        return asList(
                userRoleRepository.findByPermission("employee:read"),
                userRoleRepository.findByPermission("task:read"),
                userRoleRepository.findByPermission("task:write"),
                userRoleRepository.findByPermission("token:get")
        );
    }

    @Override
    public List<UserRole> getUserRolesForManager() {
        return asList(
                userRoleRepository.findByPermission("employee:read"),
                userRoleRepository.findByPermission("employee:write"),
                userRoleRepository.findByPermission("task:write"),
                userRoleRepository.findByPermission("token:get"),
                userRoleRepository.findByPermission("task:read")
        );
    }

    @Override
    public List<UserRole> getUserRolesForTrainee() {
        return asList(
                userRoleRepository.findByPermission("employee:read"),
                userRoleRepository.findByPermission("task:read"),
                userRoleRepository.findByPermission("token:get")
        );
    }

    @Override
    public List<UserRole> getUserRolesForScrumMaster() {
        return asList(
                userRoleRepository.findByPermission("employee:read"),
                userRoleRepository.findByPermission("task:read"),
                userRoleRepository.findByPermission("task:write"),
                userRoleRepository.findByPermission("token:get")
        );
    }
}
