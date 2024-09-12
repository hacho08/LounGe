package com.irijeoriyorijori.lounge.controller.main;

import com.irijeoriyorijori.lounge.domain.user.User;
import com.irijeoriyorijori.lounge.service.user.UserService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class MainViewController {

    @Autowired
    UserService userService;

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
        return "review/reviewList";
    }

    @GetMapping("test")
    public String test() {
        return "layout/layout";
    }

}
