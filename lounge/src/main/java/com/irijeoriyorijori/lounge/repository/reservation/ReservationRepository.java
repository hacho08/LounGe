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

    @Query(value = "WITH HOURS AS ( " +
            "  SELECT LEVEL - 1 AS HOUR " +
            "  FROM DUAL " +
            "  CONNECT BY LEVEL <= 24 " +
            "), " +
            "PRODUCT_CAPACITY AS ( " +
            "  SELECT PRODUCT_ID, COUNT(PRODUCT_ITEM_ID) AS TOTAL_ITEMS " +
            "  FROM PRODUCT_ITEM " +
            "  WHERE PRODUCT_ID = :productId " +
            "  GROUP BY PRODUCT_ID " +
            "), " +
            "RESERVATION_COUNT AS ( " +
            "  SELECT PI.PRODUCT_ID, H.HOUR, COUNT(R.PRODUCT_ITEM_ID) AS RESERVED_ITEMS " +
            "  FROM HOURS H " +
            "  LEFT JOIN RESERVATION R " +
            "    ON TRUNC(R.START_TIME) = TRUNC(:selectedDate) " +
            "    AND TO_CHAR(R.START_TIME, 'HH24') <= LPAD(H.HOUR, 2, '0') " +
            "    AND TO_CHAR(R.END_TIME, 'HH24') > LPAD(H.HOUR, 2, '0') " +
            "  LEFT JOIN PRODUCT_ITEM PI " +
            "    ON R.PRODUCT_ITEM_ID = PI.PRODUCT_ITEM_ID " +
            "  GROUP BY PI.PRODUCT_ID, H.HOUR " +
            ") " +
            "SELECT H.HOUR || ':00' AS TIME_SLOT, " +
            "  PC.PRODUCT_ID, " +
            "  CASE WHEN NVL(RC.RESERVED_ITEMS, 0) >= PC.TOTAL_ITEMS THEN '사용 불가능' " +
            "  ELSE '사용 가능' END AS AVAILABILITY " +
            "FROM HOURS H " +
            "CROSS JOIN PRODUCT_CAPACITY PC " +
            "LEFT JOIN RESERVATION_COUNT RC " +
            "  ON H.HOUR = RC.HOUR " +
            "  AND PC.PRODUCT_ID = RC.PRODUCT_ID " +
            "ORDER BY H.HOUR ASC", nativeQuery = true)
    List<Object[]> findAvailabilityByProductIdAndDate(@Param("productId") String productId , @Param("selectedDate") Date selectedDate);

}
