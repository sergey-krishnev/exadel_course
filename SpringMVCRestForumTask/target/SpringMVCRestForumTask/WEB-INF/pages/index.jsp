<%@ page contentType="text/html;charset=UTF-8;" pageEncoding="UTF-8" language="java" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c"%>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<html>
<head>
    <title>Data Page</title>
    <script src="http://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
</head>
<body>
<h1>Spring MVC REST Forum Task</h1>
<span style="float: left">
    <a href="?lang=en_US">English</a>
    |
    <a href="?lang=ru">Russian</a>
</span> </br>
Current Locale : ${pageContext.response.locale}
<table border="1" width="1200" id="subject_table">
    <tr>
        <th width="15"><b><spring:message code="nickname"/></b></th>
        <th width="25"><b><spring:message code="topic.name"/></b></th>
        <th width="70"><b><spring:message code="subject.name"/></b></th>
        <th width="175"><b><spring:message code="message"/></b></th>
        <th width="15"><b><spring:message code="date"/></b></th>
        <th colspan=2><b><spring:message code="action.page"/></b></th>
    </tr>
</table>
<h1><spring:message code="add.page"/></h1>

<table>
    <tr>
        <td><spring:message code="nickname"/> :</td>
        <td><select id="nickname"></select></td>
    </tr>
    <tr>
    <td><spring:message code="topic.name"/> :</td>
        <td><select id="topic"></select></td>
    </tr>
    <tr>
    <td><spring:message code="subject.name"/> :</td>
    <td><input type="text" id="subject"
    value=""/></td>
    </tr>
    <tr>
    <td><spring:message code="message"/> :</td>
    <td><input type="text" id="message"
    value=""/>
    </td>
    </tr>
    <tr>
    <td><spring:message code="date"/> :</td>
    <td><input type="text" id="date"
    value=""/></td>
    </tr>
    <tr>
        <td><button type="button" class ="add"><spring:message code="index.add"/></button></td>
    </tr>
</table>
    <script src="scripts/subject.js"></script>
    <script src="scripts/add.js"></script>
    <script src="scripts/delete.js"></script>
</body>
</html>

