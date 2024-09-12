package com.irijeoriyorijori.lounge.repository.review;

import com.irijeoriyorijori.lounge.domain.review.Review;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ReviewRepository extends JpaRepository<Review, String> {
    List<Review> findAll(); // 모든 리뷰를 가져오는 메소드
}

