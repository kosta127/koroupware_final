<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<!-- Latest compiled and minified CSS -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">

<!-- Optional theme -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap-theme.min.css" integrity="sha384-rHyoN1iRsVXV4nD0JutlnGaslCJuC7uwjduW9SVrLvRYooPp2bWYgmgJQIXwl/Sp" crossorigin="anonymous">

<!-- Latest compiled and minified JavaScript -->
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js" integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" crossorigin="anonymous"></script>
</head>
<style>
.main-body{
 height : 500px;
 border: 1px solid black;
}
.main-header{
 border: 1px solid black;
 text-align: center;
}
.main-footer{
 border: 1px solid black;
}

.main-leftMenubar{
 height : 500px;
 border : 1px solid black;
}
</style>
<body>
	<!-- 헤더영역 -->
	<div class="main-header col-md-12">
	<tiles:insertAttribute name="header"/>
	여기가 헤더
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







