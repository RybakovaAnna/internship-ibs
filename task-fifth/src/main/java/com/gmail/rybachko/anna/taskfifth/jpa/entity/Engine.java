package com.gmail.rybachko.anna.taskfifth.jpa.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Engine {
    @Id
    @GeneratedValue
    private Long id;

    private String type;

    @OneToMany(cascade = CascadeType.ALL)
    private List<Gear> gears;

    @OneToMany(cascade = CascadeType.ALL)
    private List<Piston> pistons;

    @Override
    public String toString() {
        return "";
    }
}
