package com.challange.talkspace.dto.mapper;

import com.challange.talkspace.dto.request.UserRequestDto;
import com.challange.talkspace.dto.response.UserResponseDto;
import com.challange.talkspace.model.User;
import org.springframework.stereotype.Component;

@Component
public class UserMapper implements ResponseDtoMapper<UserResponseDto, User>,
    RequestDtoMapper<UserRequestDto, User> {
    @Override
    public UserResponseDto mapToDto(User user) {
        UserResponseDto responseDto = new UserResponseDto();
        responseDto.setId(user.getId());
        responseDto.setUserName(user.getUserName());
        return responseDto;
    }

    @Override
    public User mapToModel(UserRequestDto dto) {
        User user = new User();
        user.setUserName(dto.getUserName());
        user.setPassword(dto.getPassword());
        return user;
    }
}
