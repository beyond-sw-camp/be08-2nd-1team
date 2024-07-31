package com.beyond.kkwoborrow.reservation.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ReservationRequestDto {
    @Schema(description = "post_id", example = "1")
    private Long postId; // 예약에 필요한 정보가 더 있으면 여기에 추가할 수 있습니다.
}
