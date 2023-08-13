package com.challange.talkspace.controller;


import com.challange.talkspace.dto.request.ChatGroupRequestDto;
import com.challange.talkspace.dto.response.ChatGroupResponseDto;
import com.challange.talkspace.dto.response.UserResponseDto;
import com.challange.talkspace.model.ChatGroup;
import com.challange.talkspace.model.User;
import com.challange.talkspace.service.ChatGroupService;
import com.challange.talkspace.service.UserService;
import com.challange.talkspace.service.mapper.RequestDtoMapper;
import com.challange.talkspace.service.mapper.ResponseDtoMapper;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/chat-groups")
public class ChatGroupController {
    private final ChatGroupService chatGroupService;
    private final ResponseDtoMapper<ChatGroupResponseDto, ChatGroup> chatGroupResponseDtoMapper;
    private final RequestDtoMapper<ChatGroupRequestDto, ChatGroup> chatGroupRequestDtoMapper;

    public ChatGroupController(ChatGroupService chatGroupService,
                               ResponseDtoMapper<ChatGroupResponseDto, ChatGroup> chatGroupResponseDtoMapper,
                               RequestDtoMapper<ChatGroupRequestDto, ChatGroup> chatGroupRequestDtoMapper) {
        this.chatGroupService = chatGroupService;
        this.chatGroupResponseDtoMapper = chatGroupResponseDtoMapper;
        this.chatGroupRequestDtoMapper = chatGroupRequestDtoMapper;
    }

    @PostMapping("/add")
    public ChatGroupResponseDto add(@RequestBody ChatGroupRequestDto chatGroupRequestDto) {
        ChatGroup chatGroup = chatGroupRequestDtoMapper.mapToModel(chatGroupRequestDto);
        chatGroupService.add(chatGroup);
        return chatGroupResponseDtoMapper.mapToDto(chatGroup);
    }

}
