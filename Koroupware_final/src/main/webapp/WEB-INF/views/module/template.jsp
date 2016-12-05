<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
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
<style type="text/css">
.main-header{
    box-shadow: 0px 0px 0.3px 0.3px lightgray; 
}
.main-leftMenubar{
 box-shadow: 0px 0.3px 0.3px 0px lightgray; 
}
</style>
</head>
<body> 
	<!-- 헤더영역 -->
	<div class="main-header col-md-12">
	<tiles:insertAttribute name="header"/>
	</div>
	<!-- 왼쪽 메뉴바 -->
	<div class="main-leftMenubar col-md-2">
	<tiles:insertAttribute name="leftMenubar"/>
	</div>
	<!-- 바디영역 -->
	<div class="main-body col-md-10">
	<tiles:insertAttribute name="body"/>
	</div>
	<!-- 푸터영역 -->
	<div class="main-footer col-md-12">
	<tiles:insertAttribute name="footer"/>
    </div>
</body>
</html>







