package com.gmail.rybachko.anna.tasksixth.model.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Entity
@Builder(toBuilder = true)
@AllArgsConstructor
@NoArgsConstructor
public class Token {
    @Id
    @JsonIgnore
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @JsonIgnore
    private String username;

    @Column(length = 1000)
    @JsonProperty("access_token")
    private String accessToken;

    @JsonProperty("refresh_token")
    @Column(length = 1000)
    private String refreshToken;

    @Override
    public String toString() {
        return "{" + "\n" +
                "access-token: " + accessToken +
                ",\nrefresh-token: " + refreshToken + "\n" +
                "}";
    }
}