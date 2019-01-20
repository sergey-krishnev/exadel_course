$(document).ready(function () {
    $(document).on('click', '.cancel', function() {
        location.reload();
    });
    $(document).on('click', '.ok', function() {
        var dataUpdate = {};
        dataUpdate["id"] = 1;
        dataUpdate["nickname"] = $("#nicknameUpdate").val();
        dataUpdate["topic"] = $("#topicUpdate").val();
        dataUpdate["subject"] = $("#subjectUpdate").val();
        dataUpdate["message"] = $("#messageUpdate").val();
        dataUpdate["date"] = $("#dateUpdate").val();

        var pathPut = "http://localhost:8080/subjects/" + $(this).attr("id");

        $.ajax({
            type: "PUT",
            url: pathPut,
            data: JSON.stringify(dataUpdate),
            contentType: 'application/json; charset=UTF-8',
            dataType: "json",
            success: function (data, textStatus, xhr) {
                location.reload(); //Change
                alert("success")
            },
            error: function (jqXHR2, textStatus, errorThrown) {
                alert(jqXHR2.responseText);
                location.reload()
            }
        })
    });
});