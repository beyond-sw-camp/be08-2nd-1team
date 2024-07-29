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
@Table(name = "Review")
public class Review {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ReviewID")
    private long reviewId;

    @NotNull
    @DecimalMin("0.00")
    @DecimalMax("5.00")
    @Column(name = "ReviewRate")
    private double reviewRate = 5.0;

    @Column(name = "Comment")
    private String comment;

    @NotNull
    @Column(name = "ReviewDate", updatable = false)
    private LocalDateTime reviewDate;

    @NotNull
    @Column(name = "UserID")
    private int userId;

    @NotNull
    @Column(name = "ProductID")
    private int productId;

    @PrePersist
    protected void onCreate() {
        this.reviewDate = LocalDateTime.now();
    }
}