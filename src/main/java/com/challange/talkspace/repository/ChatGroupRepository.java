package com.challange.talkspace.repository;

import com.challange.talkspace.model.ChatGroup;
import com.challange.talkspace.model.Person;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Set;

public interface ChatGroupRepository extends JpaRepository<ChatGroup, Long> {
//    Set<ChatGroup> findChatGroupsByUsersContains(Person person);
}
