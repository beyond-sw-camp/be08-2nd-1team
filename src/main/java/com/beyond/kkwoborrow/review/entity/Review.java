package com.beyond.kkwoborrow.review.entity;

import com.beyond.kkwoborrow.products.entity.Products;
import com.beyond.kkwoborrow.users.entity.Users;
import jakarta.annotation.Nonnull;
import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
public class Review {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ReviewID")
    private long reviewId;

    @Nonnull
    @Column(name = "ReviewRate")
    private Float reviewRate = 5.0f;

    @Column(name = "Comment")
    private String comment;

    @Nonnull
    @Column(name = "ReviewDate")
    private LocalDateTime reviewDate;

    @Nonnull
    @ManyToOne
    @JoinColumn(name = "UserID")
    private Users user;

    @Nonnull
    @ManyToOne
    @JoinColumn(name = "ProductID")
    private Products product;
}
