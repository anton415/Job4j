<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%--
  User: Anton
  Date: 20.11.2017
--%>
<html>
<head>
    <title>Add user</title>
</head>
<body>
<input id="inp" type="button" value="Home" onclick="location.href='homeUser';"/></br>

<form action='${pageContext.servletContext.contextPath}/addUser' method='post'>
    Login : <input type='text' name='login'/><br/>
    Name : <input type='text' name='name'/><br/>
    Email : <input type='text' name='email'/><br/>
    Date : <input type='text' name='createDate'/><br/>
    <input type='submit'>
</form>

<table style="border: #000000"; cellpadding="1"; border="1">
    <tr>
        <th>Login</th>
        <th>Name</th>
        <th>Email</th>
        <th>Create date</th>
    </tr>
    <c:forEach items="${users}" var="user">
        <tr>
            <td><c:out value="${user.login}"></c:out></td>
            <td><c:out value="${user.name}"></c:out></td>
            <td><c:out value="${user.email}"></c:out></td>
            <td><c:out value="${user.createDate}"></c:out></td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
