package com.beyond.kkwoborrow.chatList.entity;

import jakarta.annotation.Nonnull;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class ChatList {
    @Id
    @Column(name = "ChatID")
    private int chatId;

    @Nonnull
    @Column(name = "UserID")
    private int userId;
}