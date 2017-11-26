<%@ page import="ru.aserdyuchenko.servlet.User" %>
<%@ page import="ru.aserdyuchenko.servlet.DataSource" %>
<%--
  User: Anton
  Date: 26.11.2017
  Time: 16:25
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Delete user</title>
</head>
<body>
<input id="inp" type="button" value="Home" onclick="location.href='index.jsp';"/><br>

<form action='<%=request.getContextPath()%>/deleteUser' method='post'>
    Login : <input type='text' name='login'/><br/>
    <input type='submit'>
</form>

<table style="width:100%">
    <tr>
        <th>Login</th>
        <th>Name</th>
        <th>Email</th>
        <th>Create date</th>
    </tr>
    <%for (User user : DataSource.getInstance().getList()) {%>
    <tr>
        <td><%=user.getLogin()%></td>
        <td><%=user.getName()%></td>
        <td><%=user.getEmail()%></td>
        <td><%=user.getCreateDate()%></td>
    </tr>
    <%}%>
</table>
</body>
</html>
