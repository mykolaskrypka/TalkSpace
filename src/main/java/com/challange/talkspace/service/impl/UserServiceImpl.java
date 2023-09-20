package com.challange.talkspace.service.impl;

import com.challange.talkspace.model.User;
import com.challange.talkspace.repository.UserRepository;

import java.util.List;
import java.util.Optional;

import com.challange.talkspace.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.*;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User add(User user) {
        return userRepository.save(user);
    }

    @Override
    public User get(Long id) {
        return userRepository.findById(id).orElseThrow(
                () -> new RuntimeException("User with id " + id + " not found"));
    }

    @Override
    public Optional<User> findByUserName(String login) {

        Optional<User> optionalUser = userRepository.findByUserName(login);
        if (!optionalUser.isPresent()) {
            throw new UsernameNotFoundException("User with login " + login + " do not exists");
        }
        return optionalUser;
    }

    @Override
    public List<User> findAll() {
        return userRepository.findAll();
    }


}
