<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<!-- 	<script type="text/javascript" src="js/jquery.js"></script>
	<script type="text/javascript" src="js/jquery-ui.min.js"></script>
	<script type="text/javascript" src="js/bootstrap.min.js"></script> -->

<link rel="stylesheet" type="text/css" href="css/jquery-ui.min.css" />
<link rel="stylesheet" type="text/css"
	href="css/jquery-ui.structure.min.css" />
<link rel="stylesheet" type="text/css"
	href="css/jquery-ui.theme.min.css" />
<link rel="stylesheet" type="text/css"
	href="css/bootstrap-theme.min.css" />
<link rel="stylesheet" type="text/css" href="css/bootstrap.min.css" />

<script src="http://code.jquery.com/jquery-latest.min.js"></script>
<link
	href='https://fonts.googleapis.com/css?family=Product+Sans:400,400i,700,700i'
	rel='stylesheet' type='text/css'>
<title>로그인</title>
<!-- 	<link rel="stylesheet" type="text/css" href="css/login.css" />
	<script type="text/javascript" src="js/login.js"></script> -->
</head>
<body>
	<div class="body">
		<div class="panel panel-default">

			<div class="panel-heading">
				<span class="main-font1">K</span> <span class="main-font2">o</span>
				<span class="main-font3">r</span> <span class="main-font4">o</span>
				<span class="main-font5">u</span> <span class="main-font6">p</span>
				<span class="main-font7">w</span> <span class="main-font8">a</span>
				<span class="main-font9">r</span> <span class="main-font10">e</span>
			</div>
			<div class="panel-body">
				<form class="login" action="loginPost" method="post">
					<div class="form-group">
						<div class="input-group">
							<span class="input-group-addon"> <i
								class="glyphicon glyphicon-user" style="width: auto"></i>
							</span> <input id="txtUsuario" type="text" class="form-control"
								name="emp_id" placeholder="Username" />
						</div>
					</div>
					<div class="form-group">
						<div class="input-group">
							<span class="input-group-addon"> <i
								class="glyphicon glyphicon-lock" style="width: auto"></i>
							</span> <input id="txtSenha" type="password" class="form-control"
								name="emp_password" placeholder="Password" />
						</div>
					</div>
					<input type="submit" class="btn btn-default" style="width: 100%"
						value="ENTER">
					<div class="row">
						<div class="col-xs-8">
							<div class="checkbox icheck">
								<label> <input type="checkbox" name="useCookie">
									Remember Me
								</label>
							</div>
						</div>
					</div>
				</form>
				<br>
				<div class="searchIdPass">
					<button id="findUser" class="btn btn-primary">아이디/비밀번호 찾기</button>
					<button id="signUp" class="btn btn-warning">회원 가입</button>
				</div>
			</div>
		</div>
	</div>
</body>

<script>
$(document).ready(
		function() {
			
			$('#findUser').on("click", function(event) {

				self.location = "member/findUser";

			});
			
			$('#signUp').on("click", function(event) {

				self.location = "member/signUp";

			});

		});

</script>

</html>