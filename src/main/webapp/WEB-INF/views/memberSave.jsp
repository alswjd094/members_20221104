<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 2022-11-07
  Time: 오전 8:50
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>memberSave.jsp</title>
    <link rel="stylesheet" href="/resources/css/bootstrap.css">
    <script src="/resources/js/jquery.js"></script>
    <style>
        #save-form{
            width: 800px;
        }
    </style>
</head>
<body>
<div class="container" id="save-form">
    <form action="/save" method="post" name="saveForm" enctype="multipart/form-data">
        <input type="text" name="memberEmail" id="memberEmail" placeholder="이메일" onblur="emailDuplicateCheck()" class="form-control">
        <span id="email-input-check"></span>
        <input type="password" name="memberPassword" id ="memberPassword" placeholder="비밀번호" class="form-control">
        <span id="password-input-check"></span>
        <input type="text" name="memberName" placeholder="이름" class="form-control">
        <span id="name-input-check"></span>
        <input type="text" name="memberMobile" id="memberMobile" placeholder="전화번호" class="form-control">
        <span id="Mobile-input-check"></span>
        <input type="file" name="memberFile" placeholder="프로필사진" class="form-control">
        <input type="button" value="회원가입" onclick="save()" class="btn btn-primary">
    </form>
</div>
</body>
<script>
    const save = () => {
        console.log("save함수호출");
        const exp = /^(?=.*[a-z])(?=.*[A-Z])(?=.*\d)[A-Za-z\d]{4,12}$/;
        const exp2 = /^\d{3}-\d{4}-\d{4}$/;

        if(document.saveForm.memberEmail.value ==""){
            const emailCheck = document.getElementById("email-input-check");
            emailCheck.innerHTML="이메일을 입력해주세요";
            emailCheck.style.color="red";
            return false;
        }else if(document.saveForm.memberPassword.value ==""){
            const passwordCheck = document.getElementById("password-input-check");
            passwordCheck.innerHTML="비밀번호를 입력해주세요";
            passwordCheck.style.color="red";
            return false;
        }else if(!document.saveForm.memberPassword.value.match(exp)){
            const passwordCheck = document.getElementById("password-input-check");
            passwordCheck.innerHTML="영문 소/대문자와 숫자를 이용하여 4~12자 이내로 입력하세요";
            passwordCheck.style.color="red";
            return false;
        }
        else if(document.saveForm.memberName.value ==""){
            const nameCheck = document.getElementById("name-input-check");
            nameCheck.innerHTML="이름을 입력해주세요";
            nameCheck.style.color="red";
            return false;
        }else if(document.saveForm.memberMobile.value ==""){
            const mobileCheck = document.getElementById("mobile-input-check");
            mobileCheck.innerHTML="전화번호를 입력해주세요";
            mobileCheck.style.color="red";
            return false;
        }else if(!document.saveForm.memberMobile.value.match(exp2)) {
            const mobileCheck = document.getElementById("mobile-input-check");
            mobileCheck.innerHTML = "전화번호를 다시 입력해주세요";
            mobileCheck.style.color = "red";
            return false;
        }
        document.saveForm.submit();
    }
    const emailDuplicateCheck = () => {
     const email = document.getElementById("memberEmail").value;
     const checkEmail = document.getElementById("email-input-check");

     $.ajax({
         type:"post",
         url:"/duplicate-check",
         data: {
             inputEmail: email
         },
         dataType:"text",
         success:function (result){
             if(result === "ok"){
                 checkEmail.innerHTML="사용할 수 있는 이메일입니다.";
                 checkEmail.style.color="blue";
             }else{
                 checkEmail.innerHTML="이미 사용중인 이메일입니다.";
                 checkEmail.style.color="red";
             }
         },
         error:function (){
             console.log("실패");
         }
     });
    }
</script>
</html>
