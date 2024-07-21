package com.beyond.kkwoborrow.chatList.entity;

import com.beyond.kkwoborrow.users.entity.Users;
import jakarta.annotation.Nonnull;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class ChatList {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ChatID")
    private long chatId;

    @Nonnull
    @ManyToOne
    @JoinColumn(name = "UserID")
    @Column(name = "UserID")
    private Users userId;
}