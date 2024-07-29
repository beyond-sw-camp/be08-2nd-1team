package com.beyond.kkwoborrow.rental.dto;

import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class RentalRequestDto {
    private Long TransactionID;

    private LocalDateTime RentalDate;

    private LocalDateTime ReturnDate;

    private boolean IsReturn;

   private Long PostId;
}
