package com.gmail.rybachko.anna.tasksixth.repositories;

import com.gmail.rybachko.anna.tasksixth.model.entities.ApplicationUser;
import org.springframework.data.repository.CrudRepository;

public interface ApplicationUserRepository extends CrudRepository<ApplicationUser, Long> {
}
