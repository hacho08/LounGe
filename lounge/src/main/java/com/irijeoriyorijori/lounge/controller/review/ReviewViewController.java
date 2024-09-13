package com.irijeoriyorijori.lounge.controller.review;

import com.irijeoriyorijori.lounge.domain.review.Review;
import com.irijeoriyorijori.lounge.repository.review.ReviewRepository;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.data.domain.Pageable;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
public class ReviewViewController {
    @Autowired
    ReviewRepository reviewRepository;
    private static final int REVIEWS_PER_PAGE = 4; // 페이지당 리뷰 수

    @GetMapping("/review")
    public String getReviews(
            @RequestParam(value = "page", defaultValue = "1") int page, HttpSession session,

            Model model) {

//        // 로그인 여부 확인 - 로그아웃 헤더를 위해
//        boolean isLoggedIn = session.getAttribute("userId") != null;
//        model.addAttribute("isLoggedIn", isLoggedIn);

        int start = (page - 1) * REVIEWS_PER_PAGE + 1;
        int end = page * REVIEWS_PER_PAGE;

        List<Review> reviews = reviewRepository.findReviewsWithPagination(start, end);
        long totalReviews = reviewRepository.countReviews();
        int totalPages = (int) Math.ceil((double) totalReviews / REVIEWS_PER_PAGE);

        model.addAttribute("reviews", reviews);
        model.addAttribute("currentPage", page);
        model.addAttribute("totalPages", totalPages);

        // 페이지 구분을 위한 변수 설정
        model.addAttribute("isReviewListPage", true);  // 리뷰 목록 페이지

        return "review/reviewList";
    }

//    @GetMapping("/review-write")
//    public String reviewWrite(Model model) {
//        // 페이지 구분을 위한 변수 설정
//        model.addAttribute("isReviewListPage", false);  // 리뷰 작성 페이지
//
//        return "review/reviewWrite";
//    }

    @GetMapping("/review-write")
    public String reviewWrite(HttpSession session, Model model, RedirectAttributes redirectAttributes) {
        // 세션에서 로그인 여부를 확인
        String userId = (String)session.getAttribute("userId");

        if (userId == null) {
            // 로그인 세션이 없으면 로그인 페이지로 리디렉션
            redirectAttributes.addFlashAttribute("message", "로그인이 필요합니다.");
            return "redirect:/login";
        }

        // 로그인된 상태라면, 페이지 구분을 위한 변수 설정
        model.addAttribute("isReviewListPage", false);  // 리뷰 작성 페이지

        // 리뷰 작성 페이지로 이동
        return "review/reviewWrite";
    }

}
