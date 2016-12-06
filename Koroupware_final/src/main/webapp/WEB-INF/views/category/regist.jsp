<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>

<body>
 
<form method="post" action="regist">
	<input type="hidden" value="${community_no}" name="community_no" id="community_no"/> 
	<p>카테고리명</p>
	<input type="text" name="category_name" id="category_name" class="form-control">
	<input id="create" type="submit" value="생성" class="btn btn-primary">
	
</form>
</body>
</html>