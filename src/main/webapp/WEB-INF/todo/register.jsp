<%--
  Created by IntelliJ IDEA.
  User: HYUNA
  Date: 2024-09-05
  Time: 오전 9:55
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Register</title>
</head>
<script>
    const reset = function () {
        let title = document.getElementById("title");
        title.setAttribute("value", "");
        let date = document.getElementById("date");
        date.setAttribute("value", "");
    };
</script>
<body>
<form action="/todo/register" method="post">
    <input type="text" name="title" id="title" placeholder="INSERT TITLE">
    <input type="date" id="date" name="dueDate">
    <button onclick="reset()">RESET</button>
    <input type="submit" value="REGISTER">
</form>
</body>
</html>
