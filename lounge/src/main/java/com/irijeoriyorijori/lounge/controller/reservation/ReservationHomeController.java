package com.irijeoriyorijori.lounge.controller.reservation;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ReservationHomeController {

//    @GetMapping("/reservation")
//    public String bookingPage() {
//        return "reservation/booking"; // 예약 페이지
//    }

    @GetMapping("/reservation/complete")
    public String reservationComplete(Model model) {
        // 예약 완료 화면으로 이동
        return "reservation/reservationComplete";
    }

    @GetMapping("/reservation")
    public String reservationDetail(@RequestParam(name="productId") String productId,
                                    Model model) {
        System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!productID"+productId);
        model.addAttribute("productId", productId);
        return "reservation/booking";
    }
}
