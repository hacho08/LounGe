document.getElementById('loginBtn').addEventListener('click', function(e) {
    e.preventDefault();

    const userId = document.getElementById('userId').value;
    const password = document.getElementById('password').value;

fetch('/login-process', {
    method: 'POST',
    headers: {
        'Content-Type': 'application/json',
    },
    body: JSON.stringify({ userId, password }),
})
.then(response => response.json())
.then(data => {
    if (data) {  // 서버가 success 값을 true로 반환하면 로그인 성공
        window.location.href = "/main";
    } else {
        alert('학번 또는 비밀번호가 올바르지 않습니다.');
    }
})
.catch(error => {
    console.error('로그인 중 오류 발생:', error);
    alert('서버 오류가 발생했습니다.');
});

});

window.addEventListener('DOMContentLoaded', function() {
    fetch('/session-check')
    .then(response => {
        if (response.status === 401) {
            // 로그인이 되어 있지 않으면 로그인 페이지로 이동
            window.location.href = '/login.html';
        }
    });
});

//document.querySelector('.reservation-button').addEventListener('click', function() {
//    fetch('/session-check')
//    .then(response => {
//        if (response.status === 200) {
//            // 예약 로직을 처리
//            alert('예약이 완료되었습니다.');
//            window.location.href = '/reservationComplete.html';
//        } else {
//            // 로그인 페이지로 이동
//            window.location.href = '/login.html';
//        }
//    });
//});

document.querySelector('.reservation-button').addEventListener('click', function() {
    fetch('/session-check')
    .then(response => response.json())
    .then(data => {
        if (data.loggedIn) {
            // 예약 완료 페이지로 이동
            window.location.href = '/reservationComplete.html';
        } else {
            // 로그인 페이지로 이동, 예약 페이지 URL을 쿼리 파라미터로 전달
            window.location.href = '/login?redirectTo=' + encodeURIComponent('/reservation/booking.html');
        }
    })
    .catch(error => {
        console.error('세션 체크 중 오류 발생:', error);
        alert('서버 오류가 발생했습니다.');
    });
});


document.querySelectorAll('.report-btn').forEach(button => {
    button.addEventListener('click', function() {
       fetch('/session-check')
        .then(response => response.json())  // JSON 형태로 응답을 받습니다.
        .then(data => {
            console.log('세션 체크 결과:', data);  // 세션 체크 결과 로그 출력
            if (data.loggedIn) {  // 세션이 있으면 고장 신고 페이지로 이동
                // 고장 신고 페이지로 이동
                window.location.href = this.getAttribute('href');
            } else {
                // 로그인 페이지로 이동
                window.location.href = '/login.html?redirectTo=' + encodeURIComponent(this.getAttribute('href'));
            }
    });
})
});
//document.querySelectorAll('.report-btn').forEach(button => {
//    button.addEventListener('click', function(event) {
//        event.preventDefault();  // 기본 동작을 막고, 이후에 세션 체크 처리
//
//        const reportUrl = this.querySelector('a').getAttribute('href');  // a 태그의 href 값을 가져옴
//
//        fetch('/session-check')
//        .then(response => {
//            if (response.ok) {
//                return response.json();  // JSON 응답 처리
//            } else {
//                throw new Error('세션 체크 실패');
//            }
//        })
//        .then(data => {
//            if (data.loggedIn) {
//                window.location.href = reportUrl;  // 세션이 있으면 고장 신고 페이지로 이동
//            } else {
//                window.location.href = '/login?redirectTo=' + encodeURIComponent(reportUrl);  // 세션이 없으면 로그인 페이지로 이동
//            }
//        })
//        .catch(error => {
//            console.error('세션 체크 중 오류 발생:', error);
//            alert('서버 오류가 발생했습니다.');
//        });
//    });
//});



function checkFields() {
    const userId = document.getElementById('userId').value;
    const password = document.getElementById('password').value;
    const loginBtn = document.getElementById('loginBtn');

    if (userId.trim() !== "" && password.trim() !== "") {
        loginBtn.classList.add('active');
        loginBtn.disabled = false;
    } else {
        loginBtn.classList.remove('active');
        loginBtn.disabled = true;
    }
}
