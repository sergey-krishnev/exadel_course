$(document).ready(function () {
    $.ajax({
        url: "http://localhost:8080/subjects",
        type: "GET"
    }).then(function () {
        $.getJSON("http://localhost:8080/subjects", function (data) {
            var subjectDTO_data = '';
            $.each(data, function (key, value) {
                subjectDTO_data += '<tr>';
                subjectDTO_data += '<td>' + value.nickname + '</td>';
                subjectDTO_data += '<td>' + value.topic + '</td>';
                subjectDTO_data += '<td>' + value.subject + '</td>';
                subjectDTO_data += '<td>' + value.message + '</td>';
                subjectDTO_data += '<td>' + value.date + '</td>';
                subjectDTO_data += '<td><button type="button" class = "update" id ="' + value.id + '">Update</button></td>';
                subjectDTO_data += '<td><button type="button" class = "delete" id ="' + value.id + '">Delete</button></td>';
                subjectDTO_data += '</tr>';
            });
            $('#subject_table').append(subjectDTO_data)
        })
    })
    $.getJSON("http://localhost:8080/users", function (data) {
        var usersDTO_data = '';
        $.each(data, function (key, value) {
            usersDTO_data += '<option value="' + value.name + '">' + value.name + '</option>';
        });
        $('#nickname').append(usersDTO_data)
    });
    $.getJSON("http://localhost:8080/topics", function (data) {
        var topicDTO_data = '';
        $.each(data, function (key, value) {
            topicDTO_data += '<option value="' + value.name + '">' + value.name + '</option>';
        });
        $('#topic').append(topicDTO_data)
    });
});