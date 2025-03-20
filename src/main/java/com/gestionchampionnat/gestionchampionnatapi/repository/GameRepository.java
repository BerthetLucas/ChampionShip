package com.gestionchampionnat.gestionchampionnatapi.repository;

import com.gestionchampionnat.gestionchampionnatapi.model.Day;
import com.gestionchampionnat.gestionchampionnatapi.model.Game;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface GameRepository extends CrudRepository<Game, Integer> {

    @Override
    List<Game> findAll();

    List<Game> findAllByDay(Day day);

    @Query("SELECT game FROM Game game WHERE game.day.championship.id = :championshipId")
    List<Game> findGamesByChampionshipId(@Param("championshipId") Integer championshipId);
}
