<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="jakarta.tags.core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="/css/style.css">
<title>회원 목록</title>
</head>
<body>
	<h1>기존 회원 정보</h1>
<form action="/member-update" method="get">
    <c:forEach  var="m" items="${memberInfo}"> 
    <label>
        <input type="hidden" name="id" value="${m.id}" required="required">
    </label> <br>
    <label>차량 번호: 
        <input type="text" name="carNumber" value="${m.carNumber}" required="required">
    </label> <br>
    
    <label>이름: 
        <input type="text" name="name" value="${m.name}" required="required">
    </label> <br>
    
    <label>전화번호:
        <input type="text" name="cellphone" value="${m.cellphone}" required="required">
    </label> <br>
    </c:forEach>
    <button>정보 업데이트</button>
</form>

	<a href="/">목록으로</a>
</body>
</html>