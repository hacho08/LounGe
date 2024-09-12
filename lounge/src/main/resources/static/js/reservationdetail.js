document.addEventListener('DOMContentLoaded', function() {
    const selectedDateElement = document.getElementById('selected-date');
    const selectedTimeElement = document.getElementById('selected-time');
    const selectedDurationElement = document.getElementById('selected-duration');
    const slides = document.querySelectorAll('.slide');
    const indicators = document.querySelectorAll('.indicator');
    let currentIndex = 0;
    let selectedDate = '';
    let selectedTime = '';
    let selectedPeriod = '오전';  // 기본값을 '오전'으로 설정
    let selectedDuration = '1시간';
    const flat = flatpickr("#datePicker",{
        onChange: function(dates) {
                console.log(selectedDates[0]);
        }
    });

    console.log(selectedDate, selectedTime, selectedDuration, selectedPeriod);


//    // Flatpickr 초기화
//    flatpickr("#datePicker", {
//        dateFormat: "Y-m-d",
//        onChange: function(selectedDates) {
//            selectedDate = new Date(selectedDates[0]);
//            console.log("initiating flatpickr");
//            updateReservationInfo();
//        }
//    });

    // 오전/오후 선택 기능
    const periodButtons = document.querySelectorAll('.time-slot-tab');
    periodButtons.forEach(button => {
        button.addEventListener('click', function() {
            periodButtons.forEach(b => b.classList.remove('active'));  // 모든 버튼에서 active 제거
            this.classList.add('active');  // 선택된 버튼에 active 추가
            selectedPeriod = this.textContent.trim();  // 오전/오후 값 업데이트
            updateReservationInfo();  // 예약 정보 업데이트
        });
    });

//    // 시간 슬롯 선택 기능
//    const slots = document.querySelectorAll(".slot");
//    slots.forEach(slot => {
//        slot.addEventListener("click", function() {
//            slots.forEach(s => s.classList.remove("selected"));  // 모든 시간 슬롯에서 selected 제거
//            this.classList.add("selected");  // 선택된 시간 슬롯에 selected 추가
//            selectedTime = this.textContent.trim();  // 선택된 시간 값 업데이트
//            updateReservationInfo();  // 예약 정보 업데이트
//        });
//    });

//     시간 선택 기능
    const slots = document.querySelectorAll(".slot");
    slots.forEach(slot => {
        slot.addEventListener("click", function() {
            slots.forEach(s => s.classList.remove("selected"));
            this.classList.add("selected");
            selectedTime = this.textContent.trim();  // 선택된 시간 업데이트
            updateReservationInfo();  // 예약 정보 업데이트
        });
    });

    // 이용 시간 선택 기능
    const durationButtons = document.querySelectorAll('.usage-button');
    durationButtons.forEach(button => {
        button.addEventListener('click', function() {
            durationButtons.forEach(b => b.classList.remove('active'));  // 모든 이용 시간 버튼에서 active 제거
            this.classList.add('active');  // 선택된 버튼에 active 추가
            selectedDuration = this.textContent.trim();  // 이용 시간 값 업데이트
            updateReservationInfo();  // 예약 정보 업데이트
        });
    });

    // 요일 계산 함수
    function getKoreanDayOfWeek(date) {
        const daysOfWeek = ['일', '월', '화', '수', '목', '금', '토'];
        return daysOfWeek[date.getDay()];
    }

    // 예약 정보 업데이트 함수
    function updateReservationInfo(num) {
        console.log("&&&", num, selectedDate, selectedTime, selectedDuration, selectedPeriod);
        // 모든 값이 선택되지 않았을 경우 기본 메시지를 표시
        if (!selectedDate || !selectedTime || !selectedDuration || !selectedPeriod) {
            document.querySelector('.reservation-info').textContent = '예약: 날짜 선택, 시간 선택 (시간 선택 이용)';
            return;
        }

        const formattedDate = `${selectedDate.getMonth() + 1}월 ${selectedDate.getDate()}일 (${getKoreanDayOfWeek(selectedDate)})`;
        const formattedTime = `${selectedPeriod} ${selectedTime}시`;
        const formattedDuration = selectedDuration;

        // 예약 정보 텍스트 업데이트
        const reservationInfo = `예약: ${formattedDate}, ${formattedTime} (${formattedDuration} 이용)`;
        document.querySelector('.reservation-info').textContent = reservationInfo;
    }



    // 슬라이드를 표시하는 함수
    function showSlide(index) {
        console.log('현재 슬라이드 인덱스:', index);  // 디버깅용 로그 추가
        slides.forEach((slide, i) => {
            slide.classList.remove('active');  // 모든 슬라이드에서 active 제거
            indicators[i].classList.remove('active');  // 모든 인디케이터에서 active 제거
        });

        // 선택된 슬라이드와 인디케이터에 active 클래스 추가
        slides[index].classList.add('active');
        indicators[index].classList.add('active');
    }

    // 인디케이터 클릭 시 슬라이드 전환
    indicators.forEach((indicator, index) => {
        indicator.addEventListener('click', function() {
            console.log('클릭된 인디케이터 인덱스:', index);  // 클릭 이벤트 확인
            currentIndex = index;
            showSlide(currentIndex);  // 선택한 슬라이드로 전환
        });
    });

    // 초기 상태로 첫 번째 슬라이드를 표시
    showSlide(currentIndex);
});