package com.beyond.kkwoborrow.review.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.DecimalMax;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import com.beyond.kkwoborrow.products.entity.Products;
import com.beyond.kkwoborrow.users.entity.Users;
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
    private double reviewRate = 5.0f;

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
