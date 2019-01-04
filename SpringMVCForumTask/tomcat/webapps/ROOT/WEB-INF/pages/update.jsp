<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
<c:if test="${subject != null}">
    <title>Edit record</title>
</c:if>
    <c:if test="${subject == null}">
        <title>New record</title>
    </c:if>
    <style type="text/css">
        .error {
            color: red;
        }
    </style>
</head>
<body>
<c:if test="${subject != null}">
<h1>Update record</h1>
<form action="/home" modelAttribute="subjectDTO" method="post">
    <input type="hidden" value="update" name="action" />
    </c:if>
<c:if test="${subject == null}">
<h1>Add new record</h1>
     <form action="/home" modelAttribute="subjectDTO" method="post">
         <input type="hidden" value="add" name="action" />
    </c:if>


    Nickname : <select name="nickname">
    <c:forEach var="username" items="${users}">
         <option value="${username.nickname}">${username.nickname}</option>
    </c:forEach>
     </select> <br />
    Topic name :  <select name="topic">
         <c:forEach var="topicname" items="${topics}">
             <option value="${topicname.name}">${topicname.name}</option>
         </c:forEach>
     </select> <br />
         <c:if test="${subject != null}">
    Subject name : <input
        type="text" name="subject"
        value="<c:out value="${subject.name}" />" />
             <br />
    Message name : <input
        type="text" name="message"
        value="<c:out value="${subject.message}" />" />
             <br />
    Date : <input
        type="text" name="date"
        value="<fmt:formatDate pattern="yyyy-MM-dd" value="${subject.dateSending}" />" />   <br />
</c:if>
         <c:if test="${subject == null}">
         Subject name : <input
             type="text" name="subject"
             value="<c:out value="" />" />
             <form:errors path="subject" cssClass="error"/><br />
         Message name : <input
             type="text" name="message"
             value="<c:out value="" />" />
             <form:errors path="message" cssClass="error"/><br />
         Date : <input
             type="text" name="date"
             value="" />
             <form:errors path="date" cssClass="error"/><br />
         </c:if>


    <input type="submit" value="Submit" />
</form>
</body>
</html>

