package com.challange.talkspace.repository;

import com.challange.talkspace.model.Message;

import com.challange.talkspace.model.MessageStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface MessageRepository   extends JpaRepository<Message, Long> {
    long countBySenderIdAndRecipientIdAndStatus(
            Long senderId, Long recipientId, MessageStatus status);

    List<Message> findByChatId(String chatId);

    @Transactional (readOnly = true)
    @Query(nativeQuery = true, value = "select * from message m where m.sender_id=:id")
    List<Message> findMySuperPostsNative( long id);
    //List<Message> findAllByStatusTrue();
    @Query(value = "SELECT * FROM message WHERE id > :id", nativeQuery = true)
    List<Message> getUnreadById(@Param("id") long id);

    @Query(value = "DELETE  FROM message", nativeQuery = true)
    void clearBase();

}
