<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title><spring:message code="add.page"/></title>
    <script src="http://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
    <style type="text/css">
        .error {
            color: red;
        }
    </style>
</head>
<body>

<h1><spring:message code="add.page"/></h1>
<form:form action="add" modelAttribute="subjectDTO" method="post">

    <spring:message code="nickname"/> : <select id="nickname">
</select> <br/>
    <spring:message code="topic.name"/> : <select id="topic">
</select> <br/>
    <table>
        <tr>
            <td><spring:message code="subject.name"/> :</td>
            <td><input type="text" name="subject"
                       value=""/></td>
            <td><form:errors path="subject" cssClass="error"/></td>
        </tr>
        <tr>
            <td><spring:message code="message"/> :</td>
            <td><input type="text" name="message"
                       value=""/>
            </td>
            <td><form:errors path="message" cssClass="error"/></td>
        </tr>
        <tr>
            <td><spring:message code="date"/> :</td>
            <td><input type="text" name="date"
                       value=""/></td>
            <td><form:errors path="date" cssClass="error"/></td>
        </tr>
        <tr>
            <td><input type="submit" value="<spring:message code="submit.page"/>"/></td>
        </tr>
    </table>
</form:form>
<script type="text/javascript">
    $(document).ready(function () {
        $.getJSON("http://localhost:8080/users", function (data) {
            var usersDTO_data = '';
            $.each(data, function (key, value) {
                usersDTO_data += '<option value="'+value.name+'">'+value.name+'</option>';
            })
            $('#nickname').append(usersDTO_data)
        })

        $.getJSON("http://localhost:8080/topics", function (data) {
            var topicDTO_data = '';
            $.each(data, function (key, value) {
                topicDTO_data += '<option value="'+value.name+'">'+value.name+'</option>';
            })
            $('#topic').append(topicDTO_data)
        })
    });
</script>
</body>
</html>

