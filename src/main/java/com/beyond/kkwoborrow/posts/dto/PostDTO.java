package com.beyond.kkwoborrow.posts.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PostDTO {
    private long postId;
    private String title;
    private String postContent;
    private LocalDateTime uploadDate;
    private LocalDateTime updateDate;
    private int userId;
    private int productId;
}