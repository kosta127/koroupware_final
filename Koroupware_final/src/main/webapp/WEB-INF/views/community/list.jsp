<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
<!-- <script type="text/javascript">
$(document).ready(function(){
	$("#createCommunity").on('click', function(e){
		self.location="regist";
	});
});
</script> -->
</head>
<body>
<h1>커뮤니티</h1>
<input type="hidden" value="${emp.emp_no}" name="emp_no" id="emp_no"/> 
<button id="createCommunity">커뮤니티 생성</button>
<ul id="communities">
	<c:forEach items="${list }" var="communityVO">	
		<div class="community_name">			
			<div><a href="../category/list?community_no=${communityVO.community_no}">${communityVO.community_name}</a></div>
		</div>
	</c:forEach>
</ul>

</body>
</html>