package com.irijeoriyorijori.lounge.controller.reservation;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ReservationHomeController {

      @GetMapping("/reservation")
        public String bookingPage() {
            return "/reservation/booking"; // 예약 페이지
        }
        //예약 첫 페이지 화면 나오기

    }

