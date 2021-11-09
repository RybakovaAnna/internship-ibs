package com.gmail.rybachko.anna.taskfifth.jpa.repositories;

import com.gmail.rybachko.anna.taskfifth.jpa.entity.Car;
import org.springframework.data.repository.CrudRepository;

public interface CarRepository extends CrudRepository<Car,Long> {
}
