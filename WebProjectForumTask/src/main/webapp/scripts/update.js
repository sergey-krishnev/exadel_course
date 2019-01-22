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
            error: function (jqXHR, textStatus, errorThrown) {
                var obj = JSON.parse(jqXHR.responseText);
                var objStr = obj.errors.toString();
                var arrayUpdate = objStr.split(',');
                $("#Update-NotEmpty-subjectDTO-subject").text("");
                $("#Update-NotEmpty-subjectDTO-message").text("");
                $("#Update-NotEmpty-subjectDTO-date").text("");
                $("#Update-Pattern-subjectDTO-date").text("");
                $("#Update-CapitalizeMessage-subjectDTO-message").text("");
                $("#Update-CapitalizeSubject-subjectDTO-subject").text("");
                var lang = $("#lang").text();
                $.i18n.properties({
                    name: 'messages',
                    path: '/bundle',
                    mode: 'both',
                    language: lang,
                    callback: function () {
                        $.each(arrayUpdate, function (index, value) {
                            var hashvalueUpdate = "#Update-" + value;
                            $(hashvalueUpdate).text($.i18n.prop(value));
                            // $("#NotEmpty.subjectDTO.subject").text($.i18n.prop("NotEmpty.subjectDTO.subject"));
                        })
                    }
                })
            }
        })
    });
});