package com.gestionchampionnat.gestionchampionnatapi.repository;

import com.gestionchampionnat.gestionchampionnatapi.model.ChampionShip;
import com.gestionchampionnat.gestionchampionnatapi.model.Day;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface DayRepository extends CrudRepository<Day, Integer> {

    @Override
    List<Day> findAll();

    List<Day> findAllByChampionship(ChampionShip Championship);
}
