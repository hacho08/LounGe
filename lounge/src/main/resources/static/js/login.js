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
