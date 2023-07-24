package com.challange.talkspace.repository;

import com.challange.talkspace.dto.request.UserRequestDto;
import com.challange.talkspace.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    User findUserByLogin(String login);
}
