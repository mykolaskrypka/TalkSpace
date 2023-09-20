package com.challange.talkspace.controller;

import com.challange.talkspace.model.User;
import com.challange.talkspace.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@RestController
@RequestMapping("/people")
public class PersonController {

    private final UserRepository userRepository;

    @Autowired
    public PersonController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @GetMapping("/")
    public List<User> getAll() {
        return StreamSupport.stream(userRepository.findAll().spliterator(), false)
                .collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public ResponseEntity<User> getById(@PathVariable("id") long id) {
        var person = userRepository.findById( id);

        return new ResponseEntity<>(
                person.orElse(new User()),
                person.isPresent() ? HttpStatus.OK : HttpStatus.NOT_FOUND);
    }

    @PostMapping("/")
    public ResponseEntity<User> create(@RequestBody User user) {
        return new ResponseEntity<>(
                userRepository.save(user),
                HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> update(@PathVariable("id") long id, @RequestBody User user) {
        if (user.getId() != id) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        if (!userRepository.existsById(id)) {
            userRepository.save(user);
            return new ResponseEntity<>(HttpStatus.CREATED);
        }
        userRepository.save(user);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") int id) {
        userRepository.deleteById((long) id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
