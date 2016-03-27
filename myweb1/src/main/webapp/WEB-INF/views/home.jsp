<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2016/3/22
  Time: 23:50
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>home</title>
</head>
<body>
Spring MVC 测试

<form action="login.do" method="post">
    username:<input type="text" name="username"/>

    <p>
    password:<input type="password" name="password"/>

    <p>
        <input type="submit" value="submit"/>
</form>

<%--访问other.jsp 时报错，访问html, action, do 都可以--%>
<%--<a href="./WEB-INF/views/three.html">other page</a>--%>
<%--<a href="index.jsp">other page</a>--%>
<a href="other.jsp">other page</a>
</body>
</html>
