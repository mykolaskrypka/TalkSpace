package com.challange.talkspace.dto.response;

import java.time.LocalDateTime;

import com.challange.talkspace.model.Person;
import lombok.Data;

@Data
public class MessageResponseDto {
    private Long id;
    private Person sender;
    private String content;
    private LocalDateTime timestamp;

}
