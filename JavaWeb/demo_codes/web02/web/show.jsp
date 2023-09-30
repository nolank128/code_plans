<%--
  Created by IntelliJ IDEA.
  User: SuperBob
  Date: 2023/9/20
  Time: 10:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <table>
        <tr>
            <td>stuid</td>
            <td>stuname</td>
            <td>age</td>
            <td>sex</td>
        </tr>
        <c:forEach items="${stulist}" var="stu">
            <tr>
                <td>${stu.stuId}</td>
                <td>${stu.stuName}</td>
                <td>${stu.age}</td>
                <td>${stu.sex==1?'男':'女'}</td>
            </tr>

        </c:forEach>
    </table>
</body>
</html>
