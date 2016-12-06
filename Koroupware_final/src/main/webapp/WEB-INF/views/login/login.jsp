<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">

<!-- Optional theme -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap-theme.min.css" integrity="sha384-rHyoN1iRsVXV4nD0JutlnGaslCJuC7uwjduW9SVrLvRYooPp2bWYgmgJQIXwl/Sp" crossorigin="anonymous">

<!-- Latest compiled and minified JavaScript -->
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js" integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" crossorigin="anonymous"></script>
<link rel="stylesheet" type="text/css" href="/resources/login/css/login.css">
<style type="text/css">
body{
	background-image: url("/displayFile?fileName=desktop.jpg");
	background-repeat: no-repeat;
	background-position: center;
	background-size: 100%;
}

.div-login-form{
	background-color: white;

}
</style>
</head>
<body>
<div class="col-md-4">
</div>
<div class="col-md-4 div-login-form">
<div class="col-md-12 main-font">
<span class="main-font1">K</span><span class="main-font2">o</span><span class="main-font3">r</span><span class="main-font4">o</span><span class="main-font5">u</span><span class="main-font6">p</span><span class="main-font7">w</span><span class="main-font8">a</span><span class="main-font9">r</span><span class="main-font10">e</span>
<div class="col-md-12">
<form action="loginPost" method="post">
<div class="input-group">
 <span class="input-group-addon"><i class="glyphicon glyphicon-user"></i></span>
 <input type="text" class="form-control input-id" name="emp_id">
 </div>
<div class="input-group">
 <span class="input-group-addon"><i class="glyphicon glyphicon-lock"></i></span>
 <input type="password" class="form-control input-pass" name="emp_password">
 </div>
<input type="submit" value="로그인" class="btn btn-lg btn-block login-submit">
</form>
</div>
<div class="col-md-12 signUp-idPass">
<a href="signUp" class="signUp">회원가입</a>
<a href="idPassSearch" class="idPassSearch">아이디/비밀번호 찾기</a>
</div>
<div class="col-md-12"></div>
</div>
<div class="col-md-4">
</div> 
</div>
</body>
</html>