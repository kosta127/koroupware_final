<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
<style type="text/css">
@import url(http://fonts.googleapis.com/earlyaccess/notosanskr.css);
.category-list-div{
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
#category_name{
	margin-right: 20px;
}
.com-name:hover, #category_name:hover{
 background-color: #fef763;
 cursor: default;
  text-decoration: none;
  }
</style>
</head>

<body>
	<h1>카테고리</h1>
	<form action="regist" method="get">
	<input type="hidden" value="${community_no }" name="community_no">
	<button id="createCategory" class="btn btn-default" style="color: #F9A825"><b>카테고리 생성</b></button>
	<ul id="categories">
		<c:forEach items="${list }" var="categoryVO">	
			<div id="category_name" class="nav-sidebar category-list-div col-md-5">
				<li class="atag"><a class="com-name" href="../board/list?category_no=${categoryVO.category_no }">${categoryVO.category_name}</a></li>
			</div>
		</c:forEach>
	</ul>
	</form>

</body>
</html>