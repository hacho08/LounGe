package com.irijeoriyorijori.lounge.repository.reservation;

import com.irijeoriyorijori.lounge.domain.reservation.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Date;


public interface ReservationRepository extends JpaRepository<Reservation, String> {


    // 특정 날짜의 예약된 시간대를 조회
    @Query("SELECT r FROM Reservation r WHERE r.productItemId = :productItemId AND r.startTime BETWEEN :startOfDay AND :endOfDay")
    List<Reservation> findReservationsForDay(String productItemId, Date startOfDay, Date endOfDay);

}
