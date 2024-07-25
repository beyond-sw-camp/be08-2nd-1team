package com.beyond.kkwoborrow.review.repository;

import com.beyond.kkwoborrow.review.entity.Review;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReviewRepository extends JpaRepository<Review, Long> {
}
