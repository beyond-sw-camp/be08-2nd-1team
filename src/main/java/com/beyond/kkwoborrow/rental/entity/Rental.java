package com.beyond.kkwoborrow.rental.entity;

import com.beyond.kkwoborrow.posts.entity.Posts;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Entity
public class Rental {
    @Id
    @Column(name = "transaction_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long transactionID;

    @NotNull
    @Column(name = "rental_date")
    private LocalDateTime rentalDate;

    @NotNull
    @Column(name = "return_date")
    private LocalDateTime returDate;

    @NotNull
    @Column(name = "is_return")
    private Boolean isReturn;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "post_id")
    private Posts postID;

}
