<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
  <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">

<!-- Optional theme -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap-theme.min.css" integrity="sha384-rHyoN1iRsVXV4nD0JutlnGaslCJuC7uwjduW9SVrLvRYooPp2bWYgmgJQIXwl/Sp" crossorigin="anonymous">

<!-- Latest compiled and minified JavaScript -->
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<script src="http://dmaps.daum.net/map_js_init/postcode.v2.js"></script>
<script src="/resources/jquery-1.9.1/jquery-1.9.1.min.js"></script>
<!-- jquery-ui -->
<link href="/resources/jquery-ui-1.12.1/jquery-ui.min.css" rel="stylesheet">
<script src="/resources/jquery-ui-1.12.1/jquery-ui.min.js"></script>
<link rel="stylesheet" type="text/css" href="/resources/signUp/css/signUp.css">
	<script type="text/javascript" src="/resources/signUp/js/signUp.js"></script>
	<style type="text/css">
	
		body{
			background-image: url("/displayFile?fileName=desktop.jpg");
			background-repeat: no-repeat;
			background-position: center;
			background-size: 100%;
		}
		
		.center-form{
			background-color: white;
		
		}
	</style>
</head>
<body>
<div class="col-md-2"></div> <!-- 왼쪽 여백 div -->
<div class="col-md-8">
<div class="col-md-12 center-form">
<div class="col-md-12 logo-font">
<span class="main-font1">K</span><span class="main-font2">o</span><span class="main-font3">r</span><span class="main-font4">o</span><span class="main-font5">u</span><span class="main-font6">p</span><span class="main-font7">w</span><span class="main-font8">a</span><span class="main-font9">r</span><span class="main-font10">e</span>
</div>
<form action="signUp" method="post"> <!-- 폼 시작 -->
<div class="col-md-12"> 
<div class="col-md-2 font-div"> <!-- 아이디 시작  -->

<span>아이디</span> 
</div>  
<div class="col-md-4">
<input type="text" class="form-control emp_id" name="emp_id">
<div class="idError">
<div class="col-md-12 idError1 idError2"></div>
</div>
</div>
<!-- 아이디 끝  -->
<div class="col-md-2 font-div"> <!-- 이름 시작 -->
<span>이름</span>
</div>
<div class="col-md-4">
<input type="text" class="form-control" name="emp_name">
</div>
</div> <!-- 이름 끝 -->
<div class="col-md-12"> <!-- 비밀번호 시작 -->
<div class="col-md-2 font-div">
<span>비밀번호</span>
</div>
<div class="col-md-4">
 <input type="password" class="form-control emp_password1" maxlength="10" name="emp_password">
</div>
<div class="col-md-2 font-div"> 
<span>비밀번호 확인</span>
</div> 
<div class="col-md-4">
<input type="password" class="form-control emp_password2" maxlength="15">
</div>
</div> <!-- 비밀번호 끝 -->
<div class="col-md-12"><div class="col-md-12"><div class="col-md-6"></div><div class="col-md-6 passError1 passError2"></div></div></div> <!-- 비밀번호 에러칸 -->
<div class="col-md-12"> <!-- 주민번호 시작 -->
<div class="col-md-2 font-div">
<span>주민등록번호</span>
</div>
<div class="col-md-5">
<input type="text" class="form-control" maxlength="6" name="emp_residentNum_left"> 
</div>
<div class="col-md-5">
<input type="password" class="form-control" maxlength="7" name="emp_residentNum_right">
</div>
</div> <!-- 주민번호 끝 -->
<div class="col-md-12"> <!-- 이메일 시작  -->
<div class="col-md-2 font-div">
<span>이메일</span>
</div>
<div class="col-md-4">
  <input type="text" class="form-control" name="emp_email">
</div>
<div class="col-md-2 font-div">
<span >결재사인키</span>
</div>
<div class="col-md-4">
<input type="password" class="form-control emp_elec_auth_signkey" name="emp_elec_auth_signkey">
</div>
</div> <!-- 이메일 끝 -->
<div class="col-md-12"> <!-- 전화번호 시작  -->
<div class="col-md-2 font-div">
<span>전화번호</span>
</div>
<div class="col-md-2"> 
 <input type="text" maxlength="3" class="form-control inputs" name="tel_telephone_left">  
</div> 
<div class="col-md-4"> 
 <input type="text" maxlength="4" class="form-control inputs" name="tel_telephone_center">
</div>
<div class="col-md-4"> 
 <input type="text" maxlength="4" class="form-control" name="tel_telephone_right">
</div> <!-- 전화번호 끝 --> 
</div>
<div class="col-md-12">
<div class="col-md-2 font-div">
<span>주소</span>
</div>
<div class="col-md-8">
<input type="text" id="sample6_address" class="form-control" name="emp_address">
</div>
<div class="col-md-2">
<input type="button" onclick="sample6_execDaumPostcode()" value="주소찾기" class="btn btn-block addressSearch-button"> <!-- butto태그로 하면 안됨 -->
</div>
</div>
<div class="col-md-12 center-form-bottom">
 <div class="col-md-2">
</div>
<div class="col-md-4">
</div>
<div class="col-md-2"></div>
<div class="col-md-2">
<input type="submit" class="btn btn-block signUp-submit" value="확인"> <!-- 폼 끝 -->
</div>
<div class="col-md-2">
<input type="button" onclick="cancel()" value="취소" class="btn btn-block cancel-button"> <!-- 취소 버튼 -->
</div>
</div> 
</form>
<div class="col-md-12 bottom-void"></div>
</div>
</div>
<div class="col-md-2"></div> <!-- 오른쪽 여백 div -->
</body>
</html>