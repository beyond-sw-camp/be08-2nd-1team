package com.beyond.kkwoborrow.notification.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;

@Getter
@Schema(description = "Notification 요청 데이터 전송 객체")
public class NotificationRequestDto {
    @Schema(description = "사용자 ID", example = "1", required = true)
    private Long userId;
}
