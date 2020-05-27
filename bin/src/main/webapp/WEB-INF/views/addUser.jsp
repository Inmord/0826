<%--
  Created by IntelliJ IDEA.
  User: xulei
  Date: 2019/7/19
  Time: 17:31
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <head>
    <title>添加用户</title>
    </head>
    <body>
<form action="../user/a" method="post">
    <p>
        姓名：<label>
        <input type="text" name="name" autocomplete="on"/>
        </label>
        地址：<label>
        <input type="text" name="address" autocomplete="on"/>
        </label>
        电话：<label>
        <input type="text" name="phone" autocomplete="on"/>
        </label>
    </p>
<p>
    <input type="submit" value="添加"/>
</p>
</form>
</body>
</html>
