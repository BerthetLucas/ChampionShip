package com.gestionchampionnat.gestionchampionnatapi.repository;

import com.gestionchampionnat.gestionchampionnatapi.model.Game;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface GameRepository extends CrudRepository<Game, Integer> {

    @Override
    List<Game> findAll();
    
}
