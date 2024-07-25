package com.beyond.kkwoborrow.rental.entity.dto;

import com.beyond.kkwoborrow.rental.entity.Rental;

import java.time.LocalDateTime;

public class RentalResponseDto {
    private long TransactionID;

    private LocalDateTime RentalDate;

    private LocalDateTime ReturnDate;

    private boolean IsReturn;

    private int PostID;

    public RentalResponseDto (Rental rental) {
        this.TransactionID = rental.getTransactionID();
        this.ReturnDate = rental.getReturDate();
        this.RentalDate = rental.getRentalDate();
        this.IsReturn = rental.getIsReturn();
    }
}
