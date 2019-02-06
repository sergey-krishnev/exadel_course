$(document).ready(function () {
    var schemeHost = $("#url").attr("href");
    var pathname = window.location.pathname;
    pathname = pathname.replace("/admin/", "");
    var Pathname = pathname.charAt(0).toUpperCase() + pathname.slice(1);
    var id;
    $(document).on('click', '.update' + Pathname, function() {
        id = $(this).attr("id");
        var selectedSubject;
        var selectedUser;
        var selectedTopic;
        $.getJSON(schemeHost + pathname + "/" + id,function (data) {
            selectedSubject = data.subjectName;
            selectedUser = data.userName;
            selectedTopic = data.topicName;
            $.each(data, function (key, value) {
                $("#" + key.toString() + "Update" + Pathname + "Modal").val(value);
            });

        });
        $.getJSON(schemeHost + "subjects",function (data) {
            var subjectDTO_data = '';
            $.each(data, function (key, value) {
                if (value.subjectName === selectedSubject) {
                    subjectDTO_data += '<option selected value="' + value.subjectName + '">' + value.subjectName +'</option>';
                } else {
                    subjectDTO_data += '<option value="' + value.subjectName + '">' + value.subjectName +'</option>';
                }

            });
            $(".subjectsSelectUpdate").html(subjectDTO_data);
        });
        $.getJSON(schemeHost + "users",function (data) {
            var userDTO_data = '';
            $.each(data, function (key, value) {
                if (value.userName === selectedUser) {
                    userDTO_data += '<option selected value="' + value.userName + '">' + value.userName + '</option>';
                } else {
                    userDTO_data += '<option value="' + value.userName + '">' + value.userName + '</option>';
                }
            });
            $(".usersSelectUpdate").html(userDTO_data);
        });
        $.getJSON(schemeHost + "topics",function (data) {
            var topicDTO_data = '';
            $.each(data, function (key, value) {
                if (value.topicName === selectedTopic) {
                    topicDTO_data += '<option selected value="' + value.topicName + '">' + value.topicName + '</option>';
                } else {
                    topicDTO_data += '<option value="' + value.topicName + '">' + value.topicName + '</option>';
                }
            });
            $(".topicsSelectUpdate").html(topicDTO_data);
        });

    });
    $(document).on('click', '#update' + Pathname + "ModalButton", function() {
        var today = new Date();
        var date = today.getFullYear()+'-'+(today.getMonth()+1)+'-'+today.getDate();
        var time = today.getHours() + ":" + today.getMinutes() + ":" + today.getSeconds();
        var dateTime = date+' '+time;
        $("#dateUpdate" + Pathname + "Modal").val(dateTime);
        var map = {};
        $(".update" + Pathname + "Data").each(function() {
            map[$(this).attr("name")] = $(this).val();
        });
        map["id"] = 1;
        $.ajax({
            type: "PUT",
            url: schemeHost + pathname + "/" + id,
            data: JSON.stringify(map),
            contentType: 'application/json; charset=UTF-8',
            dataType: "json",
            success: function (data, textStatus, xhr) {
                // map["id"] = id;
                // if (pathname === "subjects") {
                //     map["text"] = map["text"].split(".")[0] + ".";
                // }
                // var htmlMap = $("#" + pathname + "Template").tmpl(map).html();
                // $("#column" + id).html(htmlMap);
                // //Change
                // alert("success")
                $("#" + pathname + "Body").empty();
                $.getJSON(schemeHost + pathname, function (data) {
                    if (pathname === "subjects") {
                        $.each(data, function (key, value) {
                            value.text = value.text.split(".")[0] + ".";
                        });
                    }
                    $("#" + pathname + "Template").tmpl(data).appendTo("#" + pathname + "Body");
                });
            },
            error: function (jqXHR, textStatus, errorThrown) {
                alert("error")
            }
        });
    });
});