package com.challange.talkspace.service.impl;

import com.challange.talkspace.model.User;

import com.challange.talkspace.service.AuthenticationService;
import com.challange.talkspace.service.RoleService;
import com.challange.talkspace.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class AuthenticationServiceImpl implements AuthenticationService {
    private final UserService userService;
    private final RoleService roleService;

    private final BCryptPasswordEncoder encoder;

    @Autowired
    public AuthenticationServiceImpl(UserService userService,
                                     RoleService roleService, BCryptPasswordEncoder encoder) {
        this.userService = userService;
        this.roleService = roleService;
        this.encoder = encoder;
    }

    @Override
    public User register(String login, String password) {
        User user = new User();
        user.setUserName(login);
        user.setPassword(encoder.encode(password));
        user.setRoles(Set.of(roleService.getByName("USER")));
        userService.add(user);
        return user;
    }

    @Override
    public User login(String userName, String password) {
        userService.findByUserName(userName);
        return null;
    }

}
