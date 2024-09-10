package com.irijeoriyorijori.lounge.controller.reservation;

import com.irijeoriyorijori.lounge.domain.reservation.Reservation;
import com.irijeoriyorijori.lounge.service.reservation.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;


@RestController
@RequestMapping("/api/reservations")
public class ReservationDetailController {

    @Autowired
    ReservationService reservationService;

    // 특정 날짜의 예약 시간대 조회  (사용자가 페이지에 접속하거나 날짜를 클릭했을 때 호출)
    @GetMapping("/{productItemId}/{date}")
    public ResponseEntity<List<Reservation>> getReservationsForDay(
            @PathVariable("productItemId") String productItemId,
            @PathVariable("date") @DateTimeFormat(pattern = "yyyy-MM-dd") Date date) {

        List<Reservation> reservations = reservationService.getReservationsForDay(productItemId, date);
        return ResponseEntity.ok(reservations);
    }

    // 예약하기 (중복 확인 후 예약 저장)
    @PostMapping("/create")
    public ResponseEntity<Reservation> createReservation(@RequestBody Reservation reservation) {
        try {
            Reservation createdReservation = reservationService.createReservation(reservation);
            return ResponseEntity.ok(createdReservation);
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body(null);  // 중복 시간대 처리
        }
    }
}
