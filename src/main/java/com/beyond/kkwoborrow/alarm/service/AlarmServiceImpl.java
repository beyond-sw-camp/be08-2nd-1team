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
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

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
        Rental transaction = rentalRepository.findById(alarmRequestDto.getTransactionId()).orElse(null);
        Reservation reservation = reservationRepository.findById(alarmRequestDto.getReservationId()).orElse(null);

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
        Optional<Alarm> alarm = alarmRepository.findById(alarmId);
        if (alarm.isPresent()) {
            alarmRepository.deleteById(alarmId);
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Alarm not found");
        }
    }

    @Override
    public AlarmResponseDto updateAlarm(Long alarmId, AlarmRequestDto alarmRequestDto) {
        Optional<Alarm> updateAlarm = alarmRepository.findById(alarmId);
        if (updateAlarm.isPresent()) {
            Rental transaction = rentalRepository.findById(alarmRequestDto.getTransactionId()).orElse(null);
            Reservation reservation = reservationRepository.findById(alarmRequestDto.getReservationId()).orElse(null);

            Alarm alarm = updateAlarm.get();
            alarm.setAlarmRequestDto(alarmRequestDto, transaction, reservation);
            alarmRepository.save(alarm);
            return new AlarmResponseDto(alarm);
        }
        return null;
    }

    @Override
    public List<AlarmResponseDto> getAlarms(int page, int numOfRows, int totalCount) {
        PageRequest pageRequest = PageRequest.of(page - 1, numOfRows);
        Page<Alarm> alarmPage = alarmRepository.findAll(pageRequest);
        List<Alarm> alarms = alarmPage.getContent();
        return alarms.stream().map(AlarmResponseDto::new).collect(Collectors.toList());
    }

    @Override
    public int getTotalCount() {
        return (int) alarmRepository.count();
    }
}
