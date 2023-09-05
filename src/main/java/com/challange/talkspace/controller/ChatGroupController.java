package com.challange.talkspace.controller;

import com.challange.talkspace.model.ChatGroup;
import com.challange.talkspace.repository.ChatGroupRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@RestController
@RequestMapping("/chat-groups")
public class ChatGroupController {

    private final ChatGroupRepository chatGroupRepository;
    @Autowired
    public ChatGroupController(ChatGroupRepository chatGroupRepository) {
        this.chatGroupRepository = chatGroupRepository;
    }

    @GetMapping("/")
    public List<ChatGroup> getAll() {
        return StreamSupport.stream(chatGroupRepository.findAll().spliterator(), false)
                .collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ChatGroup> getById(@PathVariable("id") long id) {
        var message = chatGroupRepository.findById(id);

        return new ResponseEntity<>(
                message.orElse(new ChatGroup()),
                message.isPresent() ? HttpStatus.OK : HttpStatus.NOT_FOUND);
    }

    @PostMapping("/")
    public ResponseEntity<ChatGroup> create(@RequestBody ChatGroup chatGroup) {
        return new ResponseEntity<>(
                chatGroupRepository.save(chatGroup),
                HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> update(@PathVariable("id") long id, @RequestBody ChatGroup chatGroup) {
        if (chatGroup.getId() != id) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        if (!chatGroupRepository.existsById(id)) {
            chatGroupRepository.save(chatGroup);
            return new ResponseEntity<>(HttpStatus.CREATED);
        }
       chatGroupRepository.save(chatGroup);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") long id) {
        chatGroupRepository.deleteById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
