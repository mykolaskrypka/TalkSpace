package com.challange.talkspace.model;

import jakarta.persistence.*;
import lombok.*;

@Data
@Entity
@EqualsAndHashCode(of = {"id"})
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "chatRoom")
public class ChatRoom {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String chatId;

    private Long senderId;

    private Long recipientId;
}


//Значение chatId равно конкатенации senderId_recipientId.
// Для каждой беседы мы сохраняем две сущности с одинаковыми chatId:
// одну между отправителем и получателем, а другую между получателем и отправителем,
// чтобы оба пользователя получали одинаковый chatId.