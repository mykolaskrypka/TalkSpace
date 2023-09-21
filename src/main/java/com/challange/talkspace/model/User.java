package com.challange.talkspace.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.Set;

@Data
@Entity
@Table(name = "users")
@Getter
@Setter
//@EqualsAndHashCode(of = ("id"))
public class User {

    @EqualsAndHashCode.Exclude
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String login;
    @Column(unique = true, nullable = false)
    private String userName;
    @Column
    private String password;

    /*@ManyToOne
    @JoinColumn(name = "role_id")
    private Role role;
*/

//    @OneToMany(mappedBy = "sender")
//    private List <Message> senderMessage = new ArrayList<>();
//
//    @OneToMany(mappedBy = "receiver")
//    private List<Message> receiverMessage = new ArrayList<>();

    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    @ManyToMany(mappedBy = "people", cascade = CascadeType.MERGE)
    private Set<ChatGroup> chatGroups;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "users_roles",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id"))
    private Set<Role> roles;

    public static User of(String userName, String password, Role role) {
        User user = new User();
        user.userName = userName;
        user.password = password;
        user.roles = Set.of(role);
        return user;
    }
}
