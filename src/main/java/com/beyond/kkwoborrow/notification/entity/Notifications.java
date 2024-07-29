package com.beyond.kkwoborrow.notification.entity;

import com.beyond.kkwoborrow.users.entity.Users;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
@Schema(description = "Notification Entity")
public class Notifications {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "notification_id")
    @Schema(description = "문의사항 ID", example = "1")
    private long notificationId;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "user_id")
    @Schema(description = "Users Entity", implementation = Users.class)
    private Users user;

    public Notifications(Users user) {
        this.user = user;
    }
}