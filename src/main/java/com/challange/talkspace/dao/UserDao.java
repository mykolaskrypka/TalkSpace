package com.challange.talkspace.dao;

import com.challange.talkspace.model.User;

import java.util.Optional;

public interface UserDao {
    User add(User user);

    Optional<User> get(Long id);

    Optional<User> findByEmail(String email);
}