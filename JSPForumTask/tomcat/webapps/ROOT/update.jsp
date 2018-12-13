<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
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
</head>
<body>
<c:if test="${subject != null}">
<h1>Update record</h1>
<form action="/ActionServlet" method="post">
    <input type="hidden" value="update" name="action" />
    </c:if>
<c:if test="${subject == null}">
<h1>Add new record</h1>
     <form action="/ActionServlet" method="post">
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
        value="<c:out value="${subject.name}" />" /> <br />
    Message name : <input
        type="text" name="message"
        value="<c:out value="${subject.message}" />" /> <br />
    Date : <input
        type="text" name="date"
        value="<fmt:formatDate pattern="MM-dd-yyyy" value="${subject.dateSending}" />" />   <br />
</c:if>
         <c:if test="${subject == null}">
         Subject name : <input
             type="text" name="subject"
             value="<c:out value="" />" /> <br />
         Message name : <input
             type="text" name="message"
             value="<c:out value="" />" /> <br />
         Date : <input
             type="text" name="date"
             value="" />   <br />
         </c:if>


    <input type="submit" value="Submit" />
</form>
</body>
</html>

