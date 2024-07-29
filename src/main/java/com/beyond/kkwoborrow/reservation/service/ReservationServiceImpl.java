package com.beyond.kkwoborrow.reservation.service;

import com.beyond.kkwoborrow.reservation.dto.ReservationRequestDto;
import com.beyond.kkwoborrow.reservation.dto.ReservationResponseDto;
import com.beyond.kkwoborrow.reservation.entity.Reservation;
import com.beyond.kkwoborrow.reservation.repository.ReservationRepository;
import com.beyond.kkwoborrow.posts.entity.Posts;
import com.beyond.kkwoborrow.posts.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ReservationServiceImpl implements ReservationService {

    @Autowired
    private ReservationRepository reservationRepository;

    @Autowired
    private PostRepository postRepository;

    @Override
    public ReservationResponseDto save(ReservationRequestDto reservationRequestDto) {
        Posts post = postRepository.findById(reservationRequestDto.getPostId())
                .orElseThrow(() -> new IllegalArgumentException("Invalid post ID"));
        Reservation reservation = new Reservation();
        reservation.setPostId(post);
        Reservation savedReservation = reservationRepository.save(reservation);
        return new ReservationResponseDto(savedReservation);
    }

    @Override
    public ReservationResponseDto getReservation(Long reserveId) {
        Reservation reservation = reservationRepository.findById(reserveId)
                .orElseThrow(() -> new IllegalArgumentException("Reservation not found"));
        return new ReservationResponseDto(reservation);
    }

    @Override
    public List<ReservationResponseDto> getAllReservations(int page, int numOfRows, int totalCount) {
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

    @Override
    public void deleteReservation(Long reserveId) {
        reservationRepository.deleteById(reserveId);
    }
}
