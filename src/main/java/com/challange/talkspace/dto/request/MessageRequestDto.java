package com.challange.talkspace.dto.request;

import java.time.LocalDateTime;
import lombok.Data;

@Data
public class MessageRequestDto {
    private String sender;
    private String content;
    private LocalDateTime timestamp;

}
