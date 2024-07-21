package com.beyond.kkwoborrow.rental.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Rental {
    @Id
    @Column(name = "TransactionID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long transactionID;

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
