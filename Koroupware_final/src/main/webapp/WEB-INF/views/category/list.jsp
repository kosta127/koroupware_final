<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>

</head>

<body>
	<h1>카테고리</h1>
	<form action="regist" method="get">
	<input type="hidden" value="${community_no }" name="community_no">
	<button id="createCategory">카테고리 생성</button>
	<ul id="categories">
		<c:forEach items="${list }" var="categoryVO">	
			<div class="category_name">
				<div><a href="../board/list?category_no=${categoryVO.category_no }">${categoryVO.category_name}</a></div>
			</div>
		</c:forEach>
	</ul>
	</form>

</body>
</html>