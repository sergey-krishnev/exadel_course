$(document).ready(function () {
    var schemeHost = $("#url").attr("href");
    $(document).on('click', '.readSubjects', function() {
        var id = $(this).attr("id");
        var path = schemeHost + "subjects/" + id;
        $.getJSON(path,function (data) {
             $(".subjectNameRead").html(data.subjectName);
            $(".subjectsText").html(data.text);
        });
    });
});
