package com.irijeoriyorijori.lounge.controller.reservation;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
<<<<<<< HEAD:lounge/src/main/java/com/irijeoriyorijori/lounge/controller/reservation/ReservationHomeController.java
public class ReservationHomeController {
=======
public class ReservationHome {

    @GetMapping("/reservation")
    public String bookingPage() {
        return "reservation/booking"; // 예약 페이지
    }
>>>>>>> 4f6dba7386d1db0687851e47fecced255e6e1d38:lounge/src/main/java/com/irijeoriyorijori/lounge/controller/reservation/ReservationHome.java

    //예약 첫 페이지 화면 나오기
    @GetMapping("/reservation")
    public String reservationHome(){
        return "main";
    }
}
