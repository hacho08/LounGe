package com.irijeoriyorijori.lounge.reservation;

import com.irijeoriyorijori.lounge.domain.reservation.Reservation;
import com.irijeoriyorijori.lounge.dto.ReservationTimeSlotDTO;
import com.irijeoriyorijori.lounge.repository.reservation.ReservationRepository;
import com.irijeoriyorijori.lounge.service.reservation.ReservationService;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@SpringBootTest
public class JoinTest {


    @Autowired
    ReservationService reservationService;

    @Autowired
    ReservationRepository reservationRepository;

    @Test
    @DisplayName("조인 테스트")
    public void 타임슬롯_테스트() throws ParseException {

        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        Date specificDate = formatter.parse("2024-09-12");

        List<Object[]> results = reservationRepository.findAvailabilityByProductIdAndDate("P00001" , specificDate);
        System.out.println(results.size());
        for(Object[] row : results) {
            System.out.println(row[0]);
            System.out.println(row[1]);
            System.out.println(row[2]);

        }
    }

    @Test
    public void 서비스레벨에서_테스트() throws ParseException {

        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        Date specificDate = formatter.parse("2024-09-12");

        List<ReservationTimeSlotDTO> results = reservationService.findReservationTimeSlots("P00001" , specificDate) ;

        for(ReservationTimeSlotDTO result : results) {
            System.out.println(result.toString());
        }

        //컨트롤ㄹ

    }

}


