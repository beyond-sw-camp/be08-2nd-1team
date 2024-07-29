package com.beyond.kkwoborrow.alarm.dto;

import com.beyond.kkwoborrow.alarm.entity.Alarm;
import com.beyond.kkwoborrow.alarm.entity.AlarmType;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class AlarmResponseDto {
    private Long alarmId;
    private String meetPlace;
    private LocalDateTime meetTime;
    private AlarmType alarmType;
    private Long transactionId;
    private Long reservationId;

    public AlarmResponseDto(Alarm alarm) {
        this.alarmId = alarm.getAlarmId();
        this.meetPlace = alarm.getMeetPlace();
        this.meetTime = alarm.getMeetTime();
        this.alarmType = alarm.getAlarmType();
        if (alarm.getTransaction() != null) {
            this.transactionId = alarm.getTransaction().getTransactionID();
        }
        if (alarm.getReservation() != null) {
            this.reservationId = alarm.getReservation().getReserveID();
        }
    }
}
