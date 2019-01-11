<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title><spring:message code="edit.page"/></title>
    <style type="text/css">
        .error {
            color: red;
        }
    </style>
</head>
<body>

<h1><spring:message code="edit.page"/></h1>
<form:form action="update" modelAttribute="subjectDTO" method="post">

    <spring:message code="nickname"/> : <select name="nickname">
    <c:forEach var="username" items="${users}">
        <option value="${username.nickname}">${username.nickname}</option>
    </c:forEach>
</select> <br/>
    <spring:message code="topic.name"/> : <select name="topic">
    <c:forEach var="topicname" items="${topics}">
        <option value="${topicname.name}">${topicname.name}</option>
    </c:forEach>
</select> <br/>
    <table>
        <tr>
            <td><spring:message code="subject.name"/> :</td>
            <td><form:input path="subject"/></td>
            <td><form:errors path="subject" cssClass="error"/></td>
        </tr>
        <tr>
            <td><spring:message code="message"/> :</td>
            <td><form:input path="message"/></td>
            <td><form:errors path="message" cssClass="error"/></td>
        </tr>
        <tr>
            <td><spring:message code="date"/> :</td>
            <td><form:input path="date"/></td>
            <td><form:errors path="date" cssClass="error"/></td>
        </tr>
        <tr>
            <td><input type="submit" value="<spring:message code="submit.page"/>"/></td>
        </tr>
    </table>
</form:form>
</body>
</html>
