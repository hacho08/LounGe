document.addEventListener('DOMContentLoaded', function() {
    // Flatpickr 초기화
    flatpickr("#datePicker", {
        dateFormat: "Y-m-d",  // 날짜 형식
        onChange: function(selectedDates, dateStr, instance) {
            updateTimeTable(dateStr);  // 선택한 날짜에 맞춰 타임테이블 업데이트
        }
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
});
