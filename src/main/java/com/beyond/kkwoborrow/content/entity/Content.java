package com.beyond.kkwoborrow.content.entity;

import com.beyond.kkwoborrow.chatList.entity.ChatList;
import com.beyond.kkwoborrow.notification.entity.Notifications;
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
    private long contentId;

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
    @ManyToOne
    @JoinColumn(name = "ChatID")
    @Column(name = "ChatID")
    private ChatList chatId;

    @Nonnull
    @ManyToOne
    @JoinColumn(name = "NotificationID")
    @Column(name = "NotificationID")
    private Notifications notificationId;

}