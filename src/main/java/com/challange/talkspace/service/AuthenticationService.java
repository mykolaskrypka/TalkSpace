package com.challange.talkspace.service;

import com.challange.talkspace.model.User;

public interface AuthenticationService {
    User register(String login, String password);
}
