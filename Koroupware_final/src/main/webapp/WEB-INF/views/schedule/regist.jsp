<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
</head>
<body>
<h1>${emp_no }</h1>
<h1>${scheduleVO.schedule_no }</h1>
<h1>${day }</h1>
	<form action="/regist/${year}/${month}/${day}" method="post">
		<table border="1">
			<tr>
				<td>일자</td>
				<td>${year}년${month}월${day}일</td>
			</tr>
			<tr>
				<td>제목</td>
				<td><input type="text" value="${schedule_title }" name="schedule_title"></td>
			</tr>
			<tr>
				<td></td>
				<td><input type="text" ${schedule_contents } name="schedule_contents"></td>
			</tr>
		</table>
		
		<input type="submit" class="btn btn-primary" value="등록">
	</form>
	
</body>
</html>