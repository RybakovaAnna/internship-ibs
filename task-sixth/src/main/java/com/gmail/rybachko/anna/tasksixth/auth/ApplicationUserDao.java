package com.gmail.rybachko.anna.tasksixth.auth;

import java.util.Optional;

public interface ApplicationUserDao {

    Optional<ApplicationUser> selectUserFromDbByUserName(String username);
}
