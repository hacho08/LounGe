//// 모든 + 버튼에 이벤트 리스너 추가
//const modals = document.querySelectorAll('.modal');
//const modalBtns = document.querySelectorAll('.plus-button');
//
//// 모든 모달 기본 숨김 설정
//modals.forEach(modal => {
//    modal.style.display = 'none'; // 기본적으로 숨김 처리
//});
//
//modalBtns.forEach((btn, index) => {
//    btn.addEventListener('click', function() {
//        // 모든 모달 창을 닫기
//        modals.forEach(modal => modal.style.display = 'none');
//
//        // 해당 버튼의 모달 열기
//        const modal = document.getElementById(`modal${index + 1}`);
//        const btnRect = btn.getBoundingClientRect();
//        modal.style.top = `${btnRect.top + window.scrollY + 50}px`;
//        modal.style.left = `${btnRect.left + window.scrollX - 50}px`;
//        modal.style.display = "flex";
//
//        // 클릭된 버튼에 active 클래스 추가 및 다른 버튼 축소
//        modalBtns.forEach((b) => {
//            if (b !== btn) {
//                b.classList.remove('active');
//                b.classList.add('shrink'); // 나머지 버튼은 축소
//            } else {
//                b.classList.remove('shrink'); // 클릭된 버튼은 축소되지 않음
//                b.classList.add('active'); // 클릭된 버튼 확대
//            }
//        });
//    });
//});
//
//// 모달 외부 클릭 시 닫기
//window.addEventListener('click', function(event) {
//    modals.forEach(modal => {
//        if (!modal.contains(event.target) && !Array.from(modalBtns).includes(event.target)) {
//            modal.style.display = "none";
//            modalBtns.forEach((b) => {
//                b.classList.remove('active');
//                b.classList.remove('shrink'); // 버튼이 원래 크기로 돌아오도록
//            });
//        }
//    });
//});

// 로그인 상태 확인 함수
async function checkLoginStatus() {
    const response = await fetch('/check-session', {
        method: 'GET',
        credentials: 'same-origin'
    });
    const data = await response.json();
    return data.loggedIn;
}

// 모든 + 버튼에 이벤트 리스너 추가
const modals = document.querySelectorAll('.modal');
const modalBtns = document.querySelectorAll('.plus-button');

// 모든 모달 기본 숨김 설정
modals.forEach(modal => {
    modal.style.display = 'none'; // 기본적으로 숨김 처리
});

modalBtns.forEach((btn, index) => {
    btn.addEventListener('click', async function() {
        // 모든 모달 창을 닫기
        modals.forEach(modal => modal.style.display = 'none');

        // 해당 버튼의 모달 열기
        const modal = document.getElementById(`modal${index + 1}`);
        const btnRect = btn.getBoundingClientRect();
        // 모달창의 위치 조정
        modal.style.top = `${btnRect.top + window.scrollY - 270}px`;
        modal.style.left = `${btnRect.left + window.scrollX - 200}px`;
        modal.style.display = "flex";

        // 클릭된 버튼에 active 클래스 추가 및 다른 버튼 축소
        modalBtns.forEach((b) => {
            if (b !== btn) {
                b.classList.remove('active');
                b.classList.add('shrink'); // 나머지 버튼은 축소
            } else {
                b.classList.remove('shrink'); // 클릭된 버튼은 축소되지 않음
                b.classList.add('active'); // 클릭된 버튼 확대
            }
        });
    });
});

//// 고장신고 버튼 클릭 시 로그인 상태 확인 후 리디렉션
//document.querySelectorAll('.report-btn').forEach(button => {
//    button.addEventListener('click', async (event) => {
//        const isLoggedIn = await checkLoginStatus();
//        if (isLoggedIn) {
//            // 세션이 있을 경우 고장신고 페이지로 이동
//            window.location.href = button.querySelector('a').href;
//        } else {
//            // 세션이 없을 경우 로그인 페이지로 이동
//            window.location.href = '/login';
//        }
//        event.preventDefault(); // 링크 기본 동작 방지
//    });
//});

// 모달 외부 클릭 시 닫기
window.addEventListener('click', function(event) {
    modals.forEach(modal => {
        if (!modal.contains(event.target) && !Array.from(modalBtns).includes(event.target)) {
            modal.style.display = "none";
            modalBtns.forEach((b) => {
                b.classList.remove('active');
                b.classList.remove('shrink'); // 버튼이 원래 크기로 돌아오도록
            });
        }
    });
});
