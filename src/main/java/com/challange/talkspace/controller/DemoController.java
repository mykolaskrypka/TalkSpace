package com.challange.talkspace.controller;

import com.challange.talkspace.dto.response.UserResponseDto;
import com.challange.talkspace.model.Person;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

//@RestController
//public class DemoController {
//
//    private final UserService userService;
//    private final ResponseDtoMapper<UserResponseDto, Person> userResponseDtoMapper;
//
//    public DemoController(UserService userService, ResponseDtoMapper<UserResponseDto, Person> userResponseDtoMapper) {
//        this.userService = userService;
//        this.userResponseDtoMapper = userResponseDtoMapper;
//    }
//
//    @GetMapping("/injectUser2")
//    public UserResponseDto injectUser() {
//        Person person = new Person();
//        person.setLogin("User2");
//        person.setPassword("123456");
//        return userResponseDtoMapper.mapToDto(userService.add(person));
//    }
//
//    @GetMapping("/getUser2")
//    public UserResponseDto getUser2() {
//        Person person = userService.findByLogin("User2").orElseThrow(
//                () -> new RuntimeException("User with login " + "User2" + " not found"));
//        return userResponseDtoMapper.mapToDto(person);
//    }
//
//    @GetMapping("/injectData")
//    public String injectData() {
//
//        return "Successfully injected!";
//    }
//
//}
