package com.irijeoriyorijori.lounge.controller.reservation;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ReservationHomeController {

    //예약 첫 페이지 화면 나오기
    @GetMapping("/reservation")
    public String reservationHome(){
        return "main";
    }
}
