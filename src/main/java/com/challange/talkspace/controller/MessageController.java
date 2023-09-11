package com.challange.talkspace.controller;

import com.challange.talkspace.model.ChatNotificaton;
import com.challange.talkspace.model.Message;
import com.challange.talkspace.model.service.ChatRoomService;
import com.challange.talkspace.model.service.MessageService;
import com.challange.talkspace.repository.MessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessageHeaderAccessor;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@RestController
@RequestMapping("/messages")
public class MessageController {


    private SimpMessagingTemplate messagingTemplate;

    private MessageService chatMessageService;

     private ChatRoomService chatRoomService;

    @MessageMapping("/chat")
    public void processMessage(@Payload Message message) {
        var chatId = chatRoomService
                .getChatId(message.getSenderId(), message.getRecipientId(), true);
        message.setChatId(chatId.get());

        Message saved = chatMessageService.save(message);

        messagingTemplate.convertAndSendToUser(
                String.valueOf(message.getRecipient()),"/queue/messages",
                new ChatNotificaton(
                        saved.getId(),
                        saved.getSenderId(),
                        saved.getSender()));
    }

    @MessageMapping("/chat.sendMessage")
    @SendTo("/topic/public")
    public Message sendMessage(@Payload Message message) {
        return message;
    }

    @MessageMapping("/chat.addUser")
    @SendTo("/topic/public")
    public Message addUser(@Payload Message message,
                               SimpMessageHeaderAccessor headerAccessor) {
        // Add username in web socket session
        headerAccessor.getSessionAttributes().put("username", message.getSender());
        return message;
    }

    //что все сообщения от клиентов, направленные по адресу,
    // начинающемуся с /app, будут перенаправлены в соответствующие методы.
    // Имелись в виду как раз методы, аннотированные @MessageMapping.
    //
    //Например, сообщение, направленное по адресу /app/chat.sendMessage будет перенаправлено
    // в метод sendMessage(). А например, сообщение, направленное по адресу/app/chat.addUser
    // будет перенаправлено в метод addUser().

//    @Autowired
//    public MessageController(MessageRepository repository) {
//        this.messageRepository = repository;
//    }
//
//    @GetMapping("/")
//    public List<Message> getAll() {
//        return StreamSupport.stream(messageRepository.findAll().spliterator(), false)
//                .collect(Collectors.toList());
//    }
//
//    @GetMapping("/{id}")
//    public ResponseEntity<Message> getById(@PathVariable("id") long id) {
//        var message = messageRepository.findById(id);
//
//        return new ResponseEntity<>(
//                message.orElse(new Message()),
//                message.isPresent() ? HttpStatus.OK : HttpStatus.NOT_FOUND);
//    }
//
//    @PostMapping("/")
//    public ResponseEntity<Message> create(@RequestBody Message message) {
//        return new ResponseEntity<>(
//                messageRepository.save(message),
//                HttpStatus.CREATED);
//    }
//
//    @PutMapping("/{id}")
//    public ResponseEntity<Void> update(@PathVariable("id") long id, @RequestBody Message message) {
//        if (message.getId() != id) {
//            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
//        }
//        if (!messageRepository.existsById(id)) {
//            messageRepository.save(message);
//            return new ResponseEntity<>(HttpStatus.CREATED);
//        }
//        messageRepository.save(message);
//        return new ResponseEntity<>(HttpStatus.OK);
//    }
//
//    @DeleteMapping("/{id}")
//    public ResponseEntity<Void> delete(@PathVariable("id") long id) {
//        messageRepository.deleteById(id);
//        return new ResponseEntity<>(HttpStatus.OK);
//    }
}
