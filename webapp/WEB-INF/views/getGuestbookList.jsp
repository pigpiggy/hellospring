<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
  <form action="/hellospring/insert" method="post">
 <table border='1'>
      <tr>
        <td>이름</td>
        <td><input type="text" name="name" size="30px"></td>
        <td>비밀번호</td>
        <td><input type="password" name="password" size="20px"></td>
      </tr>
      <tr>
        <td colspan="4"><textarea name="content" cols="60" rows="10"></textarea></td>
      </tr>
      <tr>
        <td colspan="4"><input type="submit" value="확인"></td>
      </tr>
  </table>
   <br>
  <br>
  </form>
   
    <table border=1 cellpadding=0 cellspacing=0 style="width:545px">
    <tr>
      <th>no</th>
      <th>name</th>
      <th>content</th>
      <th>reg_date</th>
    </tr>
   
      <c:forEach items="${guestbookList}" var="guestbook">
    <tr>
     <td>${guestbook.no}</td>
     <td>${guestbook.name}</td>
     <td>${guestbook.content}</td>
     <td>${guestbook.regDate}</td>
     <td><a href="/hellospring/deleteform?no=${guestbook.no }&pass=${guestbook.password}">삭제</a></td>
    </tr>
    </c:forEach>
  </table>
    
  
</body>
</html>