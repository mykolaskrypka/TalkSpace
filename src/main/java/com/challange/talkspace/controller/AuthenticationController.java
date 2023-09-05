package com.challange.talkspace.controller;

import com.challange.talkspace.dto.request.UserRequestDto;
import com.challange.talkspace.dto.response.UserResponseDto;
import com.challange.talkspace.model.User;
import com.challange.talkspace.service.AuthenticationService;
import com.challange.talkspace.service.UserService;
import com.challange.talkspace.service.mapper.ResponseDtoMapper;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import javax.validation.Valid;
import java.util.Optional;

@RestController
public class AuthenticationController {
    private final AuthenticationService authService;
    private final ResponseDtoMapper<UserResponseDto, User> userDtoResponseMapper;
    private final UserService userService;
    private final ResponseDtoMapper<UserResponseDto, User> userResponseDtoMapper;

    public AuthenticationController(AuthenticationService authService,
                                    ResponseDtoMapper<UserResponseDto, User> userDtoResponseMapper,
                                    UserService userService,
                                    ResponseDtoMapper<UserResponseDto, User> userResponseDtoMapper) {
        this.authService = authService;
        this.userDtoResponseMapper = userDtoResponseMapper;
        this.userService = userService;
        this.userResponseDtoMapper = userResponseDtoMapper;
    }

    @PostMapping("/register")
    public UserResponseDto register(@RequestBody @Valid UserRequestDto requestDto) {
        User user = authService.register(requestDto.getLogin(), requestDto.getPassword());
        return userDtoResponseMapper.mapToDto(user);
    }

    @PostMapping("/login")
    public UserResponseDto login(@RequestBody @Valid UserRequestDto requestDto) {
        Optional<User> userOptional = userService.findByLogin(requestDto.getLogin());
        if (userOptional.isPresent()) {
            return userDtoResponseMapper.mapToDto(userOptional.get());
        }
        //else register new user
        User user = authService.register(requestDto.getLogin(), "");
        return userDtoResponseMapper.mapToDto(user);
    }


    @GetMapping("/getHello")
    public String getHello() {
        return "Hello, TalkSpacers!!!";
    }
}
