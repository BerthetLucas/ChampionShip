package com.gestionchampionnat.gestionchampionnatapi.controller;

import com.gestionchampionnat.gestionchampionnatapi.model.Game;
import com.gestionchampionnat.gestionchampionnatapi.repository.GameRepository;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/game")
public class GameController {

    GameRepository repository;

    public GameController(GameRepository repository) {
        this.repository = repository;
    }

    @PostMapping
    public Game createGame(@RequestBody Game game) {
        return repository.save(game);
    }


}
