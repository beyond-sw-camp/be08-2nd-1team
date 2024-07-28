package com.beyond.kkwoborrow.rental.dto;

import com.beyond.kkwoborrow.post.entity.Posts;
import com.beyond.kkwoborrow.rental.entity.Rental;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class RentalResponseDto {
    private long TransactionID;

    private LocalDateTime RentalDate;

    private LocalDateTime ReturnDate;

    private boolean IsReturn;

    private Long PostId;

    public RentalResponseDto (Rental rental) {
        this.TransactionID = rental.getTransactionID();
        this.ReturnDate = rental.getReturDate();
        this.RentalDate = rental.getRentalDate();
        this.IsReturn = rental.getIsReturn();
        this.PostId = rental.getPostID().getPostId();
    }
}
