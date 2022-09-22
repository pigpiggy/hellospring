<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
  
  <form action="/hellospring/delete" method="post">
  <table border=1 cellpadding=0 cellspacing=0>
    <tr>
      <th>no</th>
      <th>lastName</th>
      <th>firstName</th>
      <th>email</th>
    </tr>
    
    <c:forEach items="${list}" var="emaillist"><!-- emaillistVo처럼.. 그래서 밑에 vo.getNo 이런 식으로 꺼내옴 -->
    <tr>
   
      <td>${emaillist.no}</td>  
      <td>${emaillist.lastName}</td>
      <td>${emaillist.firstName}</td>
      <td>${emaillist.email}</td>
      <!--pathvariable<td><a href="/hellospring/delete/${emaillist.no}">삭제</a></td>-->
      <td><a href="/hellospring/delete?no=${emaillist.no}">삭제</a></td>
    </tr>
    </c:forEach>
      
  </table>
  </form>
</body>
</html>


