package com.challange.talkspace.service.mapper;

public interface RequestDtoMapper<D, T> {
    T mapToModel(D dto);
}
