<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">

<!-- Optional theme -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap-theme.min.css" integrity="sha384-rHyoN1iRsVXV4nD0JutlnGaslCJuC7uwjduW9SVrLvRYooPp2bWYgmgJQIXwl/Sp" crossorigin="anonymous">

<!-- Latest compiled and minified JavaScript -->
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js" integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" crossorigin="anonymous"></script>

<style type="text/css">
@import url(http://fonts.googleapis.com/earlyaccess/notosanskr.css); 

.div-login-form{
 border-radius : 15px;
 margin-top: 130px;
 box-shadow: 5px 5px 5px 5px lightgray; /* 그림자 */
}

.main-font{
 text-align: center;
 margin-top: 20px;
}
.main-font1{
   font-family: 'Product Sans', Arial, sans-serif;
   color : #0080c0;
   font-size: 55px;
}

.main-font2{
   font-family: 'Product Sans', Arial, sans-serif;
   color : #E64A19;
   font-size: 50px;
}
.main-font3{
   font-family: 'Product Sans', Arial, sans-serif;
   color : #43A047;
   font-size: 50px;
}
.main-font4{
   font-family: 'Product Sans', Arial, sans-serif;
   color : #F9A825;
   font-size: 50px;
}
.main-font5{
   font-family: 'Product Sans', Arial, sans-serif;
   color : #E64A19;
   font-size: 50px;
}
.main-font6{
   font-family: 'Product Sans', Arial, sans-serif;
   color : #0080c0;
   font-size: 50px;
}
.main-font7{
   font-family: 'Product Sans', Arial, sans-serif;
   color : #43A047;
   font-size: 50px;
}
.main-font8{
   font-family: 'Product Sans', Arial, sans-serif;
   color: #F9A825;
   font-size: 50px;
}
.main-font9{
   font-family: 'Product Sans', Arial, sans-serif;
   color: #0080c0;
   font-size: 50px;
}
.main-font10{
   font-family: 'Product Sans', Arial, sans-serif;
   color : #E64A19;
   font-size: 50px;
} 
.signUp-idPass{ 
 margin-top: 10px;
 text-align: right;
 margin-bottom: 30px;
}
 
.signUp{
 font-family: 'Noto Sans KR', sans-serif; 
 color: #0080c0;
 margin-right: 10px;
}

.login-submit{
 font-family: 'Noto Sans KR', sans-serif; 
 margin-top: 10px; 
 background-color: #43A047;
 color: white;
}
.login-submit:hover {
 background-color: #43A047;
 color: white;
}
.input-group{
 margin-top: 8px;
 margin-bottom: 8px;
}
.input-id{
  font-family: 'Noto Sans KR', sans-serif; 
}
.input-pass{
  font-family: 'Noto Sans KR', sans-serif;
  font-size: 8px;
}
.idPassSearch{
 font-family: 'Noto Sans KR', sans-serif; 
 color: #0080c0;
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