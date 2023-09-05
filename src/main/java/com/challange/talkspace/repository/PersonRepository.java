package com.challange.talkspace.repository;


import com.challange.talkspace.model.Person;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonRepository extends JpaRepository<Person, Long> {

    Person findByUserName(String nickName);
}
