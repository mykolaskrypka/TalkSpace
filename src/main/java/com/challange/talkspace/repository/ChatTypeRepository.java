package com.challange.talkspace.repository;

import com.challange.talkspace.model.ChatType;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ChatTypeRepository extends JpaRepository<ChatType, Long> {
    ChatType findByChatTypeName(String chatTypeName);
}
