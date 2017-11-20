<%--
  Created by IntelliJ IDEA.
  User: Anton
  Date: 20.11.2017
  Time: 21:11
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Add user</title>
</head>
<body>
<form action="<%=request.getContextPath()%>/users" method="post">
    Login: <input type="text" name="login"><br/>
    <input type="submit">
</form>
<br/>
<table>
    <th>
        <td>Login</td>

    </th>
</table>
</body>
</html>
