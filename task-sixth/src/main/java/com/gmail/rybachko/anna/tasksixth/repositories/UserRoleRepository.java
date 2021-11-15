package com.gmail.rybachko.anna.tasksixth.repositories;

import com.gmail.rybachko.anna.tasksixth.model.entities.UserRole;
import org.springframework.data.repository.CrudRepository;

public interface UserRoleRepository extends CrudRepository<UserRole, Long> {
    UserRole findByPermission(String permission);
}
