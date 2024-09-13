package com.irijeoriyorijori.lounge.controller.user;

import com.irijeoriyorijori.lounge.domain.user.User;
import com.irijeoriyorijori.lounge.service.user.UserService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class LoginDataController {

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

    // 세션 체크 엔드포인트
    @GetMapping("/session-check")
    public ResponseEntity<Map<String, Boolean>> sessionCheck(HttpSession session) {
        boolean loggedIn = session.getAttribute("userId") != null;
        Map<String, Boolean> response = new HashMap<>();
        response.put("loggedIn", loggedIn);
        return ResponseEntity.ok(response);
    }
}
