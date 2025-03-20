package com.gestionchampionnat.gestionchampionnatapi.controller;

import com.gestionchampionnat.gestionchampionnatapi.model.User;
import com.gestionchampionnat.gestionchampionnatapi.repository.UserRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/user")
public class UserController {

    UserRepository userRepository;
    PasswordEncoder passwordEncoder;

    public UserController(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @PostMapping
    public ResponseEntity<User> createUser(@RequestBody User user) {
        String password = user.getPassword();
        user.setPassword(passwordEncoder.encode(password));
        return new ResponseEntity<>(userRepository.save(user), HttpStatus.CREATED);
    }

}
