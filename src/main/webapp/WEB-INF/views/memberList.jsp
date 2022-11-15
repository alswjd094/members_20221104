<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 2022-11-07
  Time: 오전 11:37
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>memberList.jsp</title>
  <link rel="stylesheet" href="/resources/css/bootstrap.css">
</head>
<body>
<jsp:include page="layout/header.jsp" flush="false"></jsp:include>
<div class="container">
  <table class="table table-striped table-hover">
    <tr>
      <th>회원번호</th>
      <th>이메일</th>
      <th>비밀번호</th>
      <th>이름</th>
      <th>전화번호</th>
      <th>프로필사진</th>
      <th>회원삭제</th>
    </tr>
    <c:forEach items="${memberList}" var="member">
      <tr>
        <td>${member.id}</td>
        <td>${member.memberEmail}</td>
        <td>${member.memberPassword}</td>
        <td>${member.memberName}</td>
        <td>${member.memberMobile}</td>
        <td><img src="${pageContext.request.contextPath}/uploads/${member.memberProfile}" alt="" width="100" height="100"></td>
        <td><button onclick="deleteFn('${member.id}')" class="btn btn-danger">삭제하기</button></td>
      </tr>
    </c:forEach>
  </table>

</div>
</body>
<script>
const deleteFn = (clickedId) => {
  location.href="/delete?id="+clickedId;
}
</script>
</html>
