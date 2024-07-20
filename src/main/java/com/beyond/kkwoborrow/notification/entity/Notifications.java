package com.beyond.kkwoborrow.notification.entity;

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
public class Notifications {
    @Id
    @Column(name = "NotificationID")
    private int notificationId;

    @Nonnull
    private int userId;
}
