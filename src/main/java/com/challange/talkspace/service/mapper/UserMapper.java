package com.challange.talkspace.service.mapper;

import com.challange.talkspace.dto.response.UserResponseDto;
import com.challange.talkspace.model.User;
import com.challange.talkspace.service.mapper.ResponseDtoMapper;
import org.springframework.stereotype.Component;

@Component
public class UserMapper implements ResponseDtoMapper<UserResponseDto, User> {
    @Override
    public UserResponseDto mapToDto(User user) {
        UserResponseDto responseDto = new UserResponseDto();
        responseDto.setId(user.getId());
        responseDto.setLogin(user.getLogin());
        return responseDto;
    }
}
