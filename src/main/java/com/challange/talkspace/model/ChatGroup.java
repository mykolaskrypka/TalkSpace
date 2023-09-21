package com.challange.talkspace.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.Set;

@Data
@Entity
@EqualsAndHashCode(of = {"id","people"})
@Getter
@Setter
@Table(name = "chat_group")
public class ChatGroup {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String description;

//    @ManyToOne
//    @JoinColumn(name = "user_id")
//    private User user;

    @ToString.Exclude
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "chat_type_id")
    private ChatType chatType;

    @ToString.Exclude
    @ManyToMany(cascade = CascadeType.MERGE)
    @JoinTable(name = "chat_gruup_people",
            joinColumns = @JoinColumn(name="chat_group_id"),
            inverseJoinColumns = @JoinColumn(name="user_id"))
    Set<User> people;

}
