package com.gmail.rybachko.anna.tasksixth.model.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Set;

@Data
@Entity
@Table(name = "user_role")
@AllArgsConstructor
@NoArgsConstructor
public class UserRole {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String permission;
    @ManyToMany(mappedBy = "grantedAuthorities", fetch = FetchType.EAGER)
    private Set<ApplicationUser> applicationUserSet;
}
