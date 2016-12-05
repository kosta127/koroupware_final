<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
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
<link rel="stylesheet" type="text/css" href="/resources/empDataUpdate/css/empDataUpdate.css">
	<script type="text/javascript" src="/resources/empDataUpdate/js/empDataUpdate.js"></script>
<title>Insert title here</title>
</head>
<body>
<div class="col-md-1"></div>
<div class="col-md-10 center-form">
<div class="col-md-12 top-span">
<div class="col-md-4"></div>
<div class="col-md-4">
<span>회원정보</span>
</div>
<div class="col-md-4"></div>
</div>
<form action="empDataUpdate/update" method="post">
<div class="col-md-12">
<input type="hidden" class="emp_no" name="emp_no" value="${login.emp_no }">
<div class="col-md-2 font-div">
<span>비밀번호</span>
</div>
<div class="col-md-4">
<input type="password" class="form-control emp_password1" name="emp_password">
</div>
<div class="col-md-2 font-div">
<span>비밀번호 확인</span>
</div>
<div class="col-md-4">
<input type="password" class="form-control emp_password2">
</div>
</div>
<div class="col-md-12"><div class="col-md-12"><div class="col-md-6"></div><div class="col-md-6 passError1 passError2"></div></div></div> <!-- 비밀번호 에러칸 -->
<div class="col-md-12">
<div class="col-md-2 font-div">
<span>이름</span>
</div>
<div class="col-md-4">
<input type="text" class="form-control" name="emp_name" value="${login.emp_name }">
</div>

<div class="col-md-2 font-div">
<span>이메일</span>
</div>
<div class="col-md-4">
<input type="text" class="form-control" name="emp_email" value="${login.emp_email }">
</div>
</div>
<div class="col-md-12">
<div class="col-md-2 font-div">
<span>주소</span>
</div>
<div class="col-md-6">
<input type="text" class="form-control" id="sample6_address" name="emp_address" value="${login.emp_address }">
</div>
<div class="col-md-4">
<input type="button" onclick="sample6_execDaumPostcode()" class="btn btn-block" value="주소찾기">
</div>
</div>
<div class="col-md-12 img-div">
<c:if test="${login.emp_img eq null }">
<div class="col-md-2 font-div"> 
<span>사진</span>
</div>
<div class="col-md-4 img-div">
<div class="emp-img-fileDrop" id="emp-img-fileDrop"><span class="img-text">사진을 넣어주세요.</span></div>
<div class="emp-img-uploadedFile" id="emp-img-uploadedFile"></div>
</div>
</c:if>
<c:if test="${login.emp_img ne null }">
<div class="col-md-2 font-div"> 
<span>사진</span>
</div>
<div class="col-md-4 img-div">
<img src="http://localhost:8081/empDataUpdate/displayFile?fileName=${login.emp_img }">
<input type="hidden" value="${login.emp_img }" name="emp_img">
</div>
</c:if>
<c:if test="${login.emp_elec_auth_img eq null }"> 
<div class="col-md-2 font-div">
<span>결재사진</span>
</div>
<div class="col-md-4">
<div class="emp-elec-auth-img-fileDrop" id="emp-elec-auth-img-fileDrop"><span class="img-text">사진을 넣어주세요.</span></div>
<div class="emp-elec-auth-img-uploadedFile" id="emp-elec-auth-img-uploadedFile"></div>
</div>
</c:if>
<c:if test="${login.emp_elec_auth_img ne null }">
<div class="col-md-2 font-div"> 
<span>결재사진</span>
</div>
<div class="col-md-4">
<img src="http://localhost:8081/empDataUpdate/displayFile?fileName=${login.emp_elec_auth_img }">
<input type="hidden" value="${login.emp_elec_auth_img }" name="emp_elec_auth_img">
</div>
</c:if>
</div>
<div class="col-md-12">
<div class="col-md-2 font-div">
<span>결재사인키</span> 
</div>
<div class="col-md-4">
<input type="password" class="form-control" name="emp_elec_auth_signkey">
</div>
</div> 
<div class="col-md-12 middle-span">
<div class="col-md-4"></div>
<div class="col-md-4">
<span>전화번호</span>
</div>
<div class="col-md-4"></div>
</div>
<div class="col-md-12">
<div class="col-md-1 font-div">
<span>용도</span>
</div>
<div class="col-md-2">
<input type="text" class="form-control tel-type" name="tel_type">
</div>
<div class="col-md-1 font-div">
<span>번호</span>
</div>
<div class="col-md-2"> 
 <input type="text" maxlength="3" class="form-control tel-telephone-left" name="tel_telephone_left">  
</div> 
<div class="col-md-2"> 
 <input type="text" maxlength="4" class="form-control tel-telephone-center" name="tel_telephone_center">
</div>
<div class="col-md-2"> 
 <input type="text" maxlength="4" class="form-control tel-telephone-right" name="tel_telephone_right">
</div>
<div class="col-md-2">
<input type="button" class="btn btn-block" id="addTel" value="추가">
</div>
<div class="col-md-12 tel-list-font">
 <span>전화번호 목록</span>
</div>
<div class="col-md-12">
<div class="col-md-12" id ="telList">
<div class="col-md-3 font-div font-center">
<span>용도</span>
</div>
<div class="col-md-7 font-div font-center">
<span>번호</span>
</div>
<div class="col-md-2"></div>
</div>
</div>
</div>
<div class="col-md-6">
<input type="submit" class="btn btn-block update-submit" value="수정">
</div>
<div class="col-md-6">
<input type="button" onclick="main()" value="취소" class="btn btn-block cancel-button"> <!-- 취소 버튼 -->
</div>
</form>
</div>
<div class="col-md-1"></div>
<div class="col-md-12 emp-update-bottom-void"></div>
</body>
</html>