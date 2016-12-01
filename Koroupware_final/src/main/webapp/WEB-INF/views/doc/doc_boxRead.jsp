<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="css/bootstrap.min.css">
<link rel="stylesheet" type="text/css" href="./css/menu.css"/>
<link rel="stylesheet" href="//maxcdn.bootstrapcdn.com/bootstrap/latest/css/bootstrap.min.css">
<link href='https://fonts.googleapis.com/css?family=Product+Sans:400,400i,700,700i' rel='stylesheet' type='text/css'>
<script src="//code.jquery.com/jquery.min.js"></script>
<script src="//maxcdn.bootstrapcdn.com/bootstrap/latest/js/bootstrap.min.js"></script>
<script  src="http://code.jquery.com/jquery-latest.min.js"></script>

<style type="text/css">
	div.col-md-8{
		margin-top: 10em;
		margin-left: 10em;
	}
</style>
<title>Insert title here</title>
<script type="text/javascript">
	function fn_listDoc(){
		location.href="/doc/docList/${doc_box_no}/${emp_no}";
	}
	function fn_listDoc_box(){
		location.href="/doc/doc_boxList/${emp_no}";
	}
</script>
</head>
<body>
		
		<a href="/doc/doc_boxUpdate/${doc_box.doc_box_no}/${emp_no }">${doc_box.doc_box_name}</a>
		<table border="1" cellpadding="0" cellspacing="0" class="table table-hover">
		<tr height="30">
			<th>문서 이름</th>
			<th>보존 년한</th>
			<th></th>
		</tr>
		<c:forEach var="doc" items="${list}">
			<tr height="30">
				<td><a href="/doc/docRead/${doc.doc_no}/${doc_box_no}/${emp_no}">${doc.doc_title }</a></td>
				<td>${doc.doc_con_period }</td>
				<td><a href="/doc/doc_managementRemove/${doc_box_no}/${doc.doc_no}/${emp_no}">삭제</a></td>
			</tr>
		</c:forEach>
			</table>
			<input type="button" value="문서 전체 목록" onclick="fn_listDoc()" class="btn btn-default">
			<input type="button" value="돌아가기" class="btn btn-default" onclick="fn_listDoc_box()">
		
	
</body>
</html>