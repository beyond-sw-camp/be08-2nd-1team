package com.beyond.kkwoborrow.rental.entity;

import com.beyond.kkwoborrow.post.entity.Posts;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import java.time.LocalDate;
import java.time.LocalDateTime;

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
    @Column(name = "RentalDate")
    private LocalDateTime rentalDate;

    @NonNull
    @Column(name = "ReturnDate")
    private LocalDateTime returDate;

    @NonNull
    @Column(name = "IsReturn")
    private Boolean isReturn;

    @NonNull
    @ManyToOne
    @JoinColumn(name = "PostID")
    @Column(name = "PostID")
    private Posts postID;
}
