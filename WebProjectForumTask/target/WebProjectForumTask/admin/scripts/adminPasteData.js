$(document).ready(function () {
    var schemeHost = $("#url").attr("href");
    var pathname = window.location.pathname;
    pathname = pathname.replace("/admin/", "");
    var Pathname = pathname.charAt(0).toUpperCase() + pathname.slice(1);
    var idNav = "#" + pathname + "NavItem";
    var idDispl = "#display" + Pathname + "Table";
    $(idNav).addClass("active");
    $(".Pathname").text(Pathname);
    $(idDispl).css("display", "block");

    $.getJSON(schemeHost + pathname, function (data) {
        $.each(data, function (key, value) {
            value.href = '/admin/' + pathname + '/' + data.id;
        });
        if (pathname === "subjects") {
            $.each(data, function (key, value) {
                value.text = value.text.split(".")[0] + ".";
            });
        }
        $("#" + pathname + "Template").tmpl(data).appendTo("#" + pathname + "Body");
    });
});