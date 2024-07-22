package com.beyond.kkwoborrow.content.entity;

import com.beyond.kkwoborrow.chatList.entity.ChatList;
import com.beyond.kkwoborrow.notification.entity.Notifications;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
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

    @NotNull
    @Column(name = "Detail")
    private String detail;

    @NotNull
    @Column(name = "SendTime")
    private LocalDateTime sendTime;

    @NotNull
    @Column(name = "UserType")
    private UserType userType;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "ChatID")
    @Column(name = "ChatID")
    private ChatList chatId;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "NotificationID")
    @Column(name = "NotificationID")
    private Notifications notificationId;

}