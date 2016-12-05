<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
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
@import url(http://fonts.googleapis.com/earlyaccess/notosanskr.css);

.main-font1 {
	font-family: 'Product Sans', Arial, sans-serif;
	color: #0080c0;
	font-size: 55px;
}

.main-font2 {
	font-family: 'Product Sans', Arial, sans-serif;
	color: #E64A19;
	font-size: 50px;
}

.main-font3 {
	font-family: 'Product Sans', Arial, sans-serif;
	color: #43A047;
	font-size: 50px;
}

.main-font4 {
	font-family: 'Product Sans', Arial, sans-serif;
	color: #F9A825;
	font-size: 50px;
}

.main-font5 {
	font-family: 'Product Sans', Arial, sans-serif;
	color: #E64A19;
	font-size: 50px;
}

.main-font6 {
	font-family: 'Product Sans', Arial, sans-serif;
	color: #0080c0;
	font-size: 50px;
}

.main-font7 {
	font-family: 'Product Sans', Arial, sans-serif;
	color: #43A047;
	font-size: 50px;
}

.main-font8 {
	font-family: 'Product Sans', Arial, sans-serif;
	color: #F9A825;
	font-size: 50px;
}

.main-font9 {
	font-family: 'Product Sans', Arial, sans-serif;
	color: #0080c0;
	font-size: 50px;
}

.main-font10 {
	font-family: 'Product Sans', Arial, sans-serif;
	color: #E64A19;
	font-size: 50px;
}

.font-div {
	text-align: center;
	margin-top: 20px;
	font-family: 'Noto Sans KR', sans-serif;
	font-size: 13px;
}

.idSearch-button {
	background-color: #43A047;
	color: white;
	font-family: 'Noto Sans KR', sans-serif;
	font-size: 13px;
}

.idSearch-button:hover {
	background-color: #43A047;
	color: white;
	font-family: 'Noto Sans KR', sans-serif;
	font-size: 13px;
}

.passSearch-button {
	background-color: #F9A825;
	color: white;
	font-family: 'Noto Sans KR', sans-serif;
	font-size: 13px;
}

.passSearch-button:hover {
	background-color: #F9A825;
	color: white;
	font-family: 'Noto Sans KR', sans-serif;
	font-size: 13px;
}

.button-div {
	margin-top: 20px;
	margin-bottom: 30px;
	text-align: right;
}

.logo-font {
	text-align: center;
	margin-top: 30px;
	margin-bottom: 50px;
}

input {
	margin-top: 15px;
	margin-bottom: 15px;
}

.back-button {
	margin-top: 5px;
	background-color: #E64A19;
	color: white;
	font-family: 'Noto Sans KR', sans-serif;
	font-size: 13px;
}

.back-button:hover {
	background-color: #E64A19;
	color: white;
	font-family: 'Noto Sans KR', sans-serif;
	font-size: 13px;
}

.other-button-div {
	margin-top: 50px;
}

.signUp-button {
	margin-top: 5px;
	background-color: #0080c0;
	color: white;
	font-family: 'Noto Sans KR', sans-serif;
	font-size: 13px;
}

.signUp-button:hover {
	background-color: #0080c0;
	color: white;
	font-family: 'Noto Sans KR', sans-serif;
	font-size: 13px;
}

.left-form-top-div {
	margin-top: 30px;
}

.right-form-top-div {
	margin-top: 30px;
}

.left-form {
	border-radius: 15px;
	margin-top: 30px;
	box-shadow: 5px 5px 5px 5px lightgray;
}

.right-form {
	border-radius: 15px;
	margin-top: 30px;
	box-shadow: 5px 5px 5px 5px lightgray;
}

.void-div {
	margin-bottom: 10px;
}

.void-top-div {
	margin-top: 15px;
}
</style>
<script type="text/javascript">
	function cancel() {
		history.back();
	}
</script>
</head>
<body>
	<div class="col-md-1"></div>
	<div class="col-md-10">
		<div class="col-md-12 logo-font">
			<span class="main-font1">K</span><span class="main-font2">o</span><span
				class="main-font3">r</span><span class="main-font4">o</span><span
				class="main-font5">u</span><span class="main-font6">p</span><span
				class="main-font7">w</span><span class="main-font8">a</span><span
				class="main-font9">r</span><span class="main-font10">e</span>
		</div>

		<form action="FindId" method="post">
			<div class="col-md-6 left-form">
				<div class="col-md-12 void-top-div"></div>
				<div class="col-md-12 left-form-top-div">
					<div class="col-md-3 font-div">
						<span>이름</span>
					</div>
					<div class="col-md-9">
						<input type="text" class="form-control">
					</div>
				</div>
				<div class="col-md-12">
					<div class="col-md-3 font-div">
						<span>주민등록번호</span>
					</div>
					<div class="col-md-4">
						<input type="text" name="emp_residentNum_left"
							class="form-control">
					</div>
					<div class="col-md-5">
						<input type="password" name="emp_residentNum_right"
							class="form-control">
					</div>
				</div>


				<div class="col-md-12">
					<div class="col-md-4"></div>
					<div class="col-md-8 button-div">
						<button onclick="" class="btn btn-block idSearch-button">아이디
							찾기</button>
					</div>
					<div class="col-md-12 void-div"></div>
				</div>
			</div>
		</form>
		<div class="col-md-1"></div>
		<div class="col-md-5 right-form">
			<div class="col-md-12 void-top-div"></div>
			<div class="col-md-12 right-form-top-div">
				<div class="col-md-3 font-div">
					<span>아이디</span>
				</div>
				<div class="col-md-9">
					<input type="text" class="form-control">
				</div>
			</div>
			<div class="col-md-12">
				<div class="col-md-3 font-div">
					<span>이메일</span>
				</div>
				<div class="col-md-9">
					<input type="text" class="form-control">
				</div>
				<div class="col-md-4"></div>
				<div class="col-md-8 button-div">
					<button onclick="" class="btn btn-block passSearch-button">비밀번호
						찾기</button>
				</div>
				<div class="col-md-12 void-div"></div>
			</div>
		</div>
		<div class="col-md-6"></div>
		<div class="col-md-6">
			<div class="col-md-12 other-button-div">
				<div class="col-md-6"></div>
				<div class="col-md-6">
					<button onclick="cancel()" class="btn btn-block back-button">돌아가기</button>
				</div>
			</div>
		</div>
		<div class="col-md-12 void-div"></div>
	</div>
	<div class="col-md-1"></div>
</body>
</html>