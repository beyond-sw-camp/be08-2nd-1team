package com.beyond.kkwoborrow.chatList.entity;

import com.beyond.kkwoborrow.chatList.dto.ChatListRequestDto;
import com.beyond.kkwoborrow.users.entity.Users;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
@Schema(description = "ChatList Entity")
public class ChatList {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ChatID")
    @Schema(description = "채팅 ID", example = "1")
    private long chatId;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "UserID")
    @Schema(description = "사용자 정보", required = true)
    private Users user;

    public ChatList(Users user) {
        this.user = user;
    }
}