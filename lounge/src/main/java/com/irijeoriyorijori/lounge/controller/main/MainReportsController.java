package com.irijeoriyorijori.lounge.controller.main;

import com.irijeoriyorijori.lounge.domain.user.User;
import com.irijeoriyorijori.lounge.service.user.UserService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

public class MainReportsController {
    @Autowired
    UserService userService;

    // 고장 신고 페이지 접근
    @GetMapping("/fault-report")
    public String faultReport(HttpSession session) {
        // 로그인 세션이 있는지 확인
        if (session.getAttribute("userId") != null) {
            return "redirect:/main";  // 고장 신고 페이지로 이동
        } else {
            // 로그인 세션이 없으면 로그인 페이지로 리다이렉션
            return "redirect:/login?redirectTo=/main";
        }
    }

    // 로그인 후 고장 신고 페이지로 리다이렉트
//    @PostMapping("/login-fault-report")
//    public String loginAndFaultReport(@RequestParam("userId") String userId,
//                                      @RequestParam("password") String password,
//                                      HttpSession session) {
//        User user = userService.login(userId, password);
//
//        if (user != null) {
//            session.setAttribute("userId", user.getUserId());  // 로그인 성공 후 세션 저장
//            return "redirect:/reports";  // 고장 신고 페이지로 리다이렉션
//        } else {
//            return "redirect:/login?error=true";  // 로그인 실패 시 로그인 페이지로 리다이렉션
//        }
//}
}
