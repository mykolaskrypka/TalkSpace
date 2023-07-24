package com.challange.talkspace.service.impl;

import com.challange.talkspace.model.User;
import com.challange.talkspace.service.AuthenticationService;
import com.challange.talkspace.service.RoleService;
import com.challange.talkspace.service.UserService;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class AuthenticationServiceImpl implements AuthenticationService {
    private final UserService userService;
    private final RoleService roleService;

    public AuthenticationServiceImpl(UserService userService,
                                     RoleService roleService) {
        this.userService = userService;
        this.roleService = roleService;
    }

    @Override
    public User register(String login, String password) {
        User user = new User();
        user.setLogin(login);
        user.setPassword(password);
        user.setRoles(Set.of(roleService.getByName("USER")));
        userService.add(user);
        return user;
    }
}
