package com.gestionchampionnat.gestionchampionnatapi.controller;

import com.gestionchampionnat.gestionchampionnatapi.model.ChampionShip;
import com.gestionchampionnat.gestionchampionnatapi.model.Day;
import com.gestionchampionnat.gestionchampionnatapi.model.Game;
import com.gestionchampionnat.gestionchampionnatapi.repository.GameRepository;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/api/game")
public class GameController {

    GameRepository gameRepository;

    public GameController(GameRepository gameRepository) {
        this.gameRepository = gameRepository;
    }

    @PostMapping("/day/{id}")
    public Game createGame(@PathVariable(name = "id", required = true) Day day, @Valid @RequestBody Game game) {

        game.setDay(day);
        return gameRepository.save(game);
    }

    @GetMapping
    public List<Game> getAllGames() {
        return gameRepository.findAll();
    }

    @GetMapping("/championship/{id}")
    public List<Game> getChampionshipGames(@PathVariable(name = "id", required = true) ChampionShip championship) {

        if (championship == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Championship not found");
        }

        return gameRepository.findGamesByChampionshipId(championship.getId());

    }

    @GetMapping("/day/{id}")
    public List<Game> getGame(@PathVariable(name = "id", required = true) Day day) {

        if (day == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Day not found");
        }

        return gameRepository.findAllByDay(day);

    }

    @PutMapping("/{id}")
    public ResponseEntity<Game> updateGame(@PathVariable(name = "id", required = true) Game game, @Valid @RequestBody Game updatedGame) {

        if (game == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Game not found");
        }

        updatedGame.setId(game.getId());
        gameRepository.save(updatedGame);
        return new ResponseEntity<>(updatedGame, HttpStatus.OK);

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Game> deleteGame(@PathVariable(name = "id", required = true) Game game) {
        if (game == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Game not found");

        }
        gameRepository.delete(game);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }


}
