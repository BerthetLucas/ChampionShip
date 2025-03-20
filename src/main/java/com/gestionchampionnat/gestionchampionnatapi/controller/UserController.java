package com.gestionchampionnat.gestionchampionnatapi.controller;

import com.gestionchampionnat.gestionchampionnatapi.model.User;
import com.gestionchampionnat.gestionchampionnatapi.repository.UserRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

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

    @GetMapping
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @GetMapping("/{id}")
    public User getUser(@PathVariable(name = "id", required = true) User user) {

        if (user == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "User not found");
        }
        return user;
    }

    @GetMapping("/email/{email}")
    public User getUserByEmail(@PathVariable(name = "email", required = true) String email) {

        User user = userRepository.findUserByEmail(email);

        if (user == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "User not found");
        }
        return user;
    }

    @PutMapping("/{id}")
    public ResponseEntity<User> updateUser(@RequestBody User userToUpdate, @PathVariable(name = "id", required = true) User user) {

        if (user == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "User not found");
        }

        userToUpdate.setId(user.getId());
        userRepository.save(userToUpdate);
        return new ResponseEntity<>(userToUpdate, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<User> deleteUser(@PathVariable(name = "id", required = true) Integer id) {
        User user = userRepository.findUserById(id);
        if (user == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "User not found");
        }

        userRepository.delete(user);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);

    }

}
