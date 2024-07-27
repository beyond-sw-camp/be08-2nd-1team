package com.beyond.kkwoborrow.notification.dto;

import com.beyond.kkwoborrow.notification.entity.Notifications;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.stream.Collectors;

@Getter
@Setter
@Schema(description = "Notification 응답 데이터 전송 객체")
public class NotificationResponseDto {
    @Schema(description = "문의사항 ID", example = "1")
    private Long notificationId;

    @Schema(description = "사용자 ID", example = "1")
    private Long userId;

    public NotificationResponseDto(Notifications notification) {
        this.notificationId = notification.getNotificationId();
        this.userId = notification.getUser().getUserId();
    }

    public static List<NotificationResponseDto> convert(List<Notifications> notification) {
        return notification.stream()
                .map(NotificationResponseDto::new)
                .collect(Collectors.toList());
    }
}
