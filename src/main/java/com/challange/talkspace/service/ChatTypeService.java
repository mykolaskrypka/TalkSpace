package com.challange.talkspace.service;

import com.challange.talkspace.model.ChatType;

public interface ChatTypeService {
    ChatType add(ChatType chatType);

    ChatType getByName(String chatTypeName);
}
