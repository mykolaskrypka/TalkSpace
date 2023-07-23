package com.challange.talkspace.service;

import com.challange.talkspace.model.User;
import java.util.Optional;

public interface UserService {
    User add(User user);

    User get(Long id);

    Optional<User> findByEmail(String email);
}
