<%@ page import="ru.aserdyuchenko.servlet.Storage" %>
<%--
  Created by IntelliJ IDEA.
  User: Anton
  Date: 20.11.2017
  Time: 21:29
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Get user</title>
</head>
<body>
<input id="inp" type="button" value="Home" onclick="location.href='index.jsp';"/></br>
<%--<table style="width:100%">--%>
    <%--<tr>--%>
        <%--<th>Login</th>--%>
        <%--<th>Name</th>--%>
        <%--<th>Email</th>--%>
        <%--<th>Create date</th>--%>
        <%--</tr>--%>
    <%
        try {
            Class.forName("org.postgresql.Driver");
            Storage storage = new Storage();
            storage.getList().toString();

        } catch (Exception e) {
            e.printStackTrace();
        }

//        for (User user : storage.getList()) {
    %>
    <%--<%}%>--%>

    <%--</table>--%>
</body>
</html>
