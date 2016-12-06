<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>	
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
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
<!-- <script type="text/javascript">
$(document).ready(function(){
	$("#create").on('click', function(){
		var communityObj = $("#community_name");
		var community_name = $("#community_name").val();
		var emp_no = ${emp.emp_no};
		
		$.ajax({
			type:'post',
			url:'community/regist'+emp_no,
			headers:{
				"Content-Type":"application/json",
				"X-HTTP-Method-Override":"POST"
			},
			dataType:'text',
			data:JSON.stringify({
				emp_no : emp_no, 
				community_name : community_name
				}),
			
			success:function(msg){
				console.log("result:"+msg);
				if(msg=='SUCCESS'){
					alert("등록");
					communityObj.val("");
					location.reload();
				}
			}
		});
	});
});
</script> -->

</head>
<body>

<form method="post">
	<input type="hidden" value="${emp_no}" name="emp_no" id="emp_no"/> 
	<h1>${emp_no}</h1>
	<table border="1" cellpadding="0" cellspacing="0">
		<tr height="10">
			<td align="center">커뮤티니 명:</td>
			<td>
<<<<<<< HEAD
				<textarea cols="40" rows="1" name="community_name" id="communityName" class="form-control"></textarea>
=======
				<textarea cols="40" rows="1" name="community_name" id="communityName"></textarea>
>>>>>>> refs/remotes/origin/lks_2016/12/07_test
			</td>
			<td colspan="4">
				<input id="create" type="submit" value="생성" class="btn btn-primary">
			</td>
		</tr>
	</table>
</form>

</body>
</html>