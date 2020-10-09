$("#sign_up_btn").click( function (event) {
        const jsonData = JSON.stringify({
            email: $('#sign_up_email').val(),
            password: $('#sign_up_password').val(),
        })

        const token = $("meta[name='_csrf']").attr("content");
        const header = $("meta[name='_csrf_header']").attr("content");

        $.ajax({
            url: "/sign-up",
            type: "POST",
            data: jsonData,
            contentType: "application/json",
            dataType: "json",
            beforeSend: function (xhr) {
                xhr.setRequestHeader(header, token);
            },
            success: function (data) {
                // 아래 3개 전부 가능
                alert(data.msg);
                // alert(data["msg"]);
                // alert(data['msg']);
                location.href = '/';
            },
            error: function (xhr, textStatus, errorThrown) {
                const data = JSON.parse(xhr.responseText);
                // console.log(data);
                // 아래 3개 전부 가능
                // console.log(data['msg']);
                // console.log(data["msg"]);
                // console.log(data.msg);
                alert(data.msg)
            }
        });

    }
);