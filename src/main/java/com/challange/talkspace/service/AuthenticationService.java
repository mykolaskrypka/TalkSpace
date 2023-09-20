package com.challange.talkspace.service;

import com.challange.talkspace.model.User;

public interface AuthenticationService {
    User register(String name, String password);

    User login(String userName, String password);
}
