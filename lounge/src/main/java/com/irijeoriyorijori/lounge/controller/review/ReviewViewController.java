package com.irijeoriyorijori.lounge.controller.review;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ReviewViewController {

	@GetMapping("/review")
	public String review() { return "review/reviewList"; }

	@GetMapping("/review-write")
	public String reviewwrite() { return "review/reviewWrite"; }

}
