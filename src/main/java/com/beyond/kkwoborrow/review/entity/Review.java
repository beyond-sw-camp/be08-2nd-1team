package com.beyond.kkwoborrow.review.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.DecimalMax;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Review {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "review_id")
    private long reviewId;

    @NotNull
    @DecimalMin("0.00")
    @DecimalMax("5.00")
    @Column(name = "review_rate")
    private double reviewRate = 5.0;

    @Column(name = "comment")
    private String comment;

    @NotNull
    @Column(name = "review_date", updatable = false)
    private LocalDateTime reviewDate;

    @NotNull
    @Column(name = "user_id")
    private int userId;

    @NotNull
    @Column(name = "product_id")
    private int productId;

    @PrePersist
    protected void onCreate() {
        this.reviewDate = LocalDateTime.now();
    }
}