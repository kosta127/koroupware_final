<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="css/bootstrap.min.css">
<link rel="stylesheet" type="text/css" href="./css/menu.css"/>
<link rel="stylesheet" href="//maxcdn.bootstrapcdn.com/bootstrap/latest/css/bootstrap.min.css">
<style type="text/css">
	form{
		width: 500px;
		
	}
	form .form-control{
		width: 300px;
	}
	
</style>
<link href='https://fonts.googleapis.com/css?family=Product+Sans:400,400i,700,700i' rel='stylesheet' type='text/css'>
<script src="//code.jquery.com/jquery.min.js"></script>
<script src="//maxcdn.bootstrapcdn.com/bootstrap/latest/js/bootstrap.min.js"></script>
<script  src="http://code.jquery.com/jquery-latest.min.js"></script>
<script type="text/javascript">
	function fn_back(){
		history.go(-1);
	}
</script>
<style type="text/css">
	.blank{
		height: 50px;
	}
</style>
</head>
<body>
		<div class="col-md-12 blank"></div>
		<div>
		<form action="/doc/doc_boxRegist" method="post">
		<input type="hidden" name="emp_no" value="${emp_no }" >
		<input type="text" name="doc_box_name" class="form-control" placeholder="문서함명을 입력하세요">
		<br>
		<input type="submit" value="생성" class="btn btn-default">
		<input type="button" value="돌아가기" class="btn btn-default" onclick="fn_back()">
		</form>
		
		</div>
		
	
</body>
</html>