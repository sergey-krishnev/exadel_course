$(document).ready(function () {
    var pathname = window.location.pathname;
    pathname = pathname.replace("/admin/", "");
    var Pathname = pathname.charAt(0).toUpperCase() + pathname.slice(1);
    $(document).on('click', '.delete' + Pathname, function() {
        var id = $(this).attr("id");
        var path = "http://localhost:8080/" + pathname + "/" + id;
        $.ajax({
            url: path   ,
            type: "DELETE",
            success: function (data, textStatus, xhr) {
                $("#column" + id).css("display","none");
            },
            error: function (xhr, textStatus, errorThrown) {
                alert('Error in Operation');
            }
        })
    })
});