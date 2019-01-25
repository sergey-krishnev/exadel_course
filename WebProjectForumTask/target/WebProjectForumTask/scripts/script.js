$(document).ready(function () {
    $.getJSON("http://localhost:8080/topics", function (data) {
        var topicDTO_data = '';
        $.each(data, function (key, value) {
            topicDTO_data += '<li>';
            topicDTO_data += '<a href="#">' + value.topicName + '</a>';
            topicDTO_data += '</li>';
        });
        $('.aggregate-topics').append(topicDTO_data)
    })
});