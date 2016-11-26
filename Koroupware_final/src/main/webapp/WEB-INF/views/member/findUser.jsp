<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="/lib/bootstrap.min.css">
<link rel="stylesheet" type="text/css" href="./css/Findform.css"/>
<link rel="stylesheet" href="//maxcdn.bootstrapcdn.com/bootstrap/latest/css/bootstrap.min.css">
<script src="//code.jquery.com/jquery.min.js"></script>
<script src="//maxcdn.bootstrapcdn.com/bootstrap/latest/js/bootstrap.min.js"></script>
<script  src="http://code.jquery.com/jquery-latest.min.js"></script>
<title>아이디/비밀번호 찾기</title>

</head>
<body>
<div class="col-xs-12 main-logo">
<span class="main-font1">K</span><span class="main-font2">o</span><span class="main-font3">r</span><span class="main-font4">o</span><span class="main-font5">u</span><span class="main-font6">p</span><span class="main-font7">w</span><span class="main-font8">a</span><span class="main-font9">r</span><span class="main-font10">e</span><span class="signUp-main">아이디/비밀번호 찾기<span>
 </div>
	<div class="find-all">
		<div class="row1">
			<div class="col-xs-5">
				<span class="find-id-search">아이디 찾기</span>
				<form action="FindId" method="post">
						<span class="residentnumber">주민번호</span> 
						<input type="text" name="emp_residentnumber" class="form-control">
					<br> <input type="submit" class="find-id btn btn-primary" value="아이디 찾기">

				</form>
			</div>
		</div>
		
		<div class="row2">
			<div class="col-xs-5">
				<span class="find-pass-search">비밀번호 찾기</span>
				<form action="FindPwd" method="post">
						<span class="my-id">아이디</span> 
						<input type="text" name="emp_id" class="input-id form-control">
						<span class="residentnumber">주민번호</span> 
						<input type="text" name="emp_residentnumber" class="form-control">
					
					<br> <input type="submit" class="find-pass btn btn-primary" value="비밀번호 찾기">
				</form>
			</div>
		</div>

	</div> 




</body>
</html>

