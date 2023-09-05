package com.challange.talkspace.model.service.impl;

import com.challange.talkspace.model.ChatType;
import com.challange.talkspace.model.service.ChatTypeService;
import com.challange.talkspace.repository.ChatTypeRepository;

import org.springframework.stereotype.Service;

@Service
public class ChatTypeServiceImpl implements ChatTypeService {
    private final ChatTypeRepository chatTypeRepository;

    public ChatTypeServiceImpl(ChatTypeRepository chatTypeRepository) {
        this.chatTypeRepository = chatTypeRepository;
    }

    @Override
    public ChatType add(ChatType chatType) {
        return chatTypeRepository.save(chatType);
    }

    @Override
    public ChatType getByName(String chatTypeName) {
        return chatTypeRepository.findByChatTypeName(ChatType.ChatTypeName.valueOf(chatTypeName).toString());
    }
}
