<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<table width="600">
		<tr>
			<th width="30">선택</th>
			<th width="110">보낸사람</th>
			<th width="350">내용</th>
			<th width="110">날짜</th>
		</tr>
		<c:forEach var="messageVO" items="${list}">
			<tr>
				<td width="30"><input type="hidden" name="message_no" value="${messageVO.message_no }"></td>
				<td width="110">${messageVO.message_sender_name }</td>
				<td width="350">${messageVO.message_contents }</td>
				<td width="110">${messageVO.message_senddate }</td>
			</tr>
		</c:forEach>
		
	</table>
</body>
</html>