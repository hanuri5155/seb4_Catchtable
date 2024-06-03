const signUpButton = document.getElementById("signUp");
const signInButton = document.getElementById("signIn");
const container = document.getElementById("container");

signUpButton.addEventListener("click", () =>
    container.classList.add("right-panel-active")
);

signInButton.addEventListener("click", () =>
    container.classList.remove("right-panel-active")
);

document.getElementById('signupForm').addEventListener('submit', function(event) {
    var isValid = true;
    var fields = ['username', 'phone_number', 'userid', 'password'];

    // Check required fields
    fields.forEach(function(field) {
        var input = document.getElementById(field);
        if (!input.value.trim()) {
            isValid = false;
            input.classList.add('is-invalid');
        } else {
            input.classList.remove('is-invalid');
        }
    });

    // Check user authority
    var authorities = document.getElementsByName('authority');
    var authoritySelected = false;
    authorities.forEach(function(auth) {
        if (auth.checked) {
            authoritySelected = true;
        }
    });
    if (!authoritySelected) {
        isValid = false;
        //alert('사용자 유형을 선택해 주세요');
    }

    if (!isValid) {
        alert('필수 항목을 입력하시기 바랍니다');
        event.preventDefault();
    }
});

