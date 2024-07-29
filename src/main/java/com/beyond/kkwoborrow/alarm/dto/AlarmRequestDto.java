package com.beyond.kkwoborrow.alarm.dto;

import com.beyond.kkwoborrow.alarm.entity.AlarmType;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
@Builder
public class AlarmRequestDto {
    @Schema(description = "Meeting place", example = "seoul")
    private String meetPlace;

    @Schema(description = "Meeting time", example = "2024-11-29T03:07:41.125")
    private LocalDateTime meetTime;

    @Schema(description = "Type of alarm", example = "Reservation")
    private AlarmType alarmType;

    @Schema(description = "Transaction ID", example = "0")
    private Long transactionId;

    @Schema(description = "Reservation ID", example = "1")
    private Long reservationId;
}
