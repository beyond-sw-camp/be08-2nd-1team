package com.beyond.kkwoborrow.chatContent.entity;

import com.beyond.kkwoborrow.chatList.entity.ChatList;
import com.beyond.kkwoborrow.notification.entity.Notifications;
import com.beyond.kkwoborrow.users.entity.Users;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Entity
@Schema(description = "ChatContent Entity")
public class ChatContent {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "content_id")
    @Schema(description = "채팅/문의사항 내용 ID", example = "1")
    private long chatContentId;

    @NotNull
    @Column(name = "detail")
    @Schema(description = "채팅/문의사항 내용의 세부사항", example = "테스트 채팅/문의사항 내용입니다.")
    private String detail;

    @NotNull
    @Column(name = "send_time")
    @Schema(description = "채팅/문의사항을 보낸 시간", example = "2024-07-27T10:15:30")
    private LocalDateTime sendTime;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "user_id")
    @Schema(description = "채팅/문의사항을 보낸 사용자", implementation = Users.class)
    private Users user;

    @ManyToOne
    @JoinColumn(name = "chat_id")
    @Schema(description = "채팅 내용과 관련된 채팅 목록", implementation = ChatList.class)
    private ChatList chatList;

    @ManyToOne
    @JoinColumn(name = "notification_id")
    @Schema(description = "문의사항 내용과 관련된 문의사항 목록", implementation = Notifications.class)
    private Notifications notification;
}