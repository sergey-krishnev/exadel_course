<%@ page contentType="text/html;charset=UTF-8;" pageEncoding="UTF-8" language="java" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c"%>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<html>
<head>
    <title>Data Page</title>
    <script src="https://code.jquery.com/jquery-3.2.1.min.js"></script>
</head>
<body>
<h1>Spring MVC Forum Task</h1>
<span style="float: left">
    <a href="?lang=en_US">English</a>
    |
    <a href="?lang=ru">Russian</a>
</span> </br>
Current Locale : ${pageContext.response.locale}
<table border="1" width="1200">
    <tr>
        <td width="15"><b><spring:message code="nickname"/></b></td>
        <td width="25"><b><spring:message code="topic.name"/></b></td>
        <td width="70"><b><spring:message code="subject.name"/></b></td>
        <td width="175"><b><spring:message code="message"/></b></td>
        <td width="15"><b><spring:message code="date"/></b></td>
        <td colspan=2><b><spring:message code="action.page"/></b></td>
    </tr>
    <script>

    </script>
</body>
</html>

