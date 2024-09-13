// URL에서 파라미터 값을 가져오는 함수
function getParameterByName(name) {
    const url = window.location.href;
    name = name.replace(/[\[\]]/g, '\\$&');
    const regex = new RegExp('[?&]' + name + '(=([^&#]*)|&|#|$)');
    const results = regex.exec(url);
    if (!results) return null;
    if (!results[2]) return '';
    return decodeURIComponent(results[2].replace(/\+/g, ' '));
}

// 페이지 로드 시 기기에 맞는 이미지와 텍스트 표시
window.onload = function() {
    const deviceId = getParameterByName('device');
    const deviceImage = document.getElementById('deviceImage');
    const deviceText = document.getElementById('deviceText');

    switch (deviceId) {
        case '1':
            deviceImage.src = "/images/product/styler_modal_image.png";
            deviceText.innerText = "Styler 고장 신고";
            break;
        case '2':
            deviceImage.src = "/images/product/shoedresser_modal_image.png";
            deviceText.innerText = "Shoe Case 고장 신고";
            break;
        case '3':
            deviceImage.src = "/images/product/bedroom_modal_image.png";
            deviceText.innerText = "수면 케어룸 고장 신고";
            break;
        case '4':
            deviceImage.src = "/images/product/healingme_modal_image.png";
            deviceText.innerText = "Healing Me 고장 신고";
            break;
        default:
            deviceImage.src = "/images/default_image.png";  // 기본 이미지
            deviceText.innerText = "기기 고장 신고";
            break;
    }
};


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
