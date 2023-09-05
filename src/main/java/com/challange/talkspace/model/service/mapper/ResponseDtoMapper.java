package com.challange.talkspace.model.service.mapper;

public interface ResponseDtoMapper<D, T> {
    D mapToDto(T t);
}
