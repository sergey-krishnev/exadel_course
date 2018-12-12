<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>Add new record</title>
</head>
<body>
<form method="POST" action='MainServlet'>

    Nickname : <input type="text" name="nickname"
                       value="<c:out value="${subject.users.nickname}" />" /> <br />
    Topic name : <input
        type="text" name="topic"
        value="<c:out value="${subject.topic.name}" />" /> <br />
    Subject name : <input
        type="text" name="subject"
        value="<c:out value="${subject.name}" />" /> <br />
    Message name : <input
        type="text" name="message"
        value="<c:out value="${subject.message}" />" /> <br />
    Date : <input
        type="text" name="date"
        value="<fmt:formatDate pattern="MM-dd-yyyy" value="${subject.dateSending}" />" />(MM-dd-yyyy)  <br />



    <input  type="submit" value="Submit" />
</form>
</body>
</html>
