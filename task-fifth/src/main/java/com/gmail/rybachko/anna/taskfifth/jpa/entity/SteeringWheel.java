package com.gmail.rybachko.anna.taskfifth.jpa.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class SteeringWheel {

    @Id
    @GeneratedValue
    private Long id;

    private String nameSteeringWheel;

}
