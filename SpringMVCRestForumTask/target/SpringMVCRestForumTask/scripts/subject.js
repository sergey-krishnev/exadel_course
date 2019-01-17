$(document).ready(function () {

    var lang = $("#lang").text();
    var deleteButton ='';
    var updateButton ='';

    $.i18n.properties({
        name: 'messages',
        path: '/bundle',
        mode: 'both',
        language: lang,
        callback: function () {
            $(".nicknameLocale").text($.i18n.prop('nickname'));
            $(".topicLocale").text($.i18n.prop('topic.name'));
            $(".subjectLocale").text($.i18n.prop('subject.name'));
            $(".messageLocale").text($.i18n.prop('message'));
            $(".dateLocale").text($.i18n.prop('date'));
            $(".actionLocale").text($.i18n.prop('action.page'));

            $("#addPageLocale").text($.i18n.prop('add.page'));
            $(".add").text($.i18n.prop('submit.page'));
            deleteButton = $.i18n.prop('index.delete');
            updateButton = $.i18n.prop('index.update');
            // action.page = Action
            // submit.page = Submit
            //
            // nickname = Nickname
            // topic.name = Topic
            // subject.name = Subject
            // message = Message
            // date = Date
        }
    });
    // var lang = $("#lang");

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
                subjectDTO_data += '<td><button type="button" class = "update" id ="' + value.id + '">'+ updateButton +'</button></td>';
                subjectDTO_data += '<td><button type="button" class = "delete" id ="' + value.id + '">'+ deleteButton +'</button></td>';
                subjectDTO_data += '</tr>';
            });
            $('#subject_table').append(subjectDTO_data)
        })
    });
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