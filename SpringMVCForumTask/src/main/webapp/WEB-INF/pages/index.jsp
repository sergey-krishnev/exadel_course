<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c"%>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<html>
<head>
    <title>Data Page</title>
</head>
<body>
<h1>Spring MVC Forum Task</h1>
<span style="float: right">
    <a href="?lang=en">en</a>
    |
    <a href="?lang=ru">ru</a>
</span>
<table border="1" width="1200">
    <tr>
        <td width="15"><b><spring:message code="nickname"/></b></td>
        <td width="25"><b><spring:message code="topic.name"/></b></td>
        <td width="70"><b><spring:message code="subject.name"/></b></td>
        <td width="175"><b><spring:message code="message"/></b></td>
        <td width="15"><b><spring:message code="date"/></b></td>
        <td colspan=2><b><spring:message code="action.page"/></b></td>
    </tr>
    <c:forEach var="subject" items="${subjects}">
        <tr>
            <td>${subject.users.nickname}</td>
            <td>${subject.topic.name}</td>
            <td>${subject.name}</td>
            <td>${subject.message}</td>
            <td><fmt:formatDate pattern = "MM-dd-yyyy"
                                value = "${subject.dateSending}" /></td>
            <td><a href="editForm/<c:out value="${subject.id}"/>"><spring:message code="index.update"/></a></td>
            <td><a href="delete/<c:out value="${subject.id}"/>"><spring:message code="index.delete"/></a></td>
        </tr>
    </c:forEach>
</table>
<p><a href="newForm"><spring:message code="index.add"/></a></p>
</body>
</html>

