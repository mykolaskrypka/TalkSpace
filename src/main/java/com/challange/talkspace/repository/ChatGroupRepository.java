package com.challange.talkspace.repository;

import com.challange.talkspace.model.ChatGroup;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ChatGroupRepository extends JpaRepository<ChatGroup, Long> {
//    Set<ChatGroup> findChatGroupsByUsersContains(Person person);
}
