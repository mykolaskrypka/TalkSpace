package com.challange.talkspace.model.service.mapper;

import com.challange.talkspace.dto.response.UserResponseDto;
import com.challange.talkspace.model.Person;
import org.springframework.stereotype.Component;

@Component
public class UserMapper implements ResponseDtoMapper<UserResponseDto, Person> {
    @Override
    public UserResponseDto mapToDto(Person person) {
        UserResponseDto responseDto = new UserResponseDto();
        responseDto.setId(person.getId());
        responseDto.setLogin(person.getUserName());
        return responseDto;
    }
}
