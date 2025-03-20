package com.gestionchampionnat.gestionchampionnatapi.controller;

import com.gestionchampionnat.gestionchampionnatapi.model.Team;
import com.gestionchampionnat.gestionchampionnatapi.repository.TeamRepository;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/api/team")
public class TeamController {

    TeamRepository teamRepository;

    public TeamController(TeamRepository teamRepository) {
        this.teamRepository = teamRepository;
    }

    @GetMapping
    public List<Team> getAllTeams() {
        return teamRepository.findAll();
    }

    @GetMapping("/{id}")
    public Team getTeam(@PathVariable(name = "id", required = true) Team team) {

        if (team == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Team not found");
        }
        return team;
    }

    @PostMapping
    public ResponseEntity<Team> createTeam(@Valid @RequestBody Team team) {
        teamRepository.save(team);
        return new ResponseEntity<>(team, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Team> updateTeam(@Valid @RequestBody Team updatedTeam, @PathVariable(name = "id", required = true) Team team) {

        if (team == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "no championship found");
        }

        updatedTeam.setId(team.getId());
        teamRepository.save(updatedTeam);
        return new ResponseEntity<>(updatedTeam, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Team> deleteTeam(@PathVariable(name = "id", required = true) Integer id) {

        Team team = teamRepository.findById(id).orElse(null);

        if (team == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "no championship found");
        }

        teamRepository.delete(team);
        return new ResponseEntity<>(team, HttpStatus.NO_CONTENT);
    }


}
