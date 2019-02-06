$(document).ready(function () {
    var schemeHost = $("#url").attr("href");
    var pathname = window.location.pathname;
    pathname = pathname.replace("/admin/", "");
    var Pathname = pathname.charAt(0).toUpperCase() + pathname.slice(1);
    $(document).on('click', '.add' + Pathname, function() {
        $(".add" + Pathname + "Data").val("");
        $.getJSON(schemeHost + "subjects",function (data) {
            var subjectDTO_data = '';
            subjectDTO_data += '<option selected disabled>Select the subject</option>';
            $.each(data, function (key, value) {
                subjectDTO_data += '<option value="' + value.subjectName + '">' + value.subjectName +'</option>';
            });
            $(".subjectsSelectUpdate").html(subjectDTO_data);
        });
        $.getJSON(schemeHost + "users",function (data) {
            var userDTO_data = '<option selected disabled>Select the user</option>';
            userDTO_data += '';
            $.each(data, function (key, value) {
                userDTO_data += '<option value="' + value.userName + '">' + value.userName +'</option>';
            });
            $(".usersSelectUpdate").html(userDTO_data);
        });
        $.getJSON(schemeHost + "topics",function (data) {
            var topicDTO_data = '<option selected disabled>Select the topic</option>';
            topicDTO_data += '';
            $.each(data, function (key, value) {
                topicDTO_data += '<option value="' + value.topicName + '">' + value.topicName +'</option>';
            });
            $(".topicsSelectUpdate").html(topicDTO_data);
        });
    });
    $(document).on('click', '#add' + Pathname + "ModalButton", function() {
        var today = new Date();
        var date = today.getFullYear()+'-'+(today.getMonth()+1)+'-'+today.getDate();
        var time = today.getHours() + ":" + today.getMinutes() + ":" + today.getSeconds();
        var dateTime = date+' '+time;
        $("#dateAdd" + Pathname + "Modal").val(dateTime);
        var map = {};
        $(".add" + Pathname + "Data").each(function() {
            map[$(this).attr("name")] = $(this).val();
        });
        map["id"] = 1;
        alert(JSON.stringify(map));
        $.ajax({
            type: "POST",
            url: schemeHost + pathname,
            data: JSON.stringify(map),
            contentType: 'application/json; charset=UTF-8',
            dataType: "json",
            success: function (data, textStatus, xhr) {
                // var htmlMap = $("#" + pathname + "Template").tmpl(map);
                // alert(htmlMap);
                // htmlMap.appendTo("#" + pathname + "Body"); //Change
                // alert("success");
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