$(document).ready(function () {
    $(document).on('click', '.add', function() {
        var nickname = $("#nickname").val();
        var topic = $("#topic").val();
        var subject = $("#subject").val();
        var message = $("#message").val();
        var date = $("#date").val();
        var jsonPost = '{ "id":1,"nickname":"'+ nickname +'","topic":"' + topic + '","subject":"' + subject +
            '","message":"' + message + '","date":"' + date +'"}';
        alert(jsonPost);
        $.ajax({
            type: "POST",
            url: "http://localhost:8080/subjects",
            data: jsonPost,
            contentType: "application/json; charset=utf-8",
            dataType: "json",
            success: function (data) {
                alert(data);
                location.reload();
            },
            failure: function (errMsg) {
                alert(errMsg);
            }
        })
    });
});