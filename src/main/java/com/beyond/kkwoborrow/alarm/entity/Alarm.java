package com.beyond.kkwoborrow.alarm.entity;

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
    @Column(name = "AlarmID")
    private long alarmId;

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