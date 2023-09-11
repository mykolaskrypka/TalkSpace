package com.challange.talkspace.model.service;

import com.challange.talkspace.exception.ResourceNotFoundException;
import com.challange.talkspace.model.Message;
import com.challange.talkspace.model.MessageStatus;
import com.challange.talkspace.repository.MessageRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
public class MessageService {

    private MessageRepository repository;
    private ChatRoomService chatRoomService;


    public Message save(Message message) {
        message.setStatus(MessageStatus.RECEIVED);
        repository.save(message);
        return message;
    }

    public long countNewMessages(Long senderId, Long recipientId) {
        return repository.countBySenderIdAndRecipientIdAndStatus(
                senderId, recipientId, MessageStatus.RECEIVED);
    }

    public List<Message> findChatMessages(Long senderId, Long recipientId) {
        var chatId = chatRoomService.getChatId(senderId, recipientId, false);

        var messages =
                chatId.map(cId -> repository.findByChatId(cId)).orElse(new ArrayList<>());

        if (messages.size() > 0) {
            updateStatuses(senderId, recipientId, MessageStatus.DELIVERED);
        }

        return messages;
    }

    public Message findById(Long id) {
        return repository
                .findById(id)
                .map(message -> {
                    message.setStatus(MessageStatus.DELIVERED);
                    return repository.save(message);
                })
                .orElseThrow(() ->
                        new ResourceNotFoundException("can't find message (" + id + ")"));
    }

    @Modifying
    @Transactional
    @Query("UPDATE Message  set status = RECEIVED")
    public void updateStatuses(Long senderId, Long recipientId, MessageStatus status) {

    }

}
