$(document).ready(function () {
    $(document).on('click', '.add', function() {
        var nickname = $("#nickname").val();
        var topic = $("#topic").val();
        var subject = $("#subject").val();
        var message = $("#message").val();
        var date = $("#date").val();
        alert(nickname + " : " + topic + " : " + subject + " : " + message + " : " + date);
    });
});