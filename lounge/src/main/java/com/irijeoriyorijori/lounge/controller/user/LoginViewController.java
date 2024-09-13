package com.irijeoriyorijori.lounge.controller.user;

import com.irijeoriyorijori.lounge.domain.user.User;
import com.irijeoriyorijori.lounge.service.user.UserService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.HashMap;
import java.util.Map;

@Controller
public class LoginViewController {


    // 로그인 성공 후 리다이렉트 처리
    @GetMapping("/login")
    public String loginPage(@RequestParam(value = "redirectTo", required = false) String redirectTo, HttpSession session) {
        if (session.getAttribute("userId") != null) {
            if (redirectTo != null && !redirectTo.isEmpty()) {
                return "redirect:" + redirectTo;  // 이전 페이지로 리다이렉트
            }
            return "redirect:/main";  // 기본적으로 홈 화면으로 이동
        }
        return "login";  // 로그인 페이지로 이동
    }


    @GetMapping("/report")
    public String reportPage(HttpSession session, Model model, RedirectAttributes redirectAttributes) {
        if (session.getAttribute("userId") == null) {
            // 리다이렉트 시 파라미터 전달
            redirectAttributes.addAttribute("redirectTo", "/report");
            return "redirect:/login";
        }
        // 세션이 있을 경우 보고서 페이지 처리
        return "reports/reports";


    }
}


