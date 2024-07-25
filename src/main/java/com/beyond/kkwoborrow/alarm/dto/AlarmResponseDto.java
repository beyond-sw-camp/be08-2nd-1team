package com.beyond.kkwoborrow.alarm.dto;

import com.beyond.kkwoborrow.alarm.entity.Alarm;
import com.beyond.kkwoborrow.alarm.entity.AlarmType;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Setter
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
        this.transactionId = alarm.getTransaction().getTransactionID();
        this.reservationId = alarm.getReservation().getReserveID();
    }
}
