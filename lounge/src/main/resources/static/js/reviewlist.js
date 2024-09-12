document.addEventListener('DOMContentLoaded', () => {

    const categoryButtons = document.querySelectorAll('.category');

    // 카테고리 필터 클릭 시
    categoryButtons.forEach(button => {
        button.addEventListener('click', () => {
            // 모든 버튼의 active 클래스 제거
            categoryButtons.forEach(btn => btn.classList.remove('active'));
            // 클릭한 버튼에 active 클래스 추가
            button.classList.add('active');
        });
    });
});
