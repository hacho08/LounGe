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
    if (data === true) {  // 서버가 success 값을 true로 반환하면 로그인 성공
        window.location.href = "/";
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

document.querySelector('.report-btn').addEventListener('click', function(e) {
    e.preventDefault();

    // 세션 체크
    fetch('/session-check')
    .then(response => {
        if (response.status === 200) {
            // 세션이 있으면 고장 신고 페이지로 이동
            window.location.href = "reservation/booking";
        } else {
            // 세션이 없으면 로그인 페이지로 이동
            window.location.href = "/login?redirectTo=/reports";
        }
    })
    .catch(error => {
        console.error('세션 체크 중 오류 발생:', error);
    });
});


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
