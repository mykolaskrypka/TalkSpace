package com.challange.talkspace.model.service.mapper;

public interface RequestDtoMapper<D, T> {
    T mapToModel(D dto);
}
