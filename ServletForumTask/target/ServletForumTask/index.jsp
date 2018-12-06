<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>ForumTask.com</title>
</head>
<body>
<h1>Hello Servlet</h1>
<tr>
    <c:forEach var="subject" items="${searchBySubject}">
        <td>${subject}</td>
    </c:forEach>
</tr>
</body>
</html>
