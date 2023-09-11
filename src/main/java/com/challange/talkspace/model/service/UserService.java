package com.challange.talkspace.model.service;

import com.challange.talkspace.model.Person;
import java.util.Optional;

public interface UserService {
    Person add(Person person);

    Person get(Long id);

    Optional<Person> findByLogin(String login);
}
