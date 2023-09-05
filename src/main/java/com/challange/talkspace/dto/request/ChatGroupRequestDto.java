package com.challange.talkspace.dto.request;

import com.challange.talkspace.model.ChatType;
import com.challange.talkspace.model.Person;
import lombok.Data;

import java.util.Set;

@Data
public class ChatGroupRequestDto {
    private String name;
    private String description;
    private ChatType chatType;
    Set<Person> people;

}
