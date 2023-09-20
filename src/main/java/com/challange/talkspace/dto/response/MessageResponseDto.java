package com.challange.talkspace.dto.response;

import java.time.LocalDateTime;

import com.challange.talkspace.model.User;
import lombok.Data;

@Data
public class MessageResponseDto {
    private Long id;
    private User sender;
    private String content;
    private LocalDateTime timestamp;

}
