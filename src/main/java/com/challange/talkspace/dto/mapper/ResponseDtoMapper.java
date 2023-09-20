package com.challange.talkspace.dto.mapper;

public interface ResponseDtoMapper<D, T> {
    D mapToDto(T t);
}
