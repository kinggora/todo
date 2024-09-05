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
    <title>Modify</title>
</head>
<body>
<div>${vo.tno}</div>
<form action="/todo/modify" method="post">

    <input type="hidden" name="tno" value="${vo.tno}" readonly>
    <div>
        <input type="text" name="title" value="${vo.title}">
    </div>
    <div>
        <input type="date" name="dueDate" value="${vo.dueDate}">
    </div>
    <div>
        <input type="checkbox" name="finished" ${vo.finished ? "checked": ""}>
    </div>
    <div>
        <input type="submit" value="Modify">
    </div>
</form>
<form action="/todo/remove" method="post">
    <input type="hidden" name="tno" value="${vo.tno}" readonly>
    <div>
        <button type="submit">Remove</button>
    </div>
</form>
</body>
</html>
