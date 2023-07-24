package com.challange.talkspace.controller;


import com.challange.talkspace.dto.response.UserResponseDto;
import com.challange.talkspace.model.User;
import com.challange.talkspace.service.UserService;
import com.challange.talkspace.service.mapper.ResponseDtoMapper;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class UserController {
    private final UserService userService;
    private final ResponseDtoMapper<UserResponseDto, User> userResponseDtoMapper;

    public UserController(UserService userService,
                          ResponseDtoMapper<UserResponseDto, User> userResponseDtoMapper) {
        this.userService = userService;
        this.userResponseDtoMapper = userResponseDtoMapper;
    }

    @GetMapping("/by-login")
    public UserResponseDto findByEmail(@RequestParam String login) {
        User user = userService.findByLogin(login).orElseThrow(
                () -> new RuntimeException("User with login " + login + " not found"));
        return userResponseDtoMapper.mapToDto(user);
    }

    @GetMapping("/injectUser")
    public UserResponseDto injectUser() {
        User user = new User();
        user.setLogin("User2");
        user.setPassword("123456");
        return userResponseDtoMapper.mapToDto(userService.add(user));
    }
}
