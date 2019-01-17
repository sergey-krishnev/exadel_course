$(document).ready(function () {
    $(document).on('click', '.delete', function() {
        var id = $(this).attr("id");
        var path = "http://localhost:8080/subjects/" + id;
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