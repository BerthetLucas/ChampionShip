package com.gestionchampionnat.gestionchampionnatapi.controller;

import com.gestionchampionnat.gestionchampionnatapi.model.ChampionShip;
import com.gestionchampionnat.gestionchampionnatapi.repository.ChampionShipRepository;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/api/championship")
public class ChampionShipController {

    ChampionShipRepository championShipRepository;

    public ChampionShipController(ChampionShipRepository championShipRepository) {
        this.championShipRepository = championShipRepository;
    }

    @GetMapping
    List<ChampionShip> getAllChampionShips() {
        return championShipRepository.findAll();
    }

    @GetMapping("/{id}")
    ChampionShip getChampionShip(@PathVariable(name = "id", required = true) ChampionShip championShip) {

        if (championShip == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "no championship found");
        }
        return championShip;
    }

    @PostMapping
    public ResponseEntity<ChampionShip> createChampionShip(@Valid @RequestBody ChampionShip championShip) {
        championShipRepository.save(championShip);
        return new ResponseEntity<>(championShip, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ChampionShip> updateChampionShip(@Valid @RequestBody ChampionShip updatedChampionShip, @PathVariable(name = "id", required = true) ChampionShip championShip) {

        if (championShip == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "no championship found");
        }

        updatedChampionShip.setId(championShip.getId());
        championShipRepository.save(updatedChampionShip);
        return new ResponseEntity<>(updatedChampionShip, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ChampionShip> deleteChampionShip(@PathVariable(name = "id", required = true) Integer id) {

        ChampionShip championShip = championShipRepository.findChampionShipById(id);

        if (championShip == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "no championship found");
        }

        championShipRepository.delete(championShip);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }


}
