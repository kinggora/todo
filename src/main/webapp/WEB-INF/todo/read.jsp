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
    <title>Todo Read Page</title>
</head>
<body>
<div>${vo.tno}</div>
<div>${vo.title}</div>
<div>${vo.dueDate}</div>
<div><input type="checkbox" ${vo.finished ? "checked": ""} disabled /></div>
<a href="/todo/modify?tno=${vo.tno}">Modify/Remove</a>
<a href="/todo/list">List</a>
</body>
</html>
