<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<style type="text/css">
.check-table{
 
 text-align: center;
 border-radius: 3px;
   box-shadow: 2px 2px 2px 2px lightgray; 
 
}
</style>
<title>Insert title here</title>
</head>
<body>
	<h2>'${login.emp_name}' 사원의 출석 현황</h2>
	<table class="table table-striped check-table">
		<tr> 
			<td>회원 번호</td>
			<td>날짜</td>
			<td>지각여부</td>
			<td>출석여부</td>
			<td>비고</td>
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
					<td></td>
			</tr>
		</c:forEach>

	</table>


</body>
</html>