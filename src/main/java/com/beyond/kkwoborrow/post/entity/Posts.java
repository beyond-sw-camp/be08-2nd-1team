package com.beyond.kkwoborrow.post.entity;

import com.beyond.kkwoborrow.products.entity.Products;
import com.beyond.kkwoborrow.users.entity.Users;
import jakarta.annotation.Nonnull;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Posts {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "PostID")
    private long postId;

    @Nonnull
    @Column(name = "Title")
    private String title;

    @Nonnull
    @Column(name = "PostContent")
    private String postContent;

    @Nonnull
    @Column(name = "UploadDate")
    private LocalDateTime uploadDate;

    @Column(name = "UpdateDate")
    private LocalDateTime updateDate;

    @Nonnull
    @ManyToOne
    @JoinColumn(name = "UserID")
    private Users user;

    @ManyToOne
    @JoinColumn(name = "ProductID")
    private Products product;
}
