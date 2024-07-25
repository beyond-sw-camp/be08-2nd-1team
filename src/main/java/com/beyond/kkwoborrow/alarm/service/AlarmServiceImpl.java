package com.beyond.kkwoborrow.alarm.service;

import com.beyond.kkwoborrow.alarm.dto.AlarmRequestDto;
import com.beyond.kkwoborrow.alarm.dto.AlarmResponseDto;
import com.beyond.kkwoborrow.alarm.entity.Alarm;
import com.beyond.kkwoborrow.alarm.repository.AlarmRepository;
import com.beyond.kkwoborrow.rental.entity.Rental;
import com.beyond.kkwoborrow.rental.repository.RentalRepository;
import com.beyond.kkwoborrow.reservation.entity.Reservation;
import com.beyond.kkwoborrow.reservation.repository.ReservationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AlarmServiceImpl implements AlarmService {
    @Autowired
    private AlarmRepository alarmRepository;

    @Autowired
    private RentalRepository rentalRepository;

    @Autowired
    private ReservationRepository reservationRepository;

    @Override
    public AlarmResponseDto save(AlarmRequestDto alarmRequestDto) {
        Rental transaction = rentalRepository.findById(alarmRequestDto.getTransactionId()).orElseThrow(() -> new IllegalArgumentException("Invalid transaction ID"));
        Reservation reservation = reservationRepository.findById(alarmRequestDto.getReservationId()).orElseThrow(() -> new IllegalArgumentException("Invalid reservation ID"));

        Alarm newAlarm = new Alarm(alarmRequestDto, transaction, reservation);
        Alarm savedAlarm = alarmRepository.save(newAlarm);
        return new AlarmResponseDto(savedAlarm);
    }

    @Override
    public AlarmResponseDto getAlarm(Long alarmId) {
        Optional<Alarm> alarm = alarmRepository.findById(alarmId);
        return alarm.map(AlarmResponseDto::new).orElse(null);
    }

    @Override
    public void deleteAlarm(Long alarmId) {
        alarmRepository.deleteById(alarmId);
    }

    @Override
    public AlarmResponseDto updateAlarm(Long alarmId, AlarmRequestDto alarmRequestDto) {
        Optional<Alarm> updateAlarm = alarmRepository.findById(alarmId);
        if (updateAlarm.isPresent()) {
            Rental transaction = rentalRepository.findById(alarmRequestDto.getTransactionId()).orElseThrow(() -> new IllegalArgumentException("Invalid transaction ID"));
            Reservation reservation = reservationRepository.findById(alarmRequestDto.getReservationId()).orElseThrow(() -> new IllegalArgumentException("Invalid reservation ID"));

            Alarm alarm = updateAlarm.get();
            alarm.setAlarmRequestDto(alarmRequestDto, transaction, reservation);
            alarmRepository.save(alarm);
            return new AlarmResponseDto(alarm);
        }
        return null;
    }
}
