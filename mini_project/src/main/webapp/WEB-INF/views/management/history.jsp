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
	<body>
		<c:if test="${message != null}">
				<script>
					alert("${message}")
						
						<c:remove var="message" />
				</script>
				
			</c:if>
	<h1>입 출차 기록</h1>
		<table border="1">
		<thead>
			<tr>
				<th>차량 번호</th>
				<th>입차 시간</th>
				<th>출차 시간</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="h" items="${history}" >
				<tr>
					<td>${h.carNumber}</td>
					<td>${h.enterTime}</td>
					<td>${h.exitTime}</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	<a href="/">목록으로</a>
</body>
</html>