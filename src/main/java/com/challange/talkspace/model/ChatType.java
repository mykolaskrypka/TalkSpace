package com.challange.talkspace.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.util.Objects;

@Data
@Entity
@EqualsAndHashCode
@Getter
@Setter
@Table(name = "chat_types")
public class ChatType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Enumerated(value = EnumType.STRING)
    private ChatTypeName chatTypeName;

    public ChatType(ChatTypeName typeName) {
        this.chatTypeName = typeName;
    }

    public ChatType() {
    }


    public enum ChatTypeName {
        GROUP,
        PRIVATE
    }
}
