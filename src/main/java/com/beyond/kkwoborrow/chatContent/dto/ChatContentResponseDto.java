package com.beyond.kkwoborrow.chatContent.dto;

import com.beyond.kkwoborrow.chatContent.entity.ChatContent;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@Schema(description = "채팅 내용 응답 데이터 전송 객체")
public class ChatContentResponseDto {
    @Schema(description = "채팅 내용 ID", example = "1")
    private Long contentId;

    @Schema(description = "채팅 내용의 세부사항", example = "테스트 채팅 내용입니다.")
    private String detail;

    @Schema(description = "채팅을 보낸 시간", example = "2024-07-27T10:15:30")
    private LocalDateTime sendTime;

    @Schema(description = "채팅을 보낸 사용자 ID", example = "1")
    private Long userId;

    @Schema(description = "채팅과 관련된 채팅 목록 ID", example = "1")
    private Long chatId;

    @Schema(description = "채팅과 관련된 알림 ID", example = "1")
    private Long notificationId;

    public ChatContentResponseDto(ChatContent content) {
        this.contentId = content.getChatContentId();
        this.detail = content.getDetail();
        this.sendTime = content.getSendTime();
        this.userId = content.getUser().getUserId();
        if(content.getChatList() != null) {
            this.chatId = content.getChatList().getChatId();
        }
        else {
            this.chatId = null;
        }

        if(content.getNotification() != null) {
            this.notificationId = content.getNotification().getNotificationId();
        }
        else {
            this.notificationId = null;
        }
    }
}
