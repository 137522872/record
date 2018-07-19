<%--
  Created by IntelliJ IDEA.
  User: os
  Date: 2018/7/18
  Time: 19:55
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jstl/core" %>
<html>
<head>
    <title>办公用品详情页</title>
</head>
<body>

    <table>
        <c:forEach items="${allDemo}" var="demo">
            <tr>
                <td>${demo.id}</td>
                <td>${demo.name}</td>
            </tr>
        </c:forEach>
    </table>
</body>
</html>
