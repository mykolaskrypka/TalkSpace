package com.challange.talkspace.model;

import jakarta.persistence.*;

import java.time.LocalDateTime;

import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Entity
@Getter
@Setter
@Table(name = "message")
public class Message {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String chatId;

    @ManyToOne
    @JoinColumn(name = "userSender_id", insertable = false, updatable = false)
    private Person sender;


    private Long senderId;

    @ManyToOne
    @JoinColumn(name = "userRecipient_id",insertable = false, updatable = false)
    private Person recipient;


    private Long recipientId;

    @Enumerated(value = EnumType.STRING)
    @Column
    private MessageType type;

    public enum MessageType {
        CHAT, JOIN, LEAVE
    }

    @Column
    private String content;

    @Column
    private LocalDateTime timestamp;

    @ManyToOne
    @JoinColumn(name = "chatGroup_id")
    private ChatGroup chatGroup;

    @Column
    private MessageStatus status;

    public Message() {
        this.timestamp = LocalDateTime.now();
    }

    public static Message of(Person sender, String content, ChatGroup chatGroup) {
        Message message = new Message();
        message.sender = sender;
        message.content = content;
        message.chatGroup = chatGroup;
        return message;
    }

    public void setSender(Person sender) {
        this.sender = sender;
    }
}
