<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 2022-11-07
  Time: 오후 2:04
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>deleteCheck</title>
  <link rel="stylesheet" href="/resources/css/bootstrap.css">
</head>
<body>
<div class="container">
   <input type="password" name="memberPassword" id="memberPassword" placeholder="관리자 비밀번호" class="form-control">
   <button onclick="deleteCheck()" class="btn btn-secondary">확인</button>

</div>
</body>
<script>
  const deleteCheck = () => {
    const passDB = ${memberFindById.memberPassword};
    const passAdmin = document.getElementById("memberPassword").value;
    const id = ${memberFindById.id};
    const emailAdmin = ${memberFindById.memberEmail}
    if(emailAdmin === "admin" && passDB === passAdmin){
      location.href="/delete?id="+id;
    } else{
      alert("비밀번호가 일치하지 않습니다.");
    }
  }
</script>
</html>
