<%--
  User: Anton
  Date: 06.12.2017
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>Login view</title>
</head>
<body>
<form action='${pageContext.servletContext.contextPath}/signin' method='post'>
    Login : <input type='text' name='login'/><br/>
    Password : <input type='password' name='password'/><br/>
    <input type='submit'>
</form>
</body>
</html>
