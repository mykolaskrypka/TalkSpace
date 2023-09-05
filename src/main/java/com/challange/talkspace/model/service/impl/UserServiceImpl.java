package com.challange.talkspace.model.service.impl;

import com.challange.talkspace.model.Person;
import com.challange.talkspace.repository.PersonRepository;
import java.util.Collections;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.*;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserDetailsService {
    private final PersonRepository userRepository;

    @Autowired
    public UserServiceImpl(PersonRepository userRepository) {
        this.userRepository = userRepository;
    }
    @Override
    public UserDetails loadUserByUsername(String nickName) throws UsernameNotFoundException {
        Person user = userRepository.findByUserName(nickName);
        if (user == null) {
            throw new UsernameNotFoundException(nickName);
        }
        return new User(user.getUserName(), user.getPassword(), Collections.emptyList());

    }

    public Person add(Person person) {
        return userRepository.save(person);
    }
//
//    @Override
//    public Person get(Long id) {
//        return userRepository.findById(id).orElseThrow(
//                () -> new RuntimeException("User with id " + id + " not found"));
//    }

//    @Override
//    public Optional<Person> findByLogin(String login) {
//
//        Optional<Person> optionalUser = userRepository.findUserByLogin(login);
//        if (!optionalUser.isPresent()) {
//            throw new UsernameNotFoundException("User with login " + login + "do not exists");
//        }
//        Person person = optionalUser.get();
//        return Optional.of(new Person());
//    }



}
