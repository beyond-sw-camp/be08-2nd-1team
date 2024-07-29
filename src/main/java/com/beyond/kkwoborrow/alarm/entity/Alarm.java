package com.beyond.kkwoborrow.alarm.entity;

import com.beyond.kkwoborrow.alarm.dto.AlarmRequestDto;
import com.beyond.kkwoborrow.rental.entity.Rental;
import com.beyond.kkwoborrow.reservation.entity.Reservation;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Alarm {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "alarm_id")
    private long alarmId;

    @Column(name = "meet_place")
    private String meetPlace;

    @Column(name = "meet_time")
    private LocalDateTime meetTime;

    @NotNull
    @Enumerated(EnumType.STRING)
    @Column(name = "alarm_type")
    private AlarmType alarmType;

    @ManyToOne
    @JoinColumn(name = "transaction_id")
    private Rental transaction;

    @ManyToOne
    @JoinColumn(name = "reserve_id")
    private Reservation reservation;

    public Alarm(AlarmRequestDto alarmRequestDto, Rental transaction, Reservation reservation) {
        this.meetPlace = alarmRequestDto.getMeetPlace();
        this.meetTime = alarmRequestDto.getMeetTime();
        this.alarmType = alarmRequestDto.getAlarmType();
        this.transaction = transaction;
        this.reservation = reservation;
    }

    public void setAlarmRequestDto(AlarmRequestDto alarmRequestDto, Rental transaction, Reservation reservation) {
        this.meetPlace = alarmRequestDto.getMeetPlace();
        this.meetTime = alarmRequestDto.getMeetTime();
        this.alarmType = alarmRequestDto.getAlarmType();
        this.transaction = transaction;
        this.reservation = reservation;
    }
}
