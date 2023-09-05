package com.challange.talkspace.model.service.impl;

import com.challange.talkspace.model.ChatGroup;
import com.challange.talkspace.model.Person;
import com.challange.talkspace.model.service.ChatGroupService;
import com.challange.talkspace.repository.ChatGroupRepository;

import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class ChatGroupServiceImpl implements ChatGroupService {
    private final ChatGroupRepository chatGroupRepository;

    public ChatGroupServiceImpl(ChatGroupRepository chatGroupRepository) {
        this.chatGroupRepository = chatGroupRepository;
    }

    @Override
    public ChatGroup add(ChatGroup chatGroup) {
        return chatGroupRepository.save(chatGroup);
    }

    @Override
    public ChatGroup get(Long id) {
        return chatGroupRepository.findById(id).orElseThrow(
                () -> new RuntimeException("Chat group with id " + id + " not found"));
    }

//    @Override
//    public Set<ChatGroup> findByUser(Person person) {
//        return chatGroupRepository.findChatGroupsByUsersContains(person);
//    }
}
