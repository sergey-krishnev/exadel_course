$(document).ready(function () {
    $.getJSON("http://localhost:8080/topics", function (data) {
        var topicDTO_data = '';
        $.each(data, function (key, value) {
            topicDTO_data += '<li>';
            topicDTO_data += '<a href="#">' + value.topicName + '</a>';
            topicDTO_data += '</li>';
        });
        $('.aggregate-topics').append(topicDTO_data)
    });

         <!-- Blog Post -->
    $.getJSON("http://localhost:8080/subjects", function (data) {
        var subjectsDTO_data = '';
        subjectsDTO_data += '<h1 class="my-4">All Subjects</h1>';
        $.each(data, function (key, value) {
            subjectsDTO_data += '<div class = "card mb-4">';
            subjectsDTO_data += '<div class = "card-body">';
            subjectsDTO_data += '<h2 class = "card-title">' + value.subjectName + '</h2>';
            subjectsDTO_data += '<p class = "card-text">' + value.description + '</p>';
            subjectsDTO_data += '<a href="#" class = "btn btn-primary">Read More &rarr;</a>';
            subjectsDTO_data += '</div>';
            subjectsDTO_data += '<div class="card-footer text-muted">Posted on ' + value.date + 'by';
            subjectsDTO_data += '<a href="#">' + value.userName + '</a>';
            subjectsDTO_data += '</div></div>';

        });
        $('.aggregate-subjects').append(subjectsDTO_data)
    });
});