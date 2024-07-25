package com.beyond.kkwoborrow.rental.dto;

import java.time.LocalDateTime;

public class RentalRequestDto {
    private long TransactionID;

    private LocalDateTime RentalDate;

    private LocalDateTime ReturnDate;

    private boolean IsReturn;

    private int PostID;
}
