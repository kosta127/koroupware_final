<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
<link rel="stylesheet" href="//maxcdn.bootstrapcdn.com/bootstrap/latest/css/bootstrap.min.css">
<link href='https://fonts.googleapis.com/css?family=Product+Sans:400,400i,700,700i' rel='stylesheet' type='text/css'>
<link rel="stylesheet" href="//fonts.googleapis.com/earlyaccess/nanumgothic.css">
<!-- <link rel="stylesheet" type="text/css" href="./css/signUp.css"/> -->
<script src="//code.jquery.com/jquery.min.js"></script>
<script src="//maxcdn.bootstrapcdn.com/bootstrap/latest/js/bootstrap.min.js"></script>
<script  src="http://code.jquery.com/jquery-latest.min.js"></script>
<script type="text/javascript" src="http://ajax.googleapis.com/ajax/libs/jquery/1.6.2/jquery.min.js"></script>
<script type="text/javascript" src="https://ajax.googleapis.com/ajax/libs/jqueryui/1.8.14/jquery-ui.min.js"></script>
<script type="text/javascript">
function login() {
	location.href = "loginGo.do";
}
</script>
</head>
<body>
<div class="col-xs-12 main-logo">
<span class="main-font1">K</span><span class="main-font2">o</span><span class="main-font3">r</span><span class="main-font4">o</span><span class="main-font5">u</span><span class="main-font6">p</span><span class="main-font7">w</span><span class="main-font8">a</span><span class="main-font9">r</span><span class="main-font10">e</span><span class="signUp-main">회원가입<span>
 </div>
<div class="sign-form">

 <form action="SignUpAction.do" method="post">
 <div class="col-xs-5">
  <span class="span">아이디</span> <input type="text" name="emp_id" class="form-control" placeholder="아이디를 입력해주세요."><br>
  <span class="span">비밀번호</span> <input type="password" name="emp_password" class="form-control" placeholder="비밀번호를 입력해주세요."><br>
 <span class="span">이름</span> <input type="text" name="emp_name" class="form-control" placeholder="이름을 입력해주세요."><br>
 <span class="span">주민등록번호</span> <input type="text" name="emp_residentnumber" class="form-control" placeholder="주민등록번호를 입력해주세요."><br>
 <span class="span">핸드폰</span> <input type="radio" name="tel_type" value="핸드폰"><span class="span radio-button">일반전화</span><input type="radio" name="tel_type" value="일반전화"><br><span class="span">번호</span><input type="text" name="tel_telephone" class="form-control" placeholder="전화번호를 입력해주세요."><br>
 </div>
 
 <div class="col-xs-6"> 
 <span class="span">이메일</span> <input type="text" name="emp_email" class="form-control" placeholder="이메일을 입력해주세요."><br>	
 <span class="span">주소</span> <input type="text" name="emp_address" class="form-control" placeholder="주소를 입력해주세요."><br>
 <span class="span">사원이미지</span> <input type="file" name="emp_img" id="icondemo"><br>
 <span class="span">결재사인</span> <input type="file" name="emp_elec_auth_img" class="filestyle"><br>
 <span class="span">결재사인키</span> <input type="password" name="emp_elec_auth_signkey" class="form-control">
 <br> 
  <input class="btn btn-primary sign-submit-button" type="submit" value="가입">
  <button class="btn btn-danger" onclick="login()">취소</button>
   </div>
</form>
 </div>
</body>
</html>