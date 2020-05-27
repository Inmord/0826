<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Insert title here</title>
</head>
<body>
<form action="../user/update" method="post">
    ID：<input type="text" name="id" value="${u.id}" readonly><br>
    姓名：<input type="text" name="name" value="${u.name}"><br>
    地址：<input type="text" name="address" value="${u.address}"><br>
    电话：<input type="text" name="phone" value="${u.phone}"><br>
    <input type="submit" value="提交" />
</form>
</body>
</html>