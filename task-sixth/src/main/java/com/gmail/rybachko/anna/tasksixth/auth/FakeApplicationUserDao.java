package com.gmail.rybachko.anna.tasksixth.auth;

import com.gmail.rybachko.anna.tasksixth.model.entities.ApplicationUser;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class FakeApplicationUserDao implements ApplicationUserDao {
    private final List<ApplicationUser> applicationUsers;

    @Override
    public Optional<ApplicationUser> selectUserFromDbByUserName(String username) {
        return applicationUsers.stream()
                .filter(applicationUser -> username.equals(applicationUser.getUsername()))
                .findFirst();
    }
}
