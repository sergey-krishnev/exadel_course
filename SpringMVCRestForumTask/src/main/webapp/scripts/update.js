$(document).ready(function () {
    $(document).on('click', '.cancel', function() {
        location.reload();
    });
    $(document).on('click', '.ok', function() {

        var nicknameUpdate = $("#nicknameUpdate").val();
        var topicUpdate = $("#topicUpdate").val();
        var subjectUpdate = $("#subjectUpdate").val();
        var messageUpdate = $("#messageUpdate").val();
        var dateUpdate = $("#dateUpdate").val();
        var pathPut = "http://localhost:8080/subjects/" + $(this).attr("id");
        var jsonPut = '{ "id":1,"nickname":"'+ nicknameUpdate +'","topic":"' + topicUpdate + '","subject":"' + subjectUpdate +
            '","message":"' + messageUpdate + '","date":"' + dateUpdate +'"}';

        $.ajax({
            type: "PUT",
            url: pathPut,
            data: jsonPut,
            contentType : 'application/json; charset=UTF-8',
            dataType: "html",
            success: function (data, textStatus, xhr) {
                location.reload(); //Change
                alert("success")
            },
            error: function (xhr, textStatus, errorThrown) {
                alert(xhr);
                alert(textStatus);
                alert(errorThrown);
                location.reload()
            }
        })
    });
});