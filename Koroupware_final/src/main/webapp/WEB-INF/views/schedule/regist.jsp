<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
<!-- jquery -->
<script src="/resources/jquery-1.9.1/jquery-1.9.1.min.js"></script>
<!-- jquery-ui -->
<link href="/resources/jquery-ui-1.12.1/jquery-ui.min.css" rel="stylesheet">
<script src="/resources/jquery-ui-1.12.1/jquery-ui.min.js"></script>
<!-- bootstrap 3.3.2 -->
<link href="/resources/bootstrap-3.3.2-dist/css/bootstrap.min.css" rel="stylesheet">
<script src="/resources/bootstrap-3.3.2-dist/js/bootstrap.min.js"></script>
<!-- printTool -->
<script src="/resources/printTool/jQuery.print.js"></script>
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
				<td>${year}년${month}월${day}일</td>
			</tr>
			<tr>
				<td>제목</td>
				<td><input type="text" value="${schedule_title }" name="schedule_title" class="form-control"></td>
			</tr>
			<tr>
				<td colspan="2""><textarea value="${schedule_contents }" name="schedule_contents" class="form-control"></textarea></td>
			</tr>
		</table>
		
		<select name="joinList" class="form-control">
			<option value="dept_name"
				<c:out value="${dept_name }"/>>
			</option>	
			</select>
		
		<input type="hidden" name="year" value="${year}">
		<input type="hidden" name="month" value="${month}">
		<input type="hidden" name="day" value="${day}">
		<input type="submit" class="btn btn-primary" value="등록">
		<input type="button" class="btn btn-primary" onclick="cancel()" value="취소">
	</form>
	
</body>
</html>