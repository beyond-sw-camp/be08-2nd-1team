package com.beyond.kkwoborrow.rental.model.vo;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NonNull;

import java.util.Date;

@Data
@Entity
public class Rental {
    @Id
    @Column(name = "TransactionID")
    private int transactionID;

    @NonNull
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "RentalDate")
    private Date rentalDate;

    @NonNull
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "ReturnDate")
    private Date returDate;

    @NonNull
    @Column(name = "IsReturn")
    private Boolean isReturn;

    @NonNull
    @Column(name = "PostID")
    private int postID;

    public Rental() {

    }
}
