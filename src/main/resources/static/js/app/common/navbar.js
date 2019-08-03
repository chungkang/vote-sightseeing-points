const signup = {
    init : function () {
        const _this = this;
        $('#btn-signup').on('click', function () {
            if(signUpCheck()) {
                _this.save();
            }
        });
    },
    save : function () {
        const data = {
            email: $('#signup_email').val(),
            name: $('#signup_name').val(),
            password: $('#signup_password').val()
        };

        $.ajax({
            type: 'POST',
            url: '/users/signup',
            dataType: 'json',
            contentType:'application/json; charset=utf-8',
            data: JSON.stringify(data)
        }).done(function() {
            alert('회원가입이 되었습니다.');
            location.reload();
        }).fail(function (error) {
            alert(error);
        });
    }

};

signup.init();

// sign up check
function signUpCheck() {
    const email = $("#signup_email").val();
    const name = $("#signup_name").val();
    const password = $("#signup_password").val();

    if(email.length == 0){
        alert("이메일을 입력해 주세요");
        $("#signup_email").focus();
        return false;
    }

    if(name.length == 0){
        alert("이름을 입력해 주세요");
        $("#signup_name").focus();
        return false;
    }

    if(password.length == 0){
        alert("비밀번호를 입력해 주세요");
        $("#signup_password").focus();
        return false;
    }
    return true;
}