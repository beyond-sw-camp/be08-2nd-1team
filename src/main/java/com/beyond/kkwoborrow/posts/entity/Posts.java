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
    @Column(name = "PostID")
    private long postId;

    @Column(name = "Title")
    private String title;

    @Column(name = "PostContent")
    private String postContent;

    @NotNull
    @Column(name = "UploadDate", updatable = false)
    private LocalDateTime uploadDate;

    @Column(name = "UpdateDate")
    private LocalDateTime updateDate;

    @NotNull
    @Column(name = "UserID")
    private int userId;

    @NotNull
    @Column(name = "ProductID")
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