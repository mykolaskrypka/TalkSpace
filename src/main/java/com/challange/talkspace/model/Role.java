package com.challange.talkspace.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.util.Objects;

@Data
@Entity
@Table(name = "role")
@Getter
@Setter
@EqualsAndHashCode(of = ("id"))
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Enumerated(value = EnumType.STRING)
    @Column(unique = true, nullable = false)
    private RoleName roleName;

    public Role(RoleName roleName) {
        this.roleName = roleName;
    }

    public Role() {
    }

    public enum RoleName {
        ADMIN,
        USER
    }
}
