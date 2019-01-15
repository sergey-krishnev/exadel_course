$(document).ready(function () {
    $(document).on('click', '.add', function() {
        var nickname = $("#nickname").val();
        var topic = $("#topic").val();
        var subject = $("#subject").val();
        var message = $("#message").val();
        var date = $("#date").val();
        alert(nickname + " : " + topic + " : " + subject + " : " + message + " : " + date);
        alert({"id":108,"nickname":"Tulio","topic":"Television Stars","subject":"Capitals","message":"We if prosperous comparison middletons at.","date":"2014-11-27"})
        var jsonPost = '{ "id":1,"nickname":"'+ nickname +'",'
    });
});