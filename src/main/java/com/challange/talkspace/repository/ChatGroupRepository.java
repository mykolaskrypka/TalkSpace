package com.challange.talkspace.repository;

import com.challange.talkspace.model.ChatGroup;
import com.challange.talkspace.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Set;

public interface ChatGroupRepository extends JpaRepository<ChatGroup, Long> {
    Set<ChatGroup> findChatGroupsByUsersContains(User user);

    List<ChatGroup> findAll();
}
