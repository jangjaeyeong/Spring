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
	<c:if test="${message != null}">
			<script>
				alert("${message}")
					
					<c:remove var="message" />
			</script>
			
		</c:if>
	<h1>월 회원 목록</h1>
		<table border="1">
		<thead>
			<tr>
				<th>차량 번호</th>
				<th>이름</th>
				<th>전화번호</th>
				<th>만료일</th>
				<th colspan="2">관리</th>
				
			</tr>
		</thead>
		<tbody>
			<c:forEach var="c" items="${memberList}" >
				<tr>
					<td>${c.carNumber}</td>
					<td>${c.name}</td>
					<td>${c.cellphone}</td>
					<td>${c.expireDate}</td>
					<td><a href="/member-find/${c.id}">수정</a></td>
					<td><a href="/member-delete/${c.id}">삭제</a></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	<a href="/">목록으로</a>
</body>
</html>