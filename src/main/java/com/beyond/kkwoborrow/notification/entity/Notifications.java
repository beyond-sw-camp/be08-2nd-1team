package com.beyond.kkwoborrow.notification.entity;

import com.beyond.kkwoborrow.users.entity.Users;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Notifications {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "NotificationID")
    private long notificationId;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "UserID")
    private Users userId;
}