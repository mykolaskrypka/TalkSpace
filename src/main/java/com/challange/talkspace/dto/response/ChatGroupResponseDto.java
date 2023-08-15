package com.challange.talkspace.dto.response;

import com.challange.talkspace.model.ChatType;
import com.challange.talkspace.model.User;
import lombok.Data;

import java.util.Set;

@Data
public class ChatGroupResponseDto {
    private Long id;
    private String name;
    private String description;
    private ChatType chatType;
    Set<User> users;

}
