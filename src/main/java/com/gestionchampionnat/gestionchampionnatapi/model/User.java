package com.gestionchampionnat.gestionchampionnatapi.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import org.springframework.format.annotation.DateTimeFormat;

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

    @Column(unique = true)
    @NotNull(message = "Veuillez communiquer une valeur")
    @NotBlank(message = "Veuillez communiquer une valeur")
    private String email;

    @NotNull(message = "Veuillez communiquer une valeur")
    @NotBlank(message = "Veuillez communiquer une valeur")
    private String password;

    @NotNull(message = "Merci d'indiquer une date")
    @Temporal(TemporalType.DATE)
    @JsonFormat(pattern = "yyyy-MM-dd")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate creationDate;

    public User() {
    }

    public User(String firstName, String lastName, String email, String password, LocalDate creationDate) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
        this.creationDate = creationDate;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public LocalDate getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(LocalDate creationDate) {
        this.creationDate = creationDate;
    }
}
