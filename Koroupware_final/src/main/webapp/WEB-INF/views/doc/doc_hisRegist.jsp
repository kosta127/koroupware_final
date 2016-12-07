<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="css/bootstrap.min.css">
<link rel="stylesheet" type="text/css" href="./css/menu.css"/>
<link rel="stylesheet" href="//maxcdn.bootstrapcdn.com/bootstrap/latest/css/bootstrap.min.css">
<link href='https://fonts.googleapis.com/css?family=Product+Sans:400,400i,700,700i' rel='stylesheet' type='text/css'>
<script src="//code.jquery.com/jquery.min.js"></script>
<script src="//maxcdn.bootstrapcdn.com/bootstrap/latest/js/bootstrap.min.js"></script>
<script  src="http://code.jquery.com/jquery-latest.min.js"></script>
<script type="text/javascript">
	function fn_back(){
		history.back(-1);
	}
</script>
<title>Insert title here</title>
</head>
<body>

			<form action="/doc/doc_hisRegist/${doc_no}/${doc_box_no}/${emp_no}" method="post">
			 <div class="row">
		  		<div class="col-sm-3 text">
				변경사유 : <input type="text" name="doc_his_reason_change" class="form-control"><br>
				재개정여부 : <input type="text" name="doc_his_revise" class="form-control"><br>
				</div>
				</div>
			<input type="submit" value="수정완료" class="btn btn-default">
			<input type="button" value="돌아가기" onclick="fn_back()" class="btn btn-default">
			</form>
	
	
	
</body>
</html>