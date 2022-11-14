<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 2022-11-10
  Time: 오전 9:48
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>memberDetail.jsp</title>
    <link rel="stylesheet" href="/resources/css/bootstrap.css">
</head>
<body>
<div class="container">
    <table class="table table-striped">
        <tr>
            <th>회원번호</th>
            <td>${memberFindById.id}</td>
        </tr>
        <tr>
            <th>이메일</th>
            <td>${memberFindById.memberEmail}</td>
        </tr>
        <tr>
            <th>비밀번호</th>
            <td>${memberFindById.memberPassword}</td>
        </tr>
        <tr>
            <th>이름</th>
            <td>${memberFindById.memberName}</td>
        </tr>
        <tr>
            <th>전화번호</th>
            <td>${memberFindById.memberMobile}</td>
        </tr>
<c:if test="${memberFindById.storedFileName_profile != null}">
        <tr>
            <th>프로필사진</th>
            <td><img src="${pageContext.request.contextPath}/uploads/${memberFindById.storedFileName_profile}" alt="" width="100" height="100"> </td>
        </tr>
</c:if>
    </table>
</div>
</body>
</html>
