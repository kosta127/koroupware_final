<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="/resources/bootstrap/css/bootstrap.min.css">
<link rel="stylesheet" type="text/css" href="/resources/bootstrap/css/bootstrap.css"/>
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
		
			<form action="/doc/docUpdate/${doc_no}/${doc_box_no}/${emp_no}" method="post">
				 <div class="row">
		  		<div class="col-sm-3 text">
				문서명 : <input type="text" name="doc_title" class="form-control"><br>
				문서설명 : <input type="text" name="doc_explain" class="form-control"><br>
				문서내용 : <input type="text" name="doc_contents" class="form-control"><br>
				보존년한 : <input type="text" name="doc_con_period" class="form-control"><br>
				문서양식 : <input type="text" name="doc_formYN" class="form-control"><br>
				<br>
				</div>
				</div>
				<input type="submit" value="수정" class="btn btn-default">
				<input type="button" value="돌아가기" class="btn btn-default" onclick="fn_back()">
			</form>
		
	
</body>
</html>