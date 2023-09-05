package com.challange.talkspace.dto.request;

import java.time.LocalDateTime;

import com.challange.talkspace.model.Person;
import lombok.Data;

@Data
public class MessageRequestDto {
    private Person sender;
    private String content;
    private LocalDateTime timestamp;

}
