<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title></title>
</head>
<body>
  <form action="/hellospring/add" method="post">
   Last name(성): <input type="text" name="lastName"><br>
   First name(이름): <input type="text" name="firstName"><br> 
   Email address: <input type="text" name="email"><br> 
   <input type="submit" value="등록">
  </form>
 <br>
 
 <p>
 <a href="/hellospring/list">리스트 바로가기</a>
 </p>
      
</body>
</html>


