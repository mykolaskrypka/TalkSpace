package com.challange.talkspace.model.service;

import com.challange.talkspace.model.ChatGroup;
import com.challange.talkspace.model.Person;
import java.util.Set;

public interface ChatGroupService {
    ChatGroup add(ChatGroup chatGroup);

    ChatGroup get(Long id);

//    Set<ChatGroup> findByUser(Person person);

}
