package com.irijeoriyorijori.lounge.controller.main;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainViewController {

    @GetMapping("/")
    public String main() {
        return "main";
    }

    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @GetMapping("/review")
    public String review() {
        return "reviewList";
    }

    @GetMapping("/reservation/complete")
    public String reservationComplete(Model model) {
        // 예약 완료 화면으로 이동
        return "reservation/reservationComplete";
    }

    @GetMapping("test")
    public String test() {
        return "layout/layout";
    }
}
