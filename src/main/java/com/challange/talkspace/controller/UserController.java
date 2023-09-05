package com.challange.talkspace.controller;


import com.challange.talkspace.model.Person;
import com.challange.talkspace.repository.PersonRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@RestController
@RequestMapping("/users")
public class UserController {
    private final PersonRepository repository;
   private final BCryptPasswordEncoder passwordEncoder;

    //private final UserService userService;
    //private final ResponseDtoMapper<UserResponseDto, Person> userResponseDtoMapper;

    @Autowired
    public UserController(PersonRepository repository, BCryptPasswordEncoder passwordEncoder) {
        this.repository = repository;
        this.passwordEncoder = passwordEncoder;
    }


    @PostMapping("/sign-up")
    public void signUp(@RequestBody Person person) {
        person.setPassword(passwordEncoder.encode(person.getPassword()));
        repository.save(person);
    }

    @GetMapping("/all")
    public List<Person> findAll() {
        return StreamSupport.stream(repository.findAll().spliterator(), false)
                .collect(Collectors.toList());
    }
}


