$(document).ready(function () {
    var pathname = window.location.pathname;
    pathname = pathname.replace("/admin/", "");
    var Pathname = pathname.charAt(0).toUpperCase() + pathname.slice(1);
    $(document).on('click', '.update' + Pathname, function() {
        var id = $(this).attr("id");
        $.getJSON("http://localhost:8080/" + pathname + "/" + id,function (data) {
            $.each(data, function (key, value) {
                $("#" + key.toString() + "Update" + Pathname + "Modal").val(value);
            });

        });
        $.getJSON("http://localhost:8080/subjects",function (data) {
            var subjectDTO_data = '';
            $.each(data, function (key, value) {
                subjectDTO_data += '<option value="' + value.subjectName + '">' + value.subjectName +'</option>';
            });
            $(".subjectsSelectUpdate").html(subjectDTO_data);
        });
        $.getJSON("http://localhost:8080/users",function (data) {
            var userDTO_data = '';
            $.each(data, function (key, value) {
                userDTO_data += '<option value="' + value.userName + '">' + value.userName +'</option>';
            });
            $(".usersSelectUpdate").html(userDTO_data);
        });
        $.getJSON("http://localhost:8080/topics",function (data) {
            var topicDTO_data = '';
            $.each(data, function (key, value) {
                topicDTO_data += '<option value="' + value.topicName + '">' + value.topicName +'</option>';
            });
            $(".topicsSelectUpdate").html(topicDTO_data);
        });

    })
});