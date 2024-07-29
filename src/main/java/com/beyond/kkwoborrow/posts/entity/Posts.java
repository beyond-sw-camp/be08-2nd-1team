package com.beyond.kkwoborrow.posts.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "Posts")
public class Posts {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "post_id")
    private long postId;

    @Column(name = "title")
    private String title;

    @Column(name = "post_content")
    private String postContent;

    @NotNull
    @Column(name = "upload_date", updatable = false)
    private LocalDateTime uploadDate;

    @Column(name = "update_date")
    private LocalDateTime updateDate;

    @NotNull
    @Column(name = "userID")
    private int userId;

    @NotNull
    @Column(name = "product_id")
    private int productId;

    @PrePersist
    protected void onCreate() {
        this.uploadDate = LocalDateTime.now();
    }

    @PreUpdate
    protected void onUpdate() {
        this.updateDate = LocalDateTime.now();
    }
}