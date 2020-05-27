<%--
  Created by IntelliJ IDEA.
  User: xulei
  Date: 2019/7/19
  Time: 17:31
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>添加用户</title>
</head>
<body>
<h3><a href="../user/add" target="_blank">增加 </a></h3>
<table>
    <tr>
        <th>ID</th>
        <th>姓名</th>
        <th>地址</th>
        <th>电话</th>
    </tr>

    <c:forEach items="${ls}"  var="l" varStatus="stus">
        <tr>
            <td>${l.id}</td>
            <td>${l.name}</td>
            <td>${l.address}</td>
            <td>${l.phone}</td>
            <td>
                <a href="" target="_blank">查看</a>
                <a href="../user/delete?id=${l.id}" target="_blank">删除</a>
                <a href="../user/t?id=${l.id}" target="_blank">修改</a>
            </td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
