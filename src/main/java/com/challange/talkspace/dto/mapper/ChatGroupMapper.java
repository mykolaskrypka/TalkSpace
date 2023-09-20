package com.challange.talkspace.dto.mapper;

import com.challange.talkspace.dto.request.ChatGroupRequestDto;
import com.challange.talkspace.dto.response.ChatGroupResponseDto;
import com.challange.talkspace.model.ChatGroup;
import org.springframework.stereotype.Component;

@Component
public class ChatGroupMapper implements ResponseDtoMapper<ChatGroupResponseDto, ChatGroup>,
        RequestDtoMapper<ChatGroupRequestDto, ChatGroup> {
    @Override
    public ChatGroupResponseDto mapToDto(ChatGroup chatGroup) {
        ChatGroupResponseDto responseDto = new ChatGroupResponseDto();
        responseDto.setId(chatGroup.getId());
        responseDto.setChatType(chatGroup.getChatType());
        responseDto.setName(chatGroup.getName());
        responseDto.setDescription(chatGroup.getDescription());
        responseDto.setPeople(chatGroup.getPeople());
        return responseDto;
    }

    @Override
    public ChatGroup mapToModel(ChatGroupRequestDto chatGroupRequestDto) {
        ChatGroup chatGroup = new ChatGroup();
        chatGroup.setChatType(chatGroupRequestDto.getChatType());
        chatGroup.setName(chatGroupRequestDto.getName());
        chatGroup.setDescription(chatGroupRequestDto.getDescription());
        chatGroup.setPeople(chatGroupRequestDto.getPeople());
        return chatGroup;
    }
}
