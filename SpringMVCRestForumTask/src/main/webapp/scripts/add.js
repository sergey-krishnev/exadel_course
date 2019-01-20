$(document).ready(function () {
    $(document).on('click', '.add', function() {
        var data = {};
        // var nickname = $("#nickname").val();
        // var topic = $("#topic").val();
        // var subject = $("#subject").val();
        // var message = $("#message").val();
        // var date = $("#date").val();
        // var jsonPost = '{ "id":1,"nickname":"'+ nickname +'","topic":"' + topic + '","subject":"' + subject +
        //     '","message":"' + message + '","date":"' + date +'"}';
        data["id"] = 1;
        data["nickname"] = $("#nickname").val();
        data["topic"] = $("#topic").val();
        data["subject"] = $("#subject").val();
        data["message"] = $("#message").val();
        data["date"] = $("#date").val();

        $.ajax({
            type: "POST",
            url: "http://localhost:8080/subjects",
            data: JSON.stringify(data),
            contentType: 'application/json; charset=UTF-8',
            dataType: "json",
            success: function (data, textStatus, xhr) {
                location.reload(); //Change
                alert("success")
            },
            error: function (jqXHR, textStatus, errorThrown) {
                alert(jqXHR.responseText);
                var obj = JSON.parse(jqXHR.responseText);
                alert(obj.errors);
                location.reload()
            }
        });
    });
});