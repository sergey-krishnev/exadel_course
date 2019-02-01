$(document).ready(function () {
    var pathname = window.location.pathname;
    pathname = pathname.replace("/admin/", "");
    var Pathname = pathname.charAt(0).toUpperCase() + pathname.slice(1);
    $(document).on('click', '.update' + Pathname, function() {
        var id = $(this).attr("id");
        $("#column" + id).remove();
        $.getJSON("http://localhost:8080/" + pathname + "/" + id, function (data) {
            $("#" + pathname + "UpdateTemplate").tmpl(data).appendTo("#" + pathname + "Body");
        });
        // Select data
        $.getJSON("http://localhost:8080/subjects",function (data) {
            $("#subjectsSelectTemplate".tmpl(data)).appendTo("#subjectsSelectUpdate");
        });
        $.getJSON("http://localhost:8080/users",function (data) {
            $("#usersSelectTemplate".tmpl(data)).appendTo("#usersSelectUpdate");
        });
        $.getJSON("http://localhost:8080/topics",function (data) {
            $("#topicsSelectTemplate".tmpl(data)).appendTo("#topicsSelectUpdate");
        });
    })
});