<%@ page contentType="text/html;charset=UTF-8;" pageEncoding="UTF-8" language="java" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c"%>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<html>
<head>
    <title>Data Page</title>
    <script src="http://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
</head>
<body>
<h1>Spring MVC REST Forum Task</h1>
<span style="float: left">
    <a href="?lang=en_US">English</a>
    |
    <a href="?lang=ru">Russian</a>
</span> </br>
Current Locale : ${pageContext.response.locale}
<table border="1" width="1200" id="subject_table">
    <tr>
        <th width="15"><b><spring:message code="nickname"/></b></th>
        <th width="25"><b><spring:message code="topic.name"/></b></th>
        <th width="70"><b><spring:message code="subject.name"/></b></th>
        <th width="175"><b><spring:message code="message"/></b></th>
        <th width="15"><b><spring:message code="date"/></b></th>
        <th colspan=2><b><spring:message code="action.page"/></b></th>
    </tr>
</table>
<p><a href="newForm"><spring:message code="index.add"/></a></p>
    <script type="text/javascript">
$(document).ready(function () {
    $.getJSON("http://localhost:8080/subjects", function (data) {
        var subjectDTO_data = '';
        $.each(data, function (key, value) {
            subjectDTO_data += '<tr>';
            subjectDTO_data += '<td>'+value.nickname+'</td>';
            subjectDTO_data += '<td>'+value.topic+'</td>';
            subjectDTO_data += '<td>'+value.subject+'</td>';
            subjectDTO_data += '<td>'+value.message+'</td>';
            subjectDTO_data += '<td>'+value.date+'</td>';
            subjectDTO_data += '<td><a href="editForm/'+value.id+'"><spring:message code="index.update"/></a></td>';
            subjectDTO_data += '<td><a href="subjects/delete/'+value.id+'"><spring:message code="index.delete"/></a></td>';
            subjectDTO_data += '<tr>';
        })
        $('#subject_table').append(subjectDTO_data)
    })
});
    </script>
</body>
</html>

