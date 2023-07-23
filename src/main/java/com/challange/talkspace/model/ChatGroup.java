package com.challange.talkspace.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Set;

@Data
@Entity
@Table(name = "chat_groups")
public class ChatGroup {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String description;
    @ManyToOne
    @JoinColumn(name = "chat_type_id")
    private ChatType chatType;
    @ManyToMany(mappedBy = "chatGroups")
    Set<User> users;

}
