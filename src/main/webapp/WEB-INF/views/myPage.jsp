<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 2022-11-10
  Time: 오전 8:39
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>myPage.jsp</title>
  <link rel="stylesheet" href="/resources/css/bootstrap.css">
</head>
<body>
<jsp:include page="layout/header.jsp" flush="false"></jsp:include>
<div class="container">
  <form action="/myPage" method="post" name="myPageForm" enctype="multipart/form-data">
    <input type="hidden" name="id" value="${findByEmail.id}" class="form-control">
    이메일<input type="text" name="memberEmail" value="${findByEmail.memberEmail}" class="form-control" readonly>
    비밀번호<input type="password" name="memberPassword" id="memberPassword" placeholder="비밀번호 입력" class="form-control">
      이름<input type="text" name="memberName" value="${findByEmail.memberName}" class="form-control">
    전화번호<input type="text" name="memberMobile" value="${findByEmail.memberMobile}" class="form-control">
    프로필사진<input type="file" name="memberFileUpdate" value="${findByEmail.memberProfile}" class="form-control">
    <input type="button" value="회원정보 수정" class="btn btn-warning" onclick="updateMyPage()">
  </form>

</div>
</body>
<script>
  const updateMyPage = () => {
    const passwordDB = '${findByEmail.memberPassword}';
    const password = document.getElementById("memberPassword").value;
    if(passwordDB === password){
      document.myPageForm.submit();
    }else{
      alert("비밀번호가 일치하지 않습니다.");
    }
  }
</script>
</html>
