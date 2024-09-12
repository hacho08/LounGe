package com.irijeoriyorijori.lounge.controller.user;

import com.irijeoriyorijori.lounge.domain.user.User;
import com.irijeoriyorijori.lounge.service.user.UserService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@RestController
public class LoginController {
    @Autowired
    UserService userService;

    @PostMapping("/login-process")
    public Boolean loginProcess(@RequestBody User user, Model model, HttpSession session) {
        User loginUser = userService.login(user.getUserId(), user.getPassword());

        if (loginUser != null) {
            session.setAttribute("userId", user.getUserId());
            return true;
        } else {
            model.addAttribute("error", "로그인 실패");
            return false;
        }
    }

//    // 로그인 성공 후 리다이렉션 처리
//    @GetMapping("/login")
//    public String loginPage(@RequestParam(value = "redirectTo", required = false) String redirectTo, HttpSession session) {
//        // 로그인 성공 시 리다이렉트 처리
//        if (session.getAttribute("userId") != null) {
//            if (redirectTo != null && !redirectTo.isEmpty()) {
//                return "redirect:" + redirectTo;  // 이전 페이지로 리다이렉트
//            }
//            return "redirect:/";  // 기본적으로 홈 화면으로 이동
//        }
//        return "login";  // 로그인 페이지로 이동
//    }
}
