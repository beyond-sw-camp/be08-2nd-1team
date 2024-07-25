package com.beyond.kkwoborrow.notification.entity;

import com.beyond.kkwoborrow.users.entity.Users;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
@Entity
public class Notifications {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "NotificationID")
    private long notificationId;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "UserID")
    private Users user;
}