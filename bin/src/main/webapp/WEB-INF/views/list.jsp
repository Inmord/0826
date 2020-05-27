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
    <title></title>
</head>
<body>
<h3><a href="/addfilm2" target="_blank">增加 </a></h3>
<table>
    <tr>
        <th>ID</th>
        <th>标题</th>
        <th>描述</th>
        <th>语言</th>
    </tr>

    <c:forEach items="${ls}"  var="l" varStatus="stus">
        <tr>
            <td>${l.film_id}</td>
            <td>${l.title}</td>
            <td>${l.description}</td>
            <c:set var="check" value="${l.language_id}" scope="request"/>
            <c:if test="${check==1}"><td>English</td></c:if>
                <c:if test="${check==2}"><td>Italian</td></c:if>
                <c:if test="${check==3}"><td>Japanese</td></c:if>
                <c:if test="${check==4}"><td>Mandarin</td></c:if>
                <c:if test="${check==5}"><td>French</td></c:if>
                <c:if test="${check==6}"><td>German</td></c:if>
            <td>
                <a href="../user/delete?id=${l.film_id}" target="_blank">删除</a>
                <a href="../user/t?id=${l.film_id}" target="_blank">修改</a>
            </td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
