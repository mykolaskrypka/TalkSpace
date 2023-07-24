package com.challange.talkspace.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Objects;

@Data
@Entity
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

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        ChatType chatType = (ChatType) o;
        return id.equals(chatType.id) && chatTypeName == chatType.chatTypeName;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, chatTypeName);
    }

    public enum ChatTypeName {
        GROUP,
        PRIVATE
    }
}
