package com.challange.talkspace.dto.request;

import java.time.LocalDateTime;

import com.challange.talkspace.model.User;
import lombok.Data;

@Data
public class MessageRequestDto {
    private User sender;
    private String content;
    private LocalDateTime timestamp;

}
