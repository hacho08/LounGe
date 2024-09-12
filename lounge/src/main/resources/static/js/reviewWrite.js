// URL에서 파라미터 값을 가져오는 함수 (필요한 경우에만 사용)
function getParameterByName(name) {
    const url = window.location.href;
    name = name.replace(/[\[\]]/g, '\\$&');
    const regex = new RegExp('[?&]' + name + '(=([^&#]*)|&|#|$)');
    const results = regex.exec(url);
    if (!results) return null;
    if (!results[2]) return '';
    return decodeURIComponent(results[2].replace(/\+/g, ' '));
}

document.addEventListener("DOMContentLoaded", function() {
    const textarea = document.getElementById("reportTextarea");
    const submitButton = document.querySelector(".submit-button");

    textarea.addEventListener("input", function() {
        if (textarea.value.trim() !== "") {
            submitButton.style.backgroundColor = "#FF8A32";
            submitButton.style.color = "#fff";
        } else {
            submitButton.style.backgroundColor = ""; // 기본 배경색으로 되돌리기
            submitButton.style.color = ""; // 기본 텍스트 색상으로 되돌리기
        }
    });
});
