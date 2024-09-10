package com.irijeoriyorijori.lounge.service.reservation;

import com.irijeoriyorijori.lounge.domain.reservation.Reservation;
import com.irijeoriyorijori.lounge.repository.reservation.ReservationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Date;
import java.util.Calendar;


@Service
public class ReservationService {
    @Autowired
    ReservationRepository reservationRepository;

    // 특정 날짜에 예약된 시간대 조회 (productItemId를 기준으로)
    public List<Reservation> getReservationsForDay(String productItemId, Date date) {
        return reservationRepository.findReservationsForDay(
                productItemId, getStartOfDay(date), getEndOfDay(date));
    }

    // 예약 생성 (중복 확인 및 저장)
    public Reservation createReservation(Reservation reservation) {
        // 해당 날짜의 예약된 시간대 가져오기
        List<Reservation> existingReservations = getReservationsForDay(
                reservation.getProductItemId(), reservation.getStartTime());

        // 예약된 시간대와 중복되는지 확인
        for (Reservation existing : existingReservations) {
            if (isTimeOverlap(existing, reservation)) {
                throw new RuntimeException("해당 시간대는 이미 예약되었습니다."); // 시간대 중복 시 예외 발생
            }
        }

        // 중복이 없으면 예약 저장
        return reservationRepository.save(reservation);
    }

    // 시간대 중복 체크
    private boolean isTimeOverlap(Reservation existing, Reservation newReservation) {
        return existing.getEndTime().after(newReservation.getStartTime()) &&
                newReservation.getEndTime().after(existing.getStartTime());
    }

    // 해당 날짜의 시작 시간 설정 (00:00:00)
    private Date getStartOfDay(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        return calendar.getTime();
    }

    // 해당 날짜의 끝 시간 설정 (23:59:59)
    private Date getEndOfDay(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.set(Calendar.HOUR_OF_DAY, 23);
        calendar.set(Calendar.MINUTE, 59);
        calendar.set(Calendar.SECOND, 59);
        return calendar.getTime();
    }
}
