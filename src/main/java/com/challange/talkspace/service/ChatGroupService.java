package com.challange.talkspace.service;

import com.challange.talkspace.model.ChatGroup;
import com.challange.talkspace.model.User;

import java.util.List;
import java.util.Optional;
import java.util.Set;

public interface ChatGroupService {
    ChatGroup add(ChatGroup chatGroup);

    ChatGroup get(Long id);

    List<ChatGroup> findAll();

    void deleteById(Long id);
    Optional<ChatGroup> findById(Long id);

    void addUserToChatGroup(Long chatId, Long userId);

    //Set<ChatGroup> findByUserId(long id);

    Set<ChatGroup> findByUser(User user);
}
