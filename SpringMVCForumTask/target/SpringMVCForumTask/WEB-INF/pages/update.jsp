<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>Edit record</title>
    <style type="text/css">
        .error {
            color: red;
        }
    </style>
</head>
<body>

<h1>Edit record</h1>
<form:form action="update" modelAttribute="subjectDTO" method="post">

    Nickname : <select name="nickname">
    <c:forEach var="username" items="${users}">
        <option value="${username.nickname}">${username.nickname}</option>
    </c:forEach>
</select> <br/>
    Topic name : <select name="topic">
    <c:forEach var="topicname" items="${topics}">
        <option value="${topicname.name}">${topicname.name}</option>
    </c:forEach>
</select> <br/>
    <table>
        <tr>
            <td>Subject name :</td>
            <td><form:input path="subject"/></td>
            <td><form:errors path="subject" cssClass="error"/></td>
        </tr>
        <tr>
            <td>Message name :</td>
            <td><form:input path="message"/></td>
            <td><form:errors path="message" cssClass="error"/></td>
        </tr>
        <tr>
            <td>Date :</td>
            <td><form:input path="date"/></td>
            <td><form:errors path="date" cssClass="error"/></td>
        </tr>
        <tr>
            <td><input type="submit" value="Submit"/></td>
        </tr>
    </table>
</form:form>
</body>
</html>
