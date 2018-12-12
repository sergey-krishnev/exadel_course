<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c"%>
<html>
<head>
    <title>Data Page</title>
</head>
<body>
<table border="1" width="303">
    <tr>
        <td width="15"><b>Nickname</b></td>
        <td width="25"><b>Topic</b></td>
        <td width="70"><b>Subject</b></td>
        <td width="175"><b>Message</b></td>
        <td width="10"><b>Date</b></td>
    </tr>

        <c:forEach var="subject" items="${searchByAll}">
    <tr>
        <td>${subject.users.name}</td>
        <td>${subject.topic.name}</td>
        <td>${subject.name}</td>
        <td>${subject.message}</td>
        <td>${subject.dateSending}</td>
    </tr>
    </c:forEach>
</table>
</body>
</html>
