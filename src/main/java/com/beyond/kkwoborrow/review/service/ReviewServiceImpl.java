package com.beyond.kkwoborrow.review.service;

import com.beyond.kkwoborrow.review.dto.ReviewDTO;
import com.beyond.kkwoborrow.review.entity.Review;
import com.beyond.kkwoborrow.review.repository.ReviewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ReviewServiceImpl implements ReviewService {

    @Autowired
    private ReviewRepository reviewRepository;

    @Override
    public List<ReviewDTO> findAll() {
        return reviewRepository.findAll()
                .stream()
                .map(this::convertToDto)
                .collect(Collectors.toList());
    }

    @Override
    public ReviewDTO findById(Long id) {
        Optional<Review> review = reviewRepository.findById(id);
        return review.map(this::convertToDto).orElse(null);
    }

    @Override
    public ReviewDTO save(ReviewDTO reviewDTO) {
        Review review = convertToEntity(reviewDTO);
        Review savedReview = reviewRepository.save(review);
        return convertToDto(savedReview);
    }

    @Override
    public void deleteById(Long id) {
        reviewRepository.deleteById(id);
    }

    private ReviewDTO convertToDto(Review review) {
        return new ReviewDTO(
                review.getReviewId(),
                review.getReviewRate(),
                review.getComment(),
                review.getReviewDate(),
                review.getUserId(),
                review.getProductId()
        );
    }

    private Review convertToEntity(ReviewDTO reviewDTO) {
        return new Review(
                reviewDTO.getReviewId(),
                reviewDTO.getReviewRate(),
                reviewDTO.getComment(),
                reviewDTO.getReviewDate(),
                reviewDTO.getUserId(),
                reviewDTO.getProductId()
        );
    }
}
