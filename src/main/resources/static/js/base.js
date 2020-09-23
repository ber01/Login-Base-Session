$(`.sign-up`).click(function () {

    var jsonData = JSON.stringify({
        email : $(`#email`).val(),
        password : $(`#pwd`).val()
    });

    alert(jsonData);

    $.ajax({
        url: "/sign-up",
        type: "POST",
        data: jsonData,
        contentType: "application/json",
        dataType: "json",
        success: function () {
            alert("성공");
            location.href = '/';
        },
        error: function () {
            alert("실패");
        }
    });
});