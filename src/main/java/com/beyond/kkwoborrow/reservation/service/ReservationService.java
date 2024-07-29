package com.beyond.kkwoborrow.reservation.service;

import com.beyond.kkwoborrow.reservation.dto.ReservationRequestDto;
import com.beyond.kkwoborrow.reservation.dto.ReservationResponseDto;

import java.util.List;

public interface ReservationService {
    ReservationResponseDto save(ReservationRequestDto reservationRequestDto);
    ReservationResponseDto getReservation(Long reserveId);
    List<ReservationResponseDto> getAllReservations(int page, int numOfRows, int totalCount);
    int getTotalCount();
    void deleteReservation(Long reserveId);
}
