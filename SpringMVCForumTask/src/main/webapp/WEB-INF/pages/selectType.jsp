<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Choose the type: </title>
</head>
<body>
<h1>Select the type:</h1>
<form action="/ActionServlet" method="post">
    <input type="hidden" value="selectType" name="action" />
    <select name="type">
        <option value="0">Query</option>
        <option value="1">Criteria</option>
    </select> <br/>
    <p><input type="submit" value="Submit"></p>
</form>
</body>
</html>
