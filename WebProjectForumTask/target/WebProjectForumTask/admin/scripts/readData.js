$(document).ready(function () {
    $(document).on('click', '.readSubjects', function() {
        var id = $(this).attr("id");
        var path = "http://localhost:8080/subjects/" + id;
        $.getJSON(path,function (data) {
             $(".subjectNameRead").html(data.subjectName);
            $(".subjectsText").html(data.text);
        });
    });
});
