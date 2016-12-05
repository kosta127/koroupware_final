<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script type="text/javascript">
function fn_messageRegist(){
	location.href="/message/messageRegist/"+${emp_no};
}

function fn_receivedmessageList(){
	location.href="/message/receivedmessageList/"+${emp_no};
}
</script>
<title>Insert title here</title>
</head>
<body>
	<form action="/message/messageRemove/sended/${emp_no}" method="post" class="messageForm">
	<input type="button" value="쪽지쓰기" onclick="fn_messageRegist()">
	<input type="button" value="받은쪽지" onclick="fn_receivedmessageList()">
	<input type="submit" value="삭제">
	<table width="600">
		<tr>
			<th width="30">선택</th>
			<th width="110">받는사람</th>
			<th width="350">내용</th>
			<th width="110">날짜</th>
		</tr>
		<c:forEach var="messageVO" items="${list }">
			<tr>
				<%-- <td width="30"><input type="hidden" name="message_no" value="${messageVO.message_no }"></td> --%>
				<td width="50"><input type="checkbox" name="message_no" class="message_no" value="${messageVO.message_no}"></td>
				<td width="110">${messageVO.message_receiver_name }</td>
				<td width="350">${messageVO.message_contents }</td>
				<td width="110">${messageVO.message_senddate }</td>
			</tr>
		</c:forEach>
		
	</table>
	</form>
</body>
</html>