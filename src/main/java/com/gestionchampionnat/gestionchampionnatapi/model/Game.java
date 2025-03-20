package com.gestionchampionnat.gestionchampionnatapi.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;

@Entity
public class Game {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;


    private Integer team1point;

    private Integer team2point;

    @ManyToOne(fetch = FetchType.LAZY)
    @JsonBackReference("team1-games")
    private Team team1;

    @ManyToOne(fetch = FetchType.LAZY)
    @JsonBackReference("team2-games")
    private Team team2;

    @ManyToOne(fetch = FetchType.LAZY)
    @JsonBackReference("day-games")
    private Day day;

    public Game() {
    }

    public Game(Integer team1point, Integer team2point, Team team1, Team team2, Day day) {
        this.team1point = team1point;
        this.team2point = team2point;
        this.team1 = team1;
        this.team2 = team2;
        this.day = day;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getTeam1point() {
        return team1point;
    }

    public void setTeam1point(Integer team1point) {
        this.team1point = team1point;
    }

    public Integer getTeam2point() {
        return team2point;
    }

    public void setTeam2point(Integer team2point) {
        this.team2point = team2point;
    }

    public Team getTeam1() {
        return team1;
    }

    public void setTeam1(Team team1) {
        this.team1 = team1;
    }

    public Team getTeam2() {
        return team2;
    }

    public void setTeam2(Team team2) {
        this.team2 = team2;
    }

    public Day getDay() {
        return day;
    }

    public void setDay(Day day) {
        this.day = day;
    }
}
