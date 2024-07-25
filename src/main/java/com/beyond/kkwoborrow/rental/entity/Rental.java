package com.beyond.kkwoborrow.rental.entity;

import com.beyond.kkwoborrow.post.entity.Posts;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Entity
public class Rental {
    @Id
    @Column(name = "TransactionID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long transactionID;

    @NotNull
    @Column(name = "RentalDate")
    private LocalDateTime rentalDate;

    @NotNull
    @Column(name = "ReturnDate")
    private LocalDateTime returDate;

    @NotNull
    @Column(name = "IsReturn")
    private Boolean isReturn;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "PostID")
    private Posts postID;

    public Long getId() {
        return transactionID;
    }
}
