package com.beyond.kkwoborrow.reservation.dto;

import com.beyond.kkwoborrow.reservation.entity.Reservation;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ReservationResponseDto {
    private long reserveId;
    private Long postId;

    public ReservationResponseDto(Reservation reservation) {
        this.reserveId = reservation.getReserveID();
        this.postId = reservation.getPostId().getPostId();
    }
}
