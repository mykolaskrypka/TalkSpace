package com.challange.talkspace.controller;

import com.challange.talkspace.dto.mapper.ChatGroupMapper;
import com.challange.talkspace.dto.response.ChatGroupResponseDto;
import com.challange.talkspace.model.ChatGroup;
import com.challange.talkspace.model.User;
import com.challange.talkspace.service.ChatGroupService;
import com.challange.talkspace.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@RestController
@RequiredArgsConstructor
@RequestMapping("/chat-groups")
public class ChatGroupController {

    private final ChatGroupService chatGroupService;
    private final ChatGroupMapper chatGroupMapper;
    private final UserService userService;

    @GetMapping("/")
    public List<ChatGroupResponseDto> getAll() {
        return chatGroupService.findAll()
                .stream()
                .map(g -> chatGroupMapper.mapToDtoWithoutPeople(g))
                .collect(Collectors.toList());
    }

    @GetMapping("/my")
    public ResponseEntity<List<ChatGroupResponseDto>> getAllMyGroups(Authentication auth) {
        Optional<User> byUserName = userService.findByUserName(auth.getName());
        if (byUserName.isEmpty()) {
            return new ResponseEntity<>(List.of(),
                    HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(chatGroupService.findByUser(byUserName.get())
                .stream()
                .map(g -> chatGroupMapper.mapToDtoWithoutPeople(g))
                .collect(Collectors.toList()), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ChatGroupResponseDto> getById(@PathVariable("id") long id) {
        Optional<ChatGroup> chatGroup = chatGroupService.findById(id);
        if (chatGroup.isEmpty()) {
            return new ResponseEntity<>(new ChatGroupResponseDto(), HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(
                chatGroupMapper.mapToDtoWithoutPeople(chatGroup.get()),
                chatGroup.isPresent() ? HttpStatus.OK : HttpStatus.NOT_FOUND);
    }

    @PostMapping("/{groupId}/join")
    public ResponseEntity<String> joinToChatGroup(Authentication auth,
                                                     @PathVariable("groupId") long groupId) {
        Optional<ChatGroup> optionalChatGroup  = chatGroupService.findById(groupId);
        if (optionalChatGroup.isEmpty()) {
            return new ResponseEntity<>("Group not found", HttpStatus.NOT_FOUND);
        }
        Optional<User> byUserName = userService.findByUserName(auth.getName());
        if (byUserName.isEmpty()) {
            return new ResponseEntity<>("User not found", HttpStatus.NOT_FOUND);
        }
        chatGroupService.addUserToChatGroup(groupId, byUserName.get().getId());
        return new ResponseEntity<>("successfully added", HttpStatus.OK);
    }

    @GetMapping("/by-user-id/{userId}")
    public ResponseEntity<Set<ChatGroupResponseDto>> getByUserId(@PathVariable("userId") long id) {
        User user = userService.get(id);
        Set<ChatGroupResponseDto> chatGroups =
                chatGroupService.findByUser(user)
                        .stream()
                        .map(g -> chatGroupMapper.mapToDtoWithoutPeople(g))
                        .collect(Collectors.toSet());

        return new ResponseEntity<>(
                chatGroups,
                !chatGroups.isEmpty() ? HttpStatus.OK : HttpStatus.NOT_FOUND);
    }

    @PostMapping("/")
    public ResponseEntity<ChatGroup> create(@RequestBody ChatGroup chatGroup) {
        return new ResponseEntity<>(
                chatGroupService.add(chatGroup),
                HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> update(@PathVariable("id") long id, @RequestBody ChatGroup chatGroup) {
        if (chatGroup.getId() != id) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        if (chatGroupService.findById(id).isEmpty()) {
            chatGroupService.add(chatGroup);
            return new ResponseEntity<>(HttpStatus.CREATED);
        }
        chatGroupService.add(chatGroup);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") long id) {
        chatGroupService.deleteById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
