package com.beyond.kkwoborrow.reservation.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class ReservationsResponseDto {
    private int code;
    private String message;
    private List<ReservationResponseDto> result;
    private int page;
    private int numOfRows;
    private int totalCount;

    public ReservationsResponseDto(List<ReservationResponseDto> result, int page, int numOfRows, int totalCount) {
        this.code = 200;
        this.message = "OK";
        this.result = result;
        this.page = page;
        this.numOfRows = numOfRows;
        this.totalCount = totalCount;
    }
}
