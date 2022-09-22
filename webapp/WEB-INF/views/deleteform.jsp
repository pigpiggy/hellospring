<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title></title>
</head>
<script>
   function check(){
      var password = document.getElementById("password"); //사용자가 jsp페이지에서 입력하는 비번
      if(${param.password}!=password.value){
         alert("비밀번호가 틀렸습니다. 다시 입력해 주세요.");
         password.focus();
         return false;
      }
   }
</script>
<body>
  <form action="/hellospring/guestbookdelete" method="post">
  <input type="hidden" name="no" value="${param.no}">
  <input type="hidden" name="pass" value="${param.pass}">
   
   <td align="center">
   password(비밀번호): <input type="password" id="password" name="password"> 
   </td>
   <input type="submit" value="삭제" onClick="return check();" >
   
  </form>
 <br>
 
 <p>
 <a href="/hellospring/getGuestbookList">리스트 바로가기</a>
 </p>
      
</body>
</html>


