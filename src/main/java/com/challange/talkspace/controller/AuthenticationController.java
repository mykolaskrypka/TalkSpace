package com.challange.talkspace.controller;

import com.challange.talkspace.dto.request.UserRequestDto;
import com.challange.talkspace.dto.response.UserResponseDto;
import com.challange.talkspace.model.Person;
import com.challange.talkspace.model.service.AuthenticationService;
import com.challange.talkspace.model.service.mapper.ResponseDtoMapper;
import com.challange.talkspace.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;


@RestController
public class AuthenticationController {
//    private final AuthenticationService authService;
//    private final ResponseDtoMapper<UserResponseDto, Person> userDtoResponseMapper;
//
//
//
//    public AuthenticationController(AuthenticationService authService,
//                                    ResponseDtoMapper<UserResponseDto, Person> userDtoResponseMapper) {
//        this.authService = authService;
//        this.userDtoResponseMapper = userDtoResponseMapper;
//    }

//    @PostMapping("/register")
//    public UserResponseDto register(@RequestBody @Valid UserRequestDto requestDto) {
//        Person person = authService.register(requestDto.getLogin());
//        return userDtoResponseMapper.mapToDto(person);
//    }


    @Autowired
    private PersonRepository personRepository;
    @GetMapping("/getHello")
    public String getHello() {
        return "Hello, TalkSpacers!!!";
    }
//    @GetMapping("/register")
//    public String registerEndpoint() {
//        return "register in Thread TalkSpace";
//    }

    @GetMapping("/login")
    public String login(Model model) {
        model.addAttribute("userForm", new Person());
        return "login";
    }

//    @PostMapping("/register")
//    public String register() {
//        return "register";
//    }

    @PostMapping("/login")
    public void signUp(@ModelAttribute ("userForm") @Valid Person userForm ) {
        personRepository.save(userForm);
    }
}


//    @GetMapping("/admin")
//    public String adminEndpoint() {
//        return "Admin!";
//    }
//
//    @GetMapping("/user")
//    public String userEndpoint() {
//        return "User!";
//    }
//
//    @GetMapping("/all")
//    public String allRolesEndpoint() {
//        return "All Roles!";
//    }
//
//    @DeleteMapping("/delete")
//    public String deleteEndpoint(@RequestBody String s) {
//        return "I am deleting " + s;
//    }
//}

// конечная точка /login , доступную любому,
// определенные конечные точки для администратора и пользователя,
// а также конечную точку /all , не защищенную ролью, но все же требующую аутентификации.