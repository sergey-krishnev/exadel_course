$(document).ready(function () {
    $(document).on('click', '.deleteComment', function() {
        var id = $(this).attr("id");
        var path = "http://localhost:8080/comments/" + id;
        alert(path);
        $.ajax({
            url: path   ,
            type: "DELETE",
            success: function (data, textStatus, xhr) {
                location.reload() //Change
            },
            error: function (xhr, textStatus, errorThrown) {
                alert('Error in Operation');
            }
        })
    })
});