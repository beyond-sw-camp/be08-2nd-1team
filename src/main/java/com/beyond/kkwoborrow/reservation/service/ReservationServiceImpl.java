package com.beyond.kkwoborrow.reservation.service;

import com.beyond.kkwoborrow.alarm.entity.Alarm;
import com.beyond.kkwoborrow.alarm.repository.AlarmRepository;
import com.beyond.kkwoborrow.posts.entity.Posts;
import com.beyond.kkwoborrow.posts.repository.PostRepository;
import com.beyond.kkwoborrow.reservation.dto.ReservationRequestDto;
import com.beyond.kkwoborrow.reservation.dto.ReservationResponseDto;
import com.beyond.kkwoborrow.reservation.entity.Reservation;
import com.beyond.kkwoborrow.reservation.repository.ReservationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ReservationServiceImpl implements ReservationService {

    @Autowired
    private ReservationRepository reservationRepository;

    @Autowired
    private PostRepository postRepository;

    @Autowired
    private AlarmRepository alarmRepository;

    @Override
    public ReservationResponseDto save(ReservationRequestDto reservationRequestDto) {
        Posts post = postRepository.findById(reservationRequestDto.getPostId())
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.BAD_REQUEST, "Invalid post ID"));

        Reservation reservation = new Reservation();
        reservation.setPostId(post);
        Reservation savedReservation = reservationRepository.save(reservation);

        return new ReservationResponseDto(savedReservation);
    }

    @Override
    public ReservationResponseDto getReservation(Long reserveId) {
        Reservation reservation = reservationRepository.findById(reserveId)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Reservation not found"));

        return new ReservationResponseDto(reservation);
    }

    @Override
    public List<ReservationResponseDto> getAllReservations(int page, int numOfRows, int totalCount) {
        if (page <= 0 || numOfRows <= 0) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Invalid pagination parameters");
        }

        Pageable pageable = PageRequest.of(page - 1, numOfRows, Sort.by("reserveId").ascending());
        List<Reservation> reservations = reservationRepository.findAll(pageable).getContent();

        return reservations.stream()
                .map(ReservationResponseDto::new)
                .collect(Collectors.toList());
    }

    @Override
    public int getTotalCount() {
        return (int) reservationRepository.count();
    }

    @Transactional
    @Override
    public void deleteReservation(Long reserveId) {
        // 예약이 존재하는지 확인
        Reservation reservation = reservationRepository.findById(reserveId)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Reservation not found"));

        try {
            // 예약에 연관된 알람을 조회
            List<Alarm> alarms = alarmRepository.findByReservation_ReserveId(reserveId);

            // 알람 삭제
            for (Alarm alarm : alarms) {
                alarmRepository.delete(alarm);
            }

            // 예약 삭제
            reservationRepository.delete(reservation);
        } catch (DataIntegrityViolationException e) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Error occurred while deleting reservation", e);
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "An unexpected error occurred while deleting reservation", e);
        }
    }
}
