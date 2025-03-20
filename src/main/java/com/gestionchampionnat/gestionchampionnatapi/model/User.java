package com.gestionchampionnat.gestionchampionnatapi.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;

@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NotNull(message = "Veuillez communiquer une valeur")
    @NotBlank(message = "Veuillez communiquer une valeur")
    private String firstName;

    @NotNull(message = "Veuillez communiquer une valeur")
    @NotBlank(message = "Veuillez communiquer une valeur")
    private String lastName;

    @NotNull(message = "Veuillez communiquer une valeur")
    @NotBlank(message = "Veuillez communiquer une valeur")
    private String email;

    @NotNull(message = "Veuillez communiquer une valeur")
    @NotBlank(message = "Veuillez communiquer une valeur")
    private String password;

    @NotNull(message = "Veuillez communiquer une valeur")
    @NotBlank(message = "Veuillez communiquer une valeur")
    private LocalDate creationDate;

}
