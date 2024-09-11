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

    // Flatpickr 초기화
    flatpickr("#datePicker", {
        dateFormat: "Y-m-d",  // 날짜 형식
        onChange: function(selectedDates, dateStr, instance) {
            selectedDate = new Date(selectedDates[0]);  // 선택된 날짜를 Date 객체로 변환
            updateReservationInfo();  // 예약 정보 업데이트
        }
    });

    // 오전/오후 선택 기능
    const periodButtons = document.querySelectorAll('.time-slot-tab');
    periodButtons.forEach(button => {
        button.addEventListener('click', function() {
            periodButtons.forEach(b => b.classList.remove('active'));  // 모든 버튼에서 active 제거
            this.classList.add('active');  // 선택된 버튼에 active 추가
            selectedPeriod = this.textContent.trim();  // '오전' 또는 '오후' 값을 업데이트
            updateReservationInfo();  // 예약 정보 업데이트
        });
    });

    // 시간 선택 기능
    const slots = document.querySelectorAll(".slot");
    slots.forEach(slot => {
        slot.addEventListener("click", function() {
            slots.forEach(s => s.classList.remove("selected"));
            this.classList.add("selected");
            selectedTime = this.textContent.trim();  // 선택된 시간 업데이트
            updateReservationInfo();  // 예약 정보 업데이트
        });
    });

    // 타임 테이블 업데이트 함수
    function updateTimeTable(date) {
        const timeTable = document.getElementById('timeTable');
        timeTable.innerHTML = '';  // 기존 타임 테이블을 지움

        // 임의의 타임 슬롯을 추가 (예시)
        const times = ['12시', '1시', '2시', '3시', '4시', '5시', '6시', '7시'];
        times.forEach(time => {
            const timeSlot = document.createElement('div');
            timeSlot.className = 'time-slot';
            timeSlot.textContent = time;
            timeTable.appendChild(timeSlot);
        });
    }

    // 탭 전환 기능
    const tabs = document.querySelectorAll(".time-slot-tab");
    const timeSlotSections = document.querySelectorAll(".time-slots");

    tabs.forEach(tab => {
        tab.addEventListener("click", function() {
            // 탭의 active 클래스 전환
            tabs.forEach(t => t.classList.remove("active"));
            this.classList.add("active");

            // 해당하는 시간 슬롯 섹션만 활성화
            const target = this.getAttribute("data-target");
            timeSlotSections.forEach(section => {
                section.classList.remove("active");
                if (section.classList.contains(target)) {
                    section.classList.add("active");
                }
            });
        });
    });

    // 시간 선택 기능
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
            durationButtons.forEach(b => b.classList.remove('active'));
            this.classList.add('active');
            selectedDuration = this.textContent.trim();  // 선택된 이용 시간 업데이트
            updateReservationInfo();  // 예약 정보 업데이트
        });
    });

    // 요일 계산 함수
    function getKoreanDayOfWeek(date) {
        const daysOfWeek = ['일', '월', '화', '수', '목', '금', '토'];
        return daysOfWeek[date.getDay()];
    }

    // 예약 정보 업데이트 함수
    function updateReservationInfo() {
        if (!selectedDate || !selectedTime || !selectedDuration || !selectedPeriod) {
            document.querySelector('.reservation-info').textContent = '예약: 날짜 선택, 시간 선택 (시간 선택 이용)';
            return;  // 모든 값이 선택되지 않았다면 기본 메시지를 표시
        }

        const formattedDate = selectedDate ? `${selectedDate.getMonth() + 1}월 ${selectedDate.getDate()}일 (${getKoreanDayOfWeek(selectedDate)})` : '날짜 선택';
        const formattedTime = selectedTime ? `${selectedPeriod} ${selectedTime}시` : '시간 선택';
        const formattedDuration = selectedDuration ? selectedDuration : '시간 선택';

        // 예약 정보 업데이트 (형식: 예약: 날짜 (요일), 시간 (이용 시간 이용))
        const reservationInfo = `예약: ${formattedDate}, ${formattedTime} (${formattedDuration} 이용)`;

        document.querySelector('.reservation-info').textContent = reservationInfo;
    }

    // 슬라이드 전환 함수
    function showSlide(index) {
        slides.forEach((slide, i) => {
            slide.classList.remove('active');  // 모든 슬라이드에서 active 제거
            indicators[i].classList.remove('active');  // 모든 인디케이터에서 active 제거
        });

        // 선택된 슬라이드와 인디케이터에 active 클래스 추가
        slides[index].classList.add('active');
        indicators[index].classList.add('active');
    }

    // 인디케이터 클릭 이벤트 추가
    indicators.forEach((indicator, index) => {
        indicator.addEventListener('click', function() {
            currentIndex = index;
            showSlide(currentIndex);  // 선택한 슬라이드로 전환
        });
    });

    // 페이지 로드 시 첫 슬라이드 표시
    showSlide(currentIndex);

});