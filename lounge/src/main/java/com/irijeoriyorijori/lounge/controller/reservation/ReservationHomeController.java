package com.irijeoriyorijori.lounge.controller.reservation;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class ReservationHomeController {

    @GetMapping("/reservation/complete")
    public String reservationComplete(Model model) {
        // 예약 완료 화면으로 이동
        return "reservation/reservationComplete";
    }

    @GetMapping("/reservation/{productType}")
    public String reservationDetail(@PathVariable(name="productType") String productType,
                                    Model model) {
        model.addAttribute("productType", productType);
        return "reservation/booking";
    }
}
