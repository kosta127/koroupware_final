<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
</head>
<body>
<form method="post">
	<input type="hidden" value="1" name="emp_no"/> 
	<table border="1" cellpadding="0" cellspacing="0">
		<tr height="10">
			<td align="center">커뮤티니 명:</td>
			<td>
				<textarea cols="40" rows="1" name="community_name"></textarea>
			</td>
			<td colspan="4">
				<input type="submit" value="생성" class="btn btn-primary">
			</td>
		</tr>
	</table>
</form>
</body>
</html>