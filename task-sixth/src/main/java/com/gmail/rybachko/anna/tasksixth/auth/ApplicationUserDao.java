package com.gmail.rybachko.anna.tasksixth.auth;

import com.gmail.rybachko.anna.tasksixth.model.entities.ApplicationUser;

import java.util.Optional;

public interface ApplicationUserDao {
    Optional<ApplicationUser> selectUserFromDbByUserName(String username);
}
