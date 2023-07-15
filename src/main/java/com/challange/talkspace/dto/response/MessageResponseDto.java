package com.challange.talkspace.dto.response;

import java.time.LocalDateTime;
import lombok.Data;

@Data
public class MessageResponseDto {
    private Long id;
    private String sender;
    private String content;
    private LocalDateTime timestamp;

}
