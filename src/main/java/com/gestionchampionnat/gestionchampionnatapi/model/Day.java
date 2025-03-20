package com.gestionchampionnat.gestionchampionnatapi.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

import java.util.List;

@Entity
public class Day {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String number;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "championship_id", nullable = false)
    @JsonBackReference("championship-days")
    private ChampionShip championship;

    @OneToMany(mappedBy = "day", fetch = FetchType.LAZY)
    @JsonManagedReference("day-games")
    private List<Game> games;

    public Day() {
    }

    public Day(String number, ChampionShip championship) {
        this.number = number;
        this.championship = championship;
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

    public ChampionShip getChampionship() {
        return championship;
    }

    public void setIdChampionship(ChampionShip championship) {
        this.championship = championship;
    }
}
