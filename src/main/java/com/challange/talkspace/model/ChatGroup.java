package com.challange.talkspace.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Data
@Entity
@EqualsAndHashCode(of = {"id"})
@Getter
@Setter
@Table(name = "chat_group")
public class ChatGroup {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String description;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne
    @JoinColumn(name = "chat_type_id")
    private ChatType chatType;

    @ManyToMany(mappedBy = "chatGroups")
    Set<User> people;

}
