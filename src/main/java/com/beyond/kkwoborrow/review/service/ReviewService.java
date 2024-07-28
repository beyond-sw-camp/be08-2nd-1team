package com.beyond.kkwoborrow.review.service;

import com.beyond.kkwoborrow.review.dto.ReviewDTO;

import java.util.List;

public interface ReviewService {
    List<ReviewDTO> findAll();
    ReviewDTO findById(Long id);
    ReviewDTO save(ReviewDTO reviewDTO);
    void deleteById(Long id);
}
