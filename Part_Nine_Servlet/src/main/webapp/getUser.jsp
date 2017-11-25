<%@ page import="ru.aserdyuchenko.servlet.DataSource" %>
<%@ page import="ru.aserdyuchenko.servlet.User" %>
<%--
  User: Anton
  Date: 20.11.2017
  Time: 21:29
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Get user</title>
</head>
<body>
    <input id="inp" type="button" value="Home" onclick="location.href='index.jsp';"/></br>
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
