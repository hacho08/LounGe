package com.irijeoriyorijori.lounge.controller.review;

import com.irijeoriyorijori.lounge.domain.review.Review;
import com.irijeoriyorijori.lounge.repository.review.ReviewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

public class ReviewViewController {
    @Autowired
    private ReviewRepository reviewRepository;

    @GetMapping("/reviews")
    public String getReviews(Model model) {
        List<Review> reviews = reviewRepository.findAll();
        model.addAttribute("reviews", reviews);
        return "review/reviewList";
    }
}