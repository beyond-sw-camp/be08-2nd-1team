package com.beyond.kkwoborrow.review.entity;

import com.beyond.kkwoborrow.products.entity.Products;
import com.beyond.kkwoborrow.users.entity.Users;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;

@Entity
public class Review {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ReviewID")
    private long reviewId;

    @NotNull
    @Column(name = "ReviewRate")
    private Float reviewRate = 5.0f;

    @Column(name = "Comment")
    private String comment;

    @NotNull
    @Column(name = "ReviewDate")
    private LocalDateTime reviewDate;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "UserID")
    private Users user;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "ProductID")
    private Products product;
}
