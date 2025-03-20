package com.gestionchampionnat.gestionchampionnatapi.controller;

import com.gestionchampionnat.gestionchampionnatapi.model.ChampionShip;
import com.gestionchampionnat.gestionchampionnatapi.model.Day;
import com.gestionchampionnat.gestionchampionnatapi.repository.DayRepository;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/api/day")
public class DayController {

    DayRepository dayRepository;

    public DayController(DayRepository dayRepository) {
        this.dayRepository = dayRepository;
    }

    @PostMapping
    public ResponseEntity<Day> createDay(@Valid @RequestBody Day day) {
        dayRepository.save(day);

        return new ResponseEntity<>(day, HttpStatus.CREATED);
    }

    @GetMapping
    public List<Day> getAllDays() {
        return dayRepository.findAll();
    }

    @GetMapping("/championship/{id}")
    public List<Day> getChampionshipDays(@PathVariable(name = "id", required = true) ChampionShip championShip) {

        return dayRepository.findAllByChampionship(championShip);
    }

    @GetMapping("/{id}")
    public Day getDay(@PathVariable(name = "id", required = true) Day day) {

        if (day == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Day not found");
        }
        return day;
    }

    @PutMapping("/{id}")
    public ResponseEntity<Day> updateDay(@PathVariable(name = "id", required = true) Day day, @Valid @RequestBody Day updatedDay) {

        if (day == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Day not found");
        }
        updatedDay.setId(day.getId());
        dayRepository.save(updatedDay);
        return new ResponseEntity<>(updatedDay, HttpStatus.OK);
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<Day> deleteDay(@PathVariable(name = "id", required = true) Day day) {
        if (day == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Day not found");
        }
        dayRepository.delete(day);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
