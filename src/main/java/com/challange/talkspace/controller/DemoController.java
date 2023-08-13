package com.challange.talkspace.controller;

import com.challange.talkspace.dto.response.UserResponseDto;
import com.challange.talkspace.model.User;
import com.challange.talkspace.service.UserService;
import com.challange.talkspace.service.mapper.ResponseDtoMapper;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {

    private final UserService userService;
    private final ResponseDtoMapper<UserResponseDto, User> userResponseDtoMapper;

    public DemoController(UserService userService, ResponseDtoMapper<UserResponseDto, User> userResponseDtoMapper) {
        this.userService = userService;
        this.userResponseDtoMapper = userResponseDtoMapper;
    }

    @GetMapping("/injectUser2")
    public UserResponseDto injectUser() {
        User user = new User();
        user.setLogin("User2");
        user.setPassword("123456");
        return userResponseDtoMapper.mapToDto(userService.add(user));
    }

    @GetMapping("/getUser2")
    public UserResponseDto getUser2() {
        User user = userService.findByLogin("User2").orElseThrow(
                () -> new RuntimeException("User with login " + "User2" + " not found"));
        return userResponseDtoMapper.mapToDto(user);
    }

    @GetMapping("/injectData")
    public String injectData() {

        return "Successfully injected!";
    }

}
