<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>dkdkdkdkdkdk</h1>
	<table border="1px">
		<tr>
			<td>회원 번호</td>
			<td>날짜</td>
			<td>지각여부</td>
			<td>출석여부</td>
		</tr>
		<c:forEach items="${attendList}" var="List">
			<tr>
				<td>${List.emp_no}</td>
				<td>${List.attend_date}</td>

					<td><c:choose>
						<c:when test="${List.late eq 1}">
	 					o
	 					</c:when>
						<c:when test="${List.late eq 0}">
	 					x
						</c:when>
					</c:choose></td>

					<td><c:choose>
						<c:when test="${List.attend_chk eq 1}">
						 o
						 </c:when>	 
						<c:when test="${List.attend_chk eq 0}">
						 x
						</c:when>
					</c:choose></td>
			</tr>
		</c:forEach>

	</table>


</body>
</html>