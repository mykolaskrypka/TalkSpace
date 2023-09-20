package com.challange.talkspace.controller;


import com.challange.talkspace.dto.mapper.ResponseDtoMapper;
import com.challange.talkspace.dto.response.UserResponseDto;
import com.challange.talkspace.model.User;

import com.challange.talkspace.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@RestController
@RequestMapping("/users")
public class UserController {
    private final BCryptPasswordEncoder passwordEncoder;
    private final UserService userService;
    private final ResponseDtoMapper<UserResponseDto, User> userResponseDtoMapper;

    @Autowired
    public UserController(BCryptPasswordEncoder passwordEncoder, UserService userService, ResponseDtoMapper<UserResponseDto, User> userResponseDtoMapper) {
        this.passwordEncoder = passwordEncoder;
        this.userService = userService;
        this.userResponseDtoMapper = userResponseDtoMapper;
    }


    @PostMapping("/sign-up")
    public void signUp(@RequestBody User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        userService.add(user);
    }

    @GetMapping("/all")
    public List<UserResponseDto> findAll() {
        return StreamSupport.stream(userService.findAll().spliterator(), false)
                .map(u -> userResponseDtoMapper.mapToDto(u)).collect(Collectors.toList());
    }
}


