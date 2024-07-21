package com.beyond.kkwoborrow.alarm.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.*;

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

    @NonNull
    @Column(name = "AlarmType")
    private AlarmType alarmType;

    @Column(name = "RentalID")
    private Integer rentalId;

    @NonNull
    @Column(name = "ReservationID")
    private int reservationId;
}