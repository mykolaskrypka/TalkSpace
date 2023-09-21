package com.challange.talkspace.controller;
import com.challange.talkspace.dto.request.UserRequestDto;
import com.challange.talkspace.dto.response.UserResponseDto;
import com.challange.talkspace.model.User;
import com.challange.talkspace.service.AuthenticationService;
import com.challange.talkspace.dto.mapper.UserMapper;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;


@RestController
public class AuthenticationController {

    private AuthenticationService authService;
    private UserMapper userMapper;

    public AuthenticationController(AuthenticationService authService, UserMapper userMapper) {
        this.authService = authService;
        this.userMapper = userMapper;
    }

    @GetMapping("/getHello")
    public String getHello() {
        return "Hello, TalkSpacers!!!";
    }

    @PostMapping("/register")
    public UserResponseDto register(@RequestBody @Valid UserRequestDto requestDto) {
        User user = authService.register(requestDto.getUserName(), requestDto.getPassword());
        return userMapper.mapToDto(user);
    }

//    @RequestMapping(path = "/logout")
//    public String logout(HttpServletRequest request) {
//        request.getSession(true).invalidate();
//
//        return "redirect:/login";
//    }

}
