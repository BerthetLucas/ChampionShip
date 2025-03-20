package com.gestionchampionnat.gestionchampionnatapi.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;

@Entity
public class Day {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String number;

    @ManyToOne(fetch = FetchType.LAZY)
    @JsonBackReference
    private ChampionShip idChampionship;

    public Day() {
    }

    public Day(String number, ChampionShip idChampionship) {
        this.number = number;
        this.idChampionship = idChampionship;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public ChampionShip getIdChampionship() {
        return idChampionship;
    }

    public void setIdChampionship(ChampionShip idChampionship) {
        this.idChampionship = idChampionship;
    }
}
