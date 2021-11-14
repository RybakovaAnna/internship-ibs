package com.gmail.rybachko.anna.tasksixth.auth;

import com.google.common.collect.Lists;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

import static com.gmail.rybachko.anna.tasksixth.config.ApplicationUserRole.EMPLOYEE;
import static com.gmail.rybachko.anna.tasksixth.config.ApplicationUserRole.MANAGER;
import static com.gmail.rybachko.anna.tasksixth.config.ApplicationUserRole.SCRUM_MASTER;
import static com.gmail.rybachko.anna.tasksixth.config.ApplicationUserRole.TRAINEE;


@RequiredArgsConstructor
@Service("fake")
public class FakeApplicationUserDao implements ApplicationUserDao {

    private final PasswordEncoder passwordEncoder;

    @Override
    public Optional<ApplicationUser> selectUserFromDbByUserName(String username) {
        return getApplicationUsers()
                .stream()
                .filter(applicationUser -> username.equals(applicationUser.getUsername()))
                .findFirst();
    }


    private List<ApplicationUser> getApplicationUsers() {
        return Lists.newArrayList(
                new ApplicationUser(
                        "oliver",
                        passwordEncoder.encode("password123"),
                        EMPLOYEE.getAuthorities(),
                        true,
                        true,
                        true,
                        true
                ),
                new ApplicationUser(
                        "henry",
                        passwordEncoder.encode("password123"),
                        MANAGER.getAuthorities(),
                        true,
                        true,
                        true,
                        true
                ),
                new ApplicationUser(
                        "emma",
                        passwordEncoder.encode("password123"),
                        TRAINEE.getAuthorities(),
                        true,
                        true,
                        true,
                        true
                ),
                new ApplicationUser(
                        "anna",
                        passwordEncoder.encode("password123"),
                        SCRUM_MASTER.getAuthorities(),
                        true,
                        true,
                        true,
                        true
                )
        );
    }

}
