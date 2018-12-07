<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c"%>
<html>
<head>
    <title>ForumTask.com</title>
</head>
<body>
<h1>Forum Task</h1>
<c:forEach var="subject" items="${searchByAll}">
    <tr>
        <td>${subject}</td>
        <br/>
    </tr>
</c:forEach>
</body>
</html>
