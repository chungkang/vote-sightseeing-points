let emailCheck = 0;     // 중복체크 안된 경우

const signup = {
    init : function () {
        const _this = this;
        $('#btn-signup').on('click', function () {
            if(signUpCheck()) {
                if(emailCheck == 0) {
                    alert("이메일 중복체크를 해주세요");
                    $('#signup_email').focus();
                } else {
                    _this.save();
                }
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
            url: '/members/signup',
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

// sign up validation check
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

// email 중복여부 확인
$(function() {
    $("#btn-emailcheck").click(function () {
        if($("#signup_email").val().length == 0){
            alert("이메일을 입력해 주세요");
            $("#signup_email").focus();
            return false;
        }

        const email = $("#signup_email").val();
        $.ajax({
            async: true,
            type: 'POST',
            data: email,
            url: "/members/emailcheck",
            dataType: "json",
            contentType: "application/json; charset=UTF-8",
            success: function (data) {
                if (data.count > 0) {
                    alert("해당 이메일이 존재합니다. 다른 이메일을 입력해주세요.");
                    $("#signup_email").focus();
                    emailCheck = 0;
                } else {
                    alert("사용 가능한 이메일입니다.");
                    emailCheck = 1;
                }
            },
            error: function (error) {
                alert("error : " + error);
            }
        });
    });
});
