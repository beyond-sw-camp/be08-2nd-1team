package com.beyond.kkwoborrow.post.entity;

import com.beyond.kkwoborrow.products.entity.Products;
import com.beyond.kkwoborrow.users.entity.Users;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
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

    @NotNull
    @Column(name = "Title")
    private String title;

    @NotNull
    @Column(name = "PostContent")
    private String postContent;

    @NotNull
    @Column(name = "UploadDate")
    private LocalDateTime uploadDate;

    @Column(name = "UpdateDate")
    private LocalDateTime updateDate;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "UserID")
    private Users user;

    @ManyToOne
    @JoinColumn(name = "ProductID")
    private Products product;
}
