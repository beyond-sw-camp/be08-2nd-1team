package com.beyond.kkwoborrow.alarm.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Entity
public class Alarm {
    @Id
    @Column(name = "AlarmID")
    private int alarmId;

    @Column(name = "MeetPlace")
    private String meetPlace;

    @Column(name = "MeetTime")
    private LocalDateTime meetTime;

    @NotNull
    @Column(name = "AlarmType")
    private AlarmType alarmType;

    @Column(name = "RentalID")
    private Integer rentalId;

    @NotNull
    @Column(name = "ReservationID")
    private int reservationId;
}