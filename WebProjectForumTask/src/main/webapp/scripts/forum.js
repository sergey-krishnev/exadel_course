$(document).ready(function () {
    $.ajax({
        url: "http://localhost:8080/forums",
        type: "GET"
    }).then(function () {
        $.getJSON("http://localhost:8080/forums", function (data) {
            var forumDTO_data = '';
            $.each(data, function (key, value) {
                forumDTO_data += '<tr>';
                forumDTO_data += '<td>' + value.topicName + '</td>';
                forumDTO_data += '<td>' + value.numSubjects + '</td>';
                forumDTO_data += '<td>' + value.numMessages + '</td>';
                forumDTO_data += '<td>' + value.lastDate + '</td>';
                forumDTO_data += '</tr>';
            });
            $('tbody').append(forumDTO_data)
        })
    });
});