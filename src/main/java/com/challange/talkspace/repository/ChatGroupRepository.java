package com.challange.talkspace.repository;

import com.challange.talkspace.model.ChatGroup;
import com.challange.talkspace.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.relational.core.sql.Select;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.Set;

public interface ChatGroupRepository extends JpaRepository<ChatGroup, Long> {

    Set<ChatGroup> findChatGroupsByPeopleContains(User user);
    Optional<ChatGroup> findById(Long id);

    @Transactional
    @Modifying
    @Query(value = "INSERT INTO chat_gruup_people (chat_group_id, user_id) " +
            "VALUES (:chat_group_id, :user_id)", nativeQuery = true)
    void addUserToChatGroup(@Param("chat_group_id") Long chat_group_id,
                            @Param("user_id") Long user_id);

//    @Query("SELECT * FROM ChatGroup cg WHERE cg.people.u.id = (:userId)")
//    Set<ChatGroup> findByUserId(long userId);
}
