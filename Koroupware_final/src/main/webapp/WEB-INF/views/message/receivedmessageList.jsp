<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" href="/resources/bootstrap/css/bootstrap.min.css">
<link rel="stylesheet" type="text/css" href="/resources/bootstrap/css/bootstrap.css"/>
<link rel="stylesheet" href="//maxcdn.bootstrapcdn.com/bootstrap/latest/css/bootstrap.min.css">
<link href='https://fonts.googleapis.com/css?family=Product+Sans:400,400i,700,700i' rel='stylesheet' type='text/css'>
<script src="//code.jquery.com/jquery.min.js"></script>
<script src="//maxcdn.bootstrapcdn.com/bootstrap/latest/js/bootstrap.min.js"></script>
<script  src="http://code.jquery.com/jquery-latest.min.js"></script>

<!-- jquery -->
<script src="/resources/jquery-1.9.1/jquery-1.9.1.min.js"></script>
<script type="text/javascript">
	function fn_messageRegist(){
		location.href="/message/messageRegist/"+${emp_no};
	}
	
	function fn_sendedmessageList(){
		location.href="/message/sendedmessageList/"+${emp_no};
	}
	
	
</script>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<style type="text/css">
.blank {
	height: 50px;
}
.receive-list{
 box-shadow: 2px 2px 2px 2px lightgray; 
 border-radius: 5px;
 margin-top:15px;
}
</style>
</head>
<body>
	<div class="col-md-12 blank"></div>
	<div>
	<form action="/message/messageRemove/received/${emp_no}" method="post" class="messageForm">
	<input type="button" value="쪽지쓰기" onclick="fn_messageRegist()" class="btn btn-default">
	<input type="button" value="보낸쪽지" onclick="fn_sendedmessageList()" class="btn btn-default">
	<input type="submit" value="삭제" class="btn btn-default">
	
	<table width="600" class="table table-hover receive-list">
	
		<tr>
			<th width="50">선택</th>
			<th width="110">보낸사람</th>
			<th width="330">내용</th>
			<th width="110">날짜</th>
		</tr>
		
		<c:forEach var="messageVO" items="${list}">
			<c:if test="${messageVO.message_deldate==null}">
			<tr>
				
				<%-- <td><input type="hidden" name="message_no" value="${messageVO.message_no }"></td> --%>
				<td width="50"><input type="checkbox" name="message_no" class="message_no" value="${messageVO.message_no}"></td>
				<td width="110"><a href="/message/receivedmessageRead/${messageVO.message_no}">${messageVO.message_sender_name}</a></td>
				<td width="330">${messageVO.message_contents }</td>
				<td width="110">${messageVO.message_senddate }</td>
			</tr>
			</c:if>
			
		</c:forEach>
		</table>
		</form>
	</div>
	
		
		
	
</body>
</html>