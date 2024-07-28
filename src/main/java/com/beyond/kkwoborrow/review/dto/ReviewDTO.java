package com.beyond.kkwoborrow.review.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ReviewDTO {
    private long reviewId;
    private double reviewRate;
    private String comment;
    private LocalDateTime reviewDate;
    private int userId;
    private int productId;
}
