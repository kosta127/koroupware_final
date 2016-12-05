<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<!-- jquery -->
<script src="/resources/jquery-1.9.1/jquery-1.9.1.min.js"></script>
<!-- jquery-ui -->
<link href="/resources/jquery-ui-1.12.1/jquery-ui.min.css" rel="stylesheet">
<script src="/resources/jquery-ui-1.12.1/jquery-ui.min.js"></script>
<!-- bootstrap 3.3.2 -->
<link href="/resources/bootstrap-3.3.2-dist/css/bootstrap.min.css" rel="stylesheet">
<script src="/resources/bootstrap-3.3.2-dist/js/bootstrap.min.js"></script>
<!-- magnific popup master : 팝업 -->
<link href="/resources/magnific-popup/magnific-popup.css" rel="stylesheet">
<script src="/resources/magnific-popup/jquery.magnific-popup.min.js"></script>
<!-- mine -->
<script src="/resources/js/todaynews.js"></script>
<link href="/resources/css/todaynews.css" rel="stylesheet">
<title>오늘의 뉴스</title>
</head>
<body>
	<div class="container">
		<ul id="news_tab" class="nav nav-tabs">
		    <li id="news_latest"><a href="#">최신 뉴스</a></li>
		    <li id="news_myclip"><a href="#">내가 스크랩한 뉴스</a></li>
 		</ul>
 		
 		<!-- 최신 뉴스 -->
		<div id="todaynews_div"></div>
		
		<!-- 내가 스크랩한 뉴스 -->
		<div id="myclip_div">
			<table class="table table-hover">
				<thead id="myclip_thead">
					<tr>
						<td>번호</td>
						<td>카테고리</td>
						<td>제목</td>
						<td>스크랩날짜</td>
					</tr>
				</thead>
				<tbody id="myclip_tbody"></tbody>
			</table>
		</div>
	</div>
</body>
</html>