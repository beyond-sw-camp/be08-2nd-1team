package com.beyond.kkwoborrow.entity;

import jakarta.persistence.*;
import org.springframework.data.annotation.Id;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "Review")
public class Review {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ReviewID")
    private Integer reviewId;

    @Column(name = "ReviewRate", nullable = false)
    private Float reviewRate = 5.0f;

    @Column(name = "Comment")
    private String comment;

    @Column(name = "ReviewDate", nullable = false, updatable = false)
    private LocalDateTime reviewDate;

    @ManyToOne
    @JoinColumn(name = "UserID", nullable = false)
    private User user;

    @ManyToOne
    @JoinColumn(name = "ProductID", nullable = false)
    private Product product;

    @PrePersist
    protected void onCreate() {
        reviewDate = LocalDateTime.now();
    }

    // Getters and Setters

    public Integer getReviewId() {
        return reviewId;
    }

    public void setReviewId(Integer reviewId) {
        this.reviewId = reviewId;
    }

    public Float getReviewRate() {
        return reviewRate;
    }

    public void setReviewRate(Float reviewRate) {
        this.reviewRate = reviewRate;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public LocalDateTime getReviewDate() {
        return reviewDate;
    }

    public void setReviewDate(LocalDateTime reviewDate) {
        this.reviewDate = reviewDate;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }
}
