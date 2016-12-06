<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
<script type="text/javascript">
$(document).ready(function(){
	$("#createCommunity").on('click', function(e){
		self.location="regist";
	});
});

$('#communities').on('click', '.atag', function() {
	$(this).val()
});
</script>
<style type="text/css">
@import url(http://fonts.googleapis.com/earlyaccess/notosanskr.css);
 .community-list-div{
  padding-top: 5px;
  height : 50px;
  border-radius:15px;
  box-shadow: 2px 2px 2px 2px lightgray; 
  font-size: 20px;
  text-align: center;
  text-decoration: none;
 }
 li{
  list-style: none;
 }
 
 .atag{
    font-family: 'Noto Sans KR', sans-serif; 
   font-size: 30px;

 } 
 #community_name{
    margin-right: 20px;
 }
 
 .com-name:hover, #community_name:hover{
 background-color: #fef763;
 cursor: default;
  text-decoration: none;
  }
 
</style>
</head>
<body>
<h1>커뮤니티</h1>

<form action="regist">
	<input type="hidden" value="${emp.emp_no}" name="emp_no" id="emp_no"/> 
	<button id="createCommunity" class="btn btn-default" style="color: #43A047">커뮤니티 생성</button>
	<ul id="communities">
		<c:forEach items="${list }" var="communityVO">	
			<div id="community_name" class="nav-sidebar community-list-div col-md-5">			
				<li class="atag"><a class="com-name" href="../category/list?community_no=${communityVO.community_no}">${communityVO.community_name}</a></li>
			</div>
		</c:forEach>
		
	</ul>
</form>
</body>
</html>