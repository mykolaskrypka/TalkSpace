package com.challange.talkspace.service;

import com.challange.talkspace.model.ChatGroup;

public interface ChatGroupService {
    ChatGroup add(ChatGroup chatGroup);

    ChatGroup get(Long id);

//    Set<ChatGroup> findByUser(Person person);

}
