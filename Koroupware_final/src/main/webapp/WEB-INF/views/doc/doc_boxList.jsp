<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<!-- jquery -->
<script src="/resources/jquery-1.9.1/jquery-1.9.1.min.js"></script>
<!-- jquery-ui -->
<link href="/resources/jquery-ui-1.12.1/jquery-ui.min.css"
	rel="stylesheet">
<script src="/resources/jquery-ui-1.12.1/jquery-ui.min.js"></script>
<!-- bootstrap 3.3.2 -->
<link href="/resources/bootstrap-3.3.2-dist/css/bootstrap.min.css"
	rel="stylesheet">
<script src="/resources/bootstrap-3.3.2-dist/js/bootstrap.min.js"></script>
<!--  -->
<link href='https://fonts.googleapis.com/css?family=Product+Sans:400,400i,700,700i' rel='stylesheet' type='text/css'>

<style type="text/css">
	.blank{
		height : 50px;
	}
</style>
</head>

<body>
		<div class="col-md-12 blank"></div>
		<div>
		
	
		<table border="1" cellpadding="0" cellspacing="0" class="table table-hover">
		<tr height="30">
			<th>no</th>
			<th>문서함명</th>
			<th>생성일</th>
			<th></th>
		</tr>
		<c:forEach var="doc_box" items="${list}">
			<tr>
				<td>${doc_box.doc_box_no }</td>
				<td><a href="/doc/doc_boxRead/${doc_box.doc_box_no}/${emp_no}">${doc_box.doc_box_name }</a></td>
				<td>${doc_box.doc_box_regdate }</td>
				<td><a href="/doc/doc_boxRemove/${doc_box.doc_box_no}/${emp_no}">삭제</a></td>
			</tr>
		</c:forEach>
		
	</table>
	<form action="/doc/doc_boxRegist" method="get">
		<input type="hidden" name="emp_no" value="${emp_no}">
		<input type="submit" value="문서함 생성" class="btn btn-default">
	</form>

		</div>

	
</body>
</html>