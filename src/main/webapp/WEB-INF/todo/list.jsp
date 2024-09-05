<%--
  Created by IntelliJ IDEA.
  User: HYUNA
  Date: 2024-09-05
  Time: 오전 9:55
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <title>Todo List</title>
</head>

<body>
<h1>Todo List</h1>
<ul>
    <c:forEach var="todo" items="${list}">
        <li>
            <a href="/todo/read?tno=${todo.tno}">${todo.tno}</a>
                ${todo.title} ${todo.dueDate}
            <c:choose>
            <c:when test="${todo.finished}">
            DONE
            </c:when>
            <c:otherwise>
            NOT YET
            </c:otherwise>
            </c:choose>
        </li>
    </c:forEach>
</ul>
</body>
</html>
