package com.gestionchampionnat.gestionchampionnatapi.repository;

import com.gestionchampionnat.gestionchampionnatapi.model.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Integer> {
}
