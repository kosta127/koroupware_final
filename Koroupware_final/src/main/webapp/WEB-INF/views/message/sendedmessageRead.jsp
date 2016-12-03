<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
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

<script src="/resources/jquery-1.9.1/jquery-1.9.1.min.js"></script>
<script type="text/javascript">
	function fn_back(){
		history.go(-1);
	}
</script>
</head>
<body>
	<div>
		<label>받은 사람</label>&nbsp;&nbsp;
		<label>${messageVO.message_receiver_name}</label>
		<br>
		<label>보낸 시간</label>&nbsp;&nbsp;
		<label>${messageVO.message_senddate}</label>
	</div>
	<hr>
	<div>
		${messageVO.message_contents}
	</div>
	
	<input type="button" value="보낸 쪽지함" onclick="fn_back()" class="btn btn-default">
	
</body>
</html>