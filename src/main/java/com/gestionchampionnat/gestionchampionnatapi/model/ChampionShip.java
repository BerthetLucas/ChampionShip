package com.gestionchampionnat.gestionchampionnatapi.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "championship")
public class ChampionShip {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @NotNull(message = "Donnée nécessaire")
    @NotBlank(message = "Donnée nécessaire")
    private String name;

    @NotNull(message = "Merci d'indiquer une date")
    @Temporal(TemporalType.DATE)
    @JsonFormat(pattern = "yyyy-MM-dd")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate startDate;

    @NotNull(message = "Merci d'indiquer une date")
    @Temporal(TemporalType.DATE)
    @JsonFormat(pattern = "yyyy-MM-dd")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate endDate;

    private Integer wonPoint;
    private Integer lostPoint;
    private Integer drawPoint;

    @ManyToMany(fetch = FetchType.LAZY,
            cascade = {
                    CascadeType.PERSIST,
                    CascadeType.MERGE
            })
    @JoinTable(name = "championship_team",
            joinColumns = {@JoinColumn(name = "championship_id")},
            inverseJoinColumns = {@JoinColumn(name = "team_id")})
    private List<Team> teams;

    @OneToMany(mappedBy = "idChampionship", fetch = FetchType.LAZY)
    @JsonManagedReference
    private List<Day> days;

    public ChampionShip() {
    }

    public ChampionShip(String name, LocalDate startDate, LocalDate endDate, Integer wonPoint, Integer lostPoint, Integer drawPoint, List<Team> team, List<Day> days) {
        this.name = name;
        this.startDate = startDate;
        this.endDate = endDate;
        this.wonPoint = wonPoint;
        this.lostPoint = lostPoint;
        this.drawPoint = drawPoint;
        this.teams = team;
        this.days = days;
    }
    
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    public Integer getWonPoint() {
        return wonPoint;
    }

    public void setWonPoint(Integer wonPoint) {
        this.wonPoint = wonPoint;
    }

    public Integer getLostPoint() {
        return lostPoint;
    }

    public void setLostPoint(Integer lostPoint) {
        this.lostPoint = lostPoint;
    }

    public Integer getDrawPoint() {
        return drawPoint;
    }

    public void setDrawPoint(Integer drawPoint) {
        this.drawPoint = drawPoint;
    }

    public List<Team> getTeams() {
        return teams;
    }

    public void setTeams(List<Team> team) {
        this.teams = team;
    }

    public List<Day> getDays() {
        return days;
    }

    public void setDays(List<Day> days) {
        this.days = days;
    }
}
