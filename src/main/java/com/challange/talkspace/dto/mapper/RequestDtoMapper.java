package com.challange.talkspace.dto.mapper;

public interface RequestDtoMapper<D, T> {
    T mapToModel(D dto);
}
