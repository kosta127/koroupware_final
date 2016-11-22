<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fun" uri="http://java.sun.com/jsp/jstl/functions"%>	
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
<script type="text/javascript">
	function community_create() {
		location.href = "insertCommunity";
	}
</script>
</head>
<body>
	<ul>
		<li><a href="listDoc_box.do">문서</a></li>
		<li><a>결재</a></li>
		<li><a href="listCommunity.do">커뮤니티</a>
			<ul>
				<c:forEach var="communityList" items="${communityList }">
					<li><a
						href="listCategory?community_no=${communityList.community_no }">${communityList.community_name}</a>
						<%-- <c:forEach var="categoryList" items="${categoryList }">	
							<ul>
								<li><a href="list.jsp?category_no=${categoryList.category_no}">${categoryList.category_name}</a></li>
							</ul>
						</c:forEach> --%> <a
						href="insertCategoryForm?community_no=${communityList.community_no}">+</a>
					</li>

				</c:forEach>
				<%-- <c:forEach var="categoryList" items="${categoryList }">
					<ul>
						<li><a
							href="listBoard?category_no=${categoryList.category_no}">${categoryList.category_name}</a></li>
					</ul>
				</c:forEach> --%>
			</ul></li>
		<li><a>조직도</a></li>
		<li><a href="messagePage.do">쪽지</a></li>
	</ul>
</body>
</html>