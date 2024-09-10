package com.irijeoriyorijori.lounge.controller.reservation;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ReservationHome {

    @GetMapping("/reservation")
    public String bookingPage() {
        return "reservation/booking"; // 예약 페이지
    }

}
