<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html>
	
	<head>
		<meta charset="UTF-8">
		<title>Member</title>
		<body>
			
			<h1>회원관리</h1>
			<p> 
				<a href="/insertForm.html"> 회원등록 </a>
			</p>
			
			<table border="1">
				<thead>
					<tr>
						<th>No</th>
						<th>회원번호</th>
						<th>이름</th>
						<th>이메일</th>
						<th>나이</th>
					</tr>
				</thead>
				<tbody>
					<c:if test="${empty memberList}">
						<tr>
						<td colspan="5">등록된 회원이 없습니다</td>
						</tr>	
					 </c:if>
					<c:forEach var="member" items="${memberList}" varStatus="status">
						<tr>
							<td> ${status.count}</td>
							<td> ${member.id}</td>
							<td> ${member.name}</td>
							<td> ${member.email}</td>
							<td> ${member.age}</td>
							<td> <a href="/member/delete/${member.id}">삭제</a> </td>
							<td> <a href="/member/update/${member.id}">수정</a> </td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
			
		</body>
	</head>
</html>