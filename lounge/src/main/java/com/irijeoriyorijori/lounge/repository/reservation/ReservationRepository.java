package com.irijeoriyorijori.lounge.repository.reservation;

import com.irijeoriyorijori.lounge.domain.reservation.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ReservationRepository extends JpaRepository<Reservation, String> {
    @Query(value= "SELECT * FROM RESERVATION WHERE RESERVATION_ID" , nativeQuery = true)
    List<Reservation> findReservationSearch(@Param(value = "search") String search);  //에약내역 있는지 확인

}
