$(document).ready(function () {
    var schemeHost = $("#url").attr("href");
    var pathname = window.location.pathname;
    pathname = pathname.replace("/admin/", "");
    var Pathname = pathname.charAt(0).toUpperCase() + pathname.slice(1);
    var id;
    var path;
    $(document).on('click', '.delete' + Pathname, function() {
        id = $(this).attr("id");
        path = schemeHost + pathname + "/" + id;
    });
        $(document).on('click', '#delete' + Pathname + "ModalButton", function() {
            $.ajax({
                url: path,
                type: "DELETE",
                success: function (data, textStatus, xhr) {
                    $("#column" + id).css("display", "none");
                },
                error: function (xhr, textStatus, errorThrown) {
                    alert('Error in Operation');
                }
            })
        })
});