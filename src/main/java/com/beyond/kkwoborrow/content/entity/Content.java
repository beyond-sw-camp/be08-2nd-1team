package com.beyond.kkwoborrow.content.entity;

import jakarta.annotation.Nonnull;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Content {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ContentID")
    private int contentId;

    @Nonnull
    @Column(name = "Detail")
    private String detail;

    @Nonnull
    @Column(name = "SendTime")
    private LocalDateTime sendTime;

    @Nonnull
    @Column(name = "UserType")
    private UserType userType;

    @Nonnull
    @Column(name = "ChatID")
    private int chatId;

    @Nonnull
    @Column(name = "NotificationID")
    private int notificationId;

}