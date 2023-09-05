package com.challange.talkspace.repository;

import com.challange.talkspace.model.Message;

import org.springframework.data.jpa.repository.JpaRepository;

public interface MessageRepository   extends JpaRepository<Message, Long> {
}
