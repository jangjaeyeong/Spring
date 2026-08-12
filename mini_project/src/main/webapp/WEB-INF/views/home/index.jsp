<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="jakarta.tags.core"%>
    
   
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="/css/style.css">
<title>Insert title here</title>
</head>
<body>
<c:if test="${message != null}">
		<script>
			alert("${message}")
				
				<c:remove var="message" />
		</script>
		
	</c:if>
	<h1>주차 관리 프로그램</h1>
	<a href="/parking/insertMember.html">회원 등록</a><br>
	<a href="/parking/insertParking.html">입차</a> <br>
	<a href="/parking/exitParking.html">출차</a> <br>
	<a href="/parking-list">주차 현황</a> <br>
	<a href="/parking-history">입출차 기록</a> <br>
	<a href="/member-list">회원 목록</a> <br>
</body>
</html>

