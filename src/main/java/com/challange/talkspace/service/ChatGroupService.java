package com.challange.talkspace.service;

import com.challange.talkspace.model.ChatGroup;
import com.challange.talkspace.model.User;
import java.util.Set;

public interface ChatGroupService {
    ChatGroup add(ChatGroup chatGroup);

    ChatGroup get(Long id);

    Set<ChatGroup> findByUser(User user);

}
