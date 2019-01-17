<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c"%>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<html>
<head>
    <title>Data Page</title>
    <meta charset="utf-8">
    <script src="http://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
</head>
<body>
<h1>Spring MVC REST Forum Task</h1>
<%--<span style="float: left">--%>
    <%--<a href="?lang=en_US">English</a>--%>
    <%--|--%>
    <%--<a href="?lang=ru">Russian</a>--%>
<%--</span> </br>--%>
<span style="float: left">
    <a href="?lang=en_US">English</a>
    |
    <a href="?lang=ru">Russian</a>
</span> </br>
Current Locale :
<div id ="lang">${pageContext.response.locale}</div>
<table border="1" width="1200" id="subject_table">
    <tr>
        <th width="15"><div class = "nicknameLocale"></div></th>
        <th width="25"><div class = "topicLocale"></div></th>
        <th width="70"><div class = "subjectLocale"></div></th>
        <th width="175"><div class = "messageLocale"></div></th>
        <th width="15"><div class = "dateLocale"></div></th>
        <th colspan=2><div class = "actionLocale"></div></th>
    </tr>
</table>
<h1 id="addPageLocale"></h1>

<table>
    <tr>
        <td class="nicknameLocale"></td>
        <td>:</td>
        <td><select id="nickname"></select></td>
    </tr>
    <tr>
    <td class = "topicLocale"></td>
        <td>:</td>
        <td><select id="topic"></select></td>
    </tr>
    <tr>
    <td class = "subjectLocale"></td>
        <td>:</td>
    <td><input type="text" id="subject"
    value=""/></td>
    </tr>
    <tr>
    <td class = "messageLocale"></td>
        <td>:</td>
    <td><input type="text" id="message"
    value=""/>
    </td>
    </tr>
    <tr>
    <td class = "dateLocale"></td>
        <td>:</td>
    <td><input type="text" id="date"
    value=""/></td>
    </tr>
    <tr>
        <td><button type="button" class ="add"></button></td>
    </tr>
</table>
    <script src="scripts/jquery.i18n.properties.js"></script>
    <script src="scripts/subject.js"></script>
    <script src="scripts/add.js"></script>
    <script src="scripts/delete.js"></script>
    <script src="scripts/updateForm.js"></script>
    <script src="scripts/update.js"></script>
</body>
</html>

