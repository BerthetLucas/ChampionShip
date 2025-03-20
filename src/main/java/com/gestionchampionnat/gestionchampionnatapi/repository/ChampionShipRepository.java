package com.gestionchampionnat.gestionchampionnatapi.repository;

import com.gestionchampionnat.gestionchampionnatapi.model.ChampionShip;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ChampionShipRepository extends CrudRepository<ChampionShip, Integer> {

    @Override
    List<ChampionShip> findAll();

    ChampionShip findChampionShipById(Integer id);
}
