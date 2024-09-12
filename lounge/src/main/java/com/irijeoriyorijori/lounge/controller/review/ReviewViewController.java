package com.irijeoriyorijori.lounge.controller.review;

import com.irijeoriyorijori.lounge.domain.review.Review;
import com.irijeoriyorijori.lounge.repository.review.ReviewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.data.domain.Pageable;

import java.util.List;

@Controller
public class ReviewViewController {
    @Autowired
    ReviewRepository reviewRepository;
    private static final int REVIEWS_PER_PAGE = 4; // 페이지당 리뷰 수


//        @GetMapping("/review")
//    public String getReviews(Model model) {
//        List<Review> reviews = reviewRepository.findAll();
//        model.addAttribute("reviews",reviews);
//
//        return "review/reviewList";
//    @GetMapping("/review")
//    public String getReviews(
//            @RequestParam(value = "page", defaultValue = "1") int page,
//            Model model) {
//
//        Pageable pageable = PageRequest.of(page - 1, REVIEWS_PER_PAGE, Sort.by(Sort.Direction.DESC, "updatedAt"));
//        try {
//            Page<Review> reviewPage = reviewRepository.findAll(pageable);
//            model.addAttribute("reviews", reviewPage.getContent());
//            model.addAttribute("currentPage", page);
//            model.addAttribute("totalPages", reviewPage.getTotalPages());
//        } catch (Exception e) {
//            e.printStackTrace(); // 에러 로그 확인
//        }
//
//
//        return "review/reviewList";
//    }
//
//}

//    public List<Review> getReviews() {
//        List<Review> reviews = reviewRepository.findAll();
//        for (Review review : reviews) {
//            if (review.getReservationId() == null) {
//                // 예약 ID가 없을 경우 처리 로직
//            }
//        }
//        return reviews;


//    @GetMapping("/review")
//    public String getReviews(
//            @RequestParam(value = "page", defaultValue = "1") int page,
//            Model model) {
//
//        int start = (page - 1) * REVIEWS_PER_PAGE + 1;
//        int end = page * REVIEWS_PER_PAGE;
//
//        List<Review> reviews = reviewRepository.findReviewsWithPagination(start, end);
//        long totalReviews = reviewRepository.countReviews();
//        int totalPages = (int) Math.ceil((double) totalReviews / REVIEWS_PER_PAGE);
//
//        model.addAttribute("reviews", reviews);
//        model.addAttribute("currentPage", page);
//        model.addAttribute("totalPages", totalPages);
//
//        return "review/reviewList";
//    }
//}

//    @GetMapping("/review")
//    public String getReviews(
//            @RequestParam(value = "page", defaultValue = "1") int page,
//            Model model) {
//
//        int start = (page - 1) * REVIEWS_PER_PAGE;
//        int end = page * REVIEWS_PER_PAGE;
//
//        System.out.println("Start: " + start + ", End: " + end);
//
//        List<Review> reviews = reviewRepository.findReviewsWithPagination(start, end);
//        long totalReviews = reviewRepository.countReviews();
//        int totalPages = (int) Math.ceil((double) totalReviews / REVIEWS_PER_PAGE);
//
//        model.addAttribute("reviews", reviews);
//        model.addAttribute("currentPage", page);
//        model.addAttribute("totalPages", totalPages);
//
//        System.out.println(reviews);
//        System.out.println(page);
//        System.out.println(totalPages);
//        System.out.println(totalReviews);
//        return "review/reviewList";
//    }

    @GetMapping("/review")
    public String getReviews(
            @RequestParam(value = "page", defaultValue = "1") int page,
            Model model) {

        int start = (page - 1) * REVIEWS_PER_PAGE + 1;
        int end = page * REVIEWS_PER_PAGE;

        System.out.println("Start: " + start + ", End: " + end);

        List<Review> reviews = reviewRepository.findReviewsWithPagination(start, end);
        long totalReviews = reviewRepository.countReviews();
        int totalPages = (int) Math.ceil((double) totalReviews / REVIEWS_PER_PAGE);

        model.addAttribute("reviews", reviews);
        model.addAttribute("currentPage", page);
        model.addAttribute("totalPages", totalPages);

        System.out.println(reviews);
        System.out.println(page);
        System.out.println(totalPages);
        System.out.println(totalReviews);
        return "review/reviewList";
    }





	@GetMapping("/review-write")
	public String reviewwrite() { return "review/reviewWrite"; }

}
