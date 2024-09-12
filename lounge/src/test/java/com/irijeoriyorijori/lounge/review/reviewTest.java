package com.irijeoriyorijori.lounge.review;

import com.irijeoriyorijori.lounge.domain.review.Review;
import com.irijeoriyorijori.lounge.repository.review.ReviewRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class reviewTest {
    @Autowired
    ReviewRepository reviewRepository;

    @Test
    public void 리뷰확인() {
        List<Review> reviews = reviewRepository.findAll();

        System.out.println(reviews);
        System.out.println(reviews.size());
    }
}
