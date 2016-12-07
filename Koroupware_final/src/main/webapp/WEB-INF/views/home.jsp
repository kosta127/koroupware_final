<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<head>
	<meta charset="UTF-8">
	<title>Home</title>
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
	<!-- news js&css -->
	<script src="/resources/js/todaynews.js"></script>
	<link href="/resources/css/todaynews.css" rel="stylesheet">
	<!-- map js&css -->
	<script src="//apis.daum.net/maps/maps3.js?apikey=92bef817e206b1f4c06f9d6ccdf1ca20&libraries=services"></script>
	<link href="/resources/css/map.css" rel="stylesheet">
	<script src="/resources/js/map.js"></script>
	<!-- home -->
	<link href="/resources/css/home.css" rel="stylesheet">
</head>
<body>   
	<!-- 오늘의 뉴스 시작 -->
	<div id="main_news" class="col-md-6 shadow">
		<ul id="news_tab" class="nav nav-tabs">
			    <li id="news_latest"><a href="#">최신 뉴스</a></li>
			    <li id="news_myclip"><a href="#">내가 스크랩한 뉴스</a></li>
	 		</ul> 
	 		    
	 		<!-- 최신 뉴스 -->
			<div id="todaynews_div"><div id="news_list_div"></div></div>
			
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
	<!-- 오늘의 뉴스 끝 -->
	<div class="col-md-1 margin-main"><!-- 여백용 --></div>
	<!-- 중간지점 찾기 시작 -->  
	<div id="main_map" class="col-md-5 shadow">
		<div class="map_wrap">
			<div id="map"
				style="width: 100%; height: 100%; position: relative; overflow: hidden;"></div>
			<ul id="category">
				<li id="SW8"><span class="category_bg subway"></span> 지하철</li>
				<li id="CE7"><span class="category_bg cafe"></span> 카페</li>
			</ul>
		</div>
		
		<button class="btn btn-primary center-point-section" id="search_btn">중간지점 탐색</button>
	</div>
	<!-- 중간지점 찾기 끝-->
<body>
	<!-- 오늘의 뉴스 시작 -->
	<div id="main_news" class="col-md-6 shadow">
		<ul id="news_tab" class="nav nav-tabs">
			    <li id="news_latest"><a href="#">최신 뉴스</a></li>
			    <li id="news_myclip"><a href="#">내가 스크랩한 뉴스</a></li>
	 		</ul> 
	 		    
	 		<!-- 최신 뉴스 -->
			<div id="todaynews_div"><div id="news_list_div"></div></div>
			
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
	<!-- 오늘의 뉴스 끝 -->
	<div class="col-md-1 margin-main"><!-- 여백용 --></div>
	<!-- 중간지점 찾기 시작 -->  
	<div id="main_map" class="col-md-5 shadow">
		<div class="map_wrap">
			<div id="map"
				style="width: 100%; height: 100%; position: relative; overflow: hidden;"></div>
			<ul id="category">
				<li id="SW8"><span class="category_bg subway"></span> 지하철</li>
				<li id="CE7"><span class="category_bg cafe"></span> 카페</li>
			</ul>
		</div>
		
		<button class="btn btn-primary center-point-section" id="search_btn">중간지점 탐색</button>
	</div>
	<!-- 중간지점 찾기 끝-->
</body>
</html>
