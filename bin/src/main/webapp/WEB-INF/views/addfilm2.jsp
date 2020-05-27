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
    <title>添加电影</title>
</head>
<body>
<form action="addfilm" method="post">
    <p>
        标题：<label>
        <input type="text" name="title" autocomplete="on"/>
    </label>
        描述：<label>
        <input type="text" name="description" autocomplete="on"/>
    </label>
        语言ID：<label>
        <input type="text" name="language_id" autocomplete="on"/>
    </label>
    </p>
    <p>
        <input type="submit" value="添加"/>
    </p>
</form>
</body>
</html>
