$(document).ready(function () {
    $(document).on('click', '.update', function() {
        var usersDTO_data = '';
        var topicDTO_data = '';

        $.getJSON("http://localhost:8080/users", function (data) {
            $.each(data, function (key, value) {
                usersDTO_data += '<option value="' + value.name + '">' + value.name + '</option>';
            });
        });

        $.getJSON("http://localhost:8080/topics", function (data) {
            $.each(data, function (key, value) {
                topicDTO_data += '<option value="' + value.name + '">' + value.name + '</option>';
            });
        });
        alert(usersDTO_data);
        var parseStr = '<td width="15"><select>' + usersDTO_data + '</select></td>';
        parseStr += '<td width="25">2</td>';
        parseStr += '<td width="70"><input type="text" id="subjectUpdate" value="3"/></td>';
        parseStr += '<td width="175"><input type="text" id="messageUpdate" value="4"/></td>';
        parseStr += '<td width="15"><input type="text" id="dateUpdate" value="5"/></td>';
        parseStr += '<td><button type="button" class = "ok">OK</button></td>';
        parseStr += '<td><button type="button" class = "cancel">Cancel</button></td>';
        $(this).closest("td").closest("tr").html(parseStr);
    })
});