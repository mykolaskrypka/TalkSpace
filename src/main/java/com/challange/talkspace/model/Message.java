package com.challange.talkspace.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;
import lombok.Data;

@Data
@Entity
@Table(name = "message")
public class Message {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "user_id")
    private Person sender;

    @Column
    private String content;

    private LocalDateTime timestamp;

    @ManyToOne
    @JoinColumn(name = "chatGroup_id")
    private ChatGroup chatGroup;


    public Message() {
    this.timestamp=  LocalDateTime.now();
    }

    public static  Message of (Person sender, String content, ChatGroup chatGroup) {
        Message message = new Message();
        message.sender = sender;
        message.content = content;
        message.chatGroup=chatGroup;
        return message;
    }
}
