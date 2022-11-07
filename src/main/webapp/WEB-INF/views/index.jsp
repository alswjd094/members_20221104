<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 2022-11-07
  Time: 오전 8:27
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>index.jsp</title>
    <link rel="stylesheet" href="/resources/css/bootstrap.css">
</head>
<body>
<button onclick="saveFn()" class="btn btn-primary">회원가입</button>
<button onclick="loginFn()" class="btn btn-primary">로그인</button>
<button onclick="listFn()" class="btn btn-primary">글목록</button>
</body>
<script>
    const saveFn = () => {
        location.href="/save";
    }
    const loginFn = () => {
     location.href="/login";
    }
    const listFn = () => {
        location.href="/admin";
    }
</script>
</html>
