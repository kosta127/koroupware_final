<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
function cancel(){
		location.href="/schedule/view";
	}
</script>
</head>
<body>

<form method="post">
	<table class="table table-bordered table-hover">
		<tr>
			<td>일자</td>
			<td>${year }년${month }월${day }일</td>
		</tr>
		<tr>
			<td>제목</td>
			<td><input type="text" value="${schedule_title }" name="schedule_title" class="form-control"></td>
		</tr>
		<tr>
			<td colspan="2"><textarea value="${schedule_contents }" name="schedule_contents" class="form-control"></textarea></td>
		</tr>
	</table>
	<input type="hidden" name="year" value="${year}">
	<input type="hidden" name="month" value="${month}">
	<input type="hidden" name="day" value="${day}">
	<input type="hidden" name="schedule_no" value="${schedule_no }">
	<input type="submit" class="btn btn-primary" value="수정">
	<input type="button" class="btn btn-primary" onclick="cancel()" value="취소">
</form>
</body>
</html>