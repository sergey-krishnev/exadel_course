$(document).ready(function () {

    $(document).on('click', '.update', function() {

        var subjectParse = $(this).closest("td").prev().prev().prev().text();
        var messageParse = $(this).closest("td").prev().prev().text();
        var dateParse = $(this).closest("td").prev().text();
        var idParse = $(this).attr("id");
        alert(subjectParse + ":" + messageParse + ":" + dateParse + ":" + idParse);

        var usersDTO_data = $("#nickname").html();
        var topicDTO_data = $("#topic").html();

        var parseStr = '<td width="15"><select id = "nicknameUpdate">' + usersDTO_data +'</select></td>';
        parseStr += '<td width="25"><select id = "topicUpdate">' + topicDTO_data + '</select></td>';
        parseStr += '<td width="70"><input type="text" width="70" id="subjectUpdate" value="' + subjectParse +'"/></td>';
        parseStr += '<td width="175"><input type="text" width="175" id="messageUpdate" value="' + messageParse +'"/></td>';
        parseStr += '<td width="15"><input type="text" width="15" id="dateUpdate" value="' + dateParse +'"/></td>';
        parseStr += '<td><button type="button" class = "ok" id = "'+ idParse +'">OK</button></td>';
        parseStr += '<td><button type="button" class = "cancel">Cancel</button></td>';
        $(this).closest("td").closest("tr").html(parseStr);
    })
});