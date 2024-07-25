package com.beyond.kkwoborrow.alarm.dto;

import com.beyond.kkwoborrow.alarm.entity.AlarmType;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class AlarmRequestDto {
    private String meetPlace;
    private LocalDateTime meetTime;
    private AlarmType alarmType;
    private Long transactionId;
    private Long reservationId;
}
