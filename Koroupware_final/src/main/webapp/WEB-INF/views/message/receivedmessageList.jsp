<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
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
<title>Insert title here</title>
</head>
<body>
	
	<form action="/message/messageRemove/received/${emp_no}" method="post" class="messageForm">
	<input type="button" value="쪽지쓰기" onclick="fn_messageRegist()">
	<input type="button" value="보낸쪽지" onclick="fn_sendedmessageList()">
	<input type="submit" value="삭제">
	
	<table width="600">
	
		<tr>
			<th width="50">선택</th>
			<th width="110">보낸사람</th>
			<th width="330">내용</th>
			<th width="110">날짜</th>
		</tr>
		
		<c:forEach var="messageVO" items="${list}">
		
			<tr>
				
				<%-- <td><input type="hidden" name="message_no" value="${messageVO.message_no }"></td> --%>
				<td width="50"><input type="checkbox" name="message_no" class="message_no" value="${messageVO.message_no}"></td>
				<td width="110">${messageVO.message_sender_name }</td>
				<td width="330">${messageVO.message_contents }</td>
				<td width="110">${messageVO.message_senddate }</td>
			</tr>
		</c:forEach>
		</table>
		</form>
		
		
	
</body>
</html>