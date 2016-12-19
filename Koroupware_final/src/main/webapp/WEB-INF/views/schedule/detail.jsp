<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
function sche_view(){
	location.href="/schedule/view";
}
function sche_modify(){
	location.href="/schedule/modify/${year}/${month}/${day}/${schedule_no}";
}
function sche_delete(){
	location.href="/schedule/delete/${schedule_no}";
}
</script>
</head>
<body>

<form action="detail">
<input type="hidden" name="schedule_no" value="${scheduleVO.schedule_no }">
	<table border="1" class="table table-bordered table-hover">
		<tr>
			<td>일자</td>
			<td>${year }년${month }월${day }일</td>
		</tr>
		<tr>
			<td>제목</td>
			<td>${scheduleVO.schedule_title }</td>
		</tr>
		<tr>
			<td colspan="2">${scheduleVO.schedule_contents }</td>
		</tr>
	</table>
	
	<input type="button" class="btn btn-default" value="목록" onclick="sche_view()">
	<input type="button" class="btn btn-default" value="수정" onclick="sche_modify()">
	<input type="button" class="btn btn-default" value="삭제" onclick="sche_delete()">
	
</form>
</body>
</html>