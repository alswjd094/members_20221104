<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 2022-11-07
  Time: 오전 11:12
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>memberMain.jsp</title>
    <link rel="stylesheet" href="/resources/css/bootstrap.css">
</head>
<body>
<button onclick="logout()" class="btn btn-danger">로그아웃</button>
</body>
<script>
    const logout = () => {
        location.href="/logout";
    }
</script>
</html>
