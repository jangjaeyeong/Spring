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
		
	<h1>현재 입차 정보</h1>
		<table border="1">
		<thead>
			<tr>
				<th>차량 번호</th>
				<th>입차 시간</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="c" items="${currentList}" >
				<tr>
					<td>${c.carNumber}</td>
					<td>${c.enterTime}</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	<a href="/">목록으로</a>
</body>
</html>