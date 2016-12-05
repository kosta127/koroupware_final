<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script src="/resources/jquery-1.9.1/jquery-1.9.1.min.js"></script>
<script type="text/javascript">
var receiverEmpNo;
function fn_receivedmessageList(){
	location.href="/message/receivedmessageList/"+${emp_no};
}		
$(document).ready(function(){
		$("form .search").on("click",function(event){
			var emp_no = ${emp_no};
			event.preventDefault();
			window.open("/message/messageSearch/"+emp_no,"test","width=600,height=300,location=yes");
		});
		$(".receiver_name").on("click",function(){
			var emp_no = ${emp_no};
			
			window.open("/message/messageSearch/"+emp_no,"test","width=600,height=300,location=yes");
		})
		$("#emp_name").click(function(){
			if($(this).is(":checked")){
				$(".receiver_name").attr("value","${emp_name}");
				var html = "<input type='hidden' name='message_receiver_no' value="+${emp_no}+">";
				$("form").prepend(html);
			}
			else {
				$(".receiver_name").attr("value","");
			}
		});
	});
		
function receiver(receiver){
	$(".receiver_name").attr("value",receiver.receiver_name);
	var html ="<input type='hidden' name='message_receiver_no' value="+receiver.receiver_no+">";
	$("form").prepend(html);
}
</script>

</head>
<body>
	<form action="/message/messageRegist/${emp_no}" method="post">

		받는사람 : <input type="checkbox" name="emp_name" id="emp_name"> 내게 쓰기
		<input type="text" name="message_receiver_name" class="receiver_name">
		<button class="search">검색</button><br>
		<textarea name="message_contents" rows="5" cols="55" title="쪽지내용 입력"></textarea>
		<input type="submit" value="전송">
		<input type="button" value="돌아가기" onclick="fn_receivedmessageList()">
	</form>
	
</body>
</html>