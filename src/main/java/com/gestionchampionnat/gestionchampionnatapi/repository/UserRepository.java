package com.gestionchampionnat.gestionchampionnatapi.repository;

import com.gestionchampionnat.gestionchampionnatapi.model.User;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface UserRepository extends CrudRepository<User, Integer> {

    @Override
    List<User> findAll();

    User findUserByEmail(String email);
}
