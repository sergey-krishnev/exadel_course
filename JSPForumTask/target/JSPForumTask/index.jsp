<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c"%>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <title>Data Page</title>
</head>
<body>
<h1>JSP Forum Task</h1>
    <h2>Selected type: <c:out value="${type}"/></h2>
<table border="1" width="1200">
    <tr>
        <td width="15"><b>Nickname</b></td>
        <td width="25"><b>Topic</b></td>
        <td width="70"><b>Subject</b></td>
        <td width="175"><b>Message</b></td>
        <td width="15"><b>Date</b></td>
        <td colspan=2><b>Action</b></td>
    </tr>
    <c:forEach var="subject" items="${searchAll}">
        <tr>
            <td>${subject.users.nickname}</td>
            <td>${subject.topic.name}</td>
            <td>${subject.name}</td>
            <td>${subject.message}</td>
            <td><fmt:formatDate pattern = "MM-dd-yyyy"
                                value = "${subject.dateSending}" /></td>
            <td><a href="ActionServlet?action=editForm&subjectId=<c:out value="${subject.id}"/>">Update</a></td>
            <td><a href="ActionServlet?action=delete&subjectId=<c:out value="${subject.id}"/>">Delete</a></td>
        </tr>
    </c:forEach>
</table>
<p><a href="ActionServlet?action=choiceForm">Select the type</a></p>
<p><a href="ActionServlet?action=newForm">Add record</a></p>
</body>
</html>

