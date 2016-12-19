<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
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
<script>
	$(document).ready(
			function() {

				$('#searchBtn').on(
						"click",
						function(event) {

							self.location = "list"
									+ '${pageMaker.makeQuery(1)}'
									+ "&searchType="
									+ $("select option:selected").val()
									+ "&keyword=" + $('#keywordInput').val();

						});

				$('#newBtn').on("click", function(evt) {

					self.location = "regist";

				}); 

			});
</script>
</head>
<body>
	<br><br>                        
	<h1>게시판</h1>
	<br><br>   
	<form action="list">
	<input type="hidden" value="${category_no }" name="category_no">
		<div class='box-body'>
			<div class="col-xs-2">
				<select name="searchType" class="form-control">
					<option  value="n"
						<c:out value="${cri.searchType == null?'selected':''}"/>>
						---</option>
					<option value="t"
						<c:out value="${cri.searchType eq 't'?'selected':''}"/>>
						Title</option>
					<option value="c"
						<c:out value="${cri.searchType eq 'c'?'selected':''}"/>>
						Content</option>
					<option value="tc"
						<c:out value="${cri.searchType eq 'tc'?'selected':''}"/>>
						Title OR Content</option>
				</select> 
			</div>
			<div class="col-xs-2">
				<input type="text" name='keyword' id="keywordInput" value='${cri.keyword }' class="form-control">
			</div>
			<div class="col-xs-2">
				<button id='searchBtn' class="btn btn-default">검색</button>
			</div>
		</div>
	</form>	
	  
	<form action="regist" method="get">
	<input type="hidden" value="${category_no }" name="category_no">
	<br><br><br>
	<table class="table table-bordered table-hover">
		<tr height="30">
			<td width="50" align="center">NO</td>
			<td width="300" align="center">제목</td>
			<td width="250" align="center">작성자</td>
			<td width="150" align="center">등록일</td>
			<td width="100" align="center">조회수</td>
		</tr>
		<c:forEach items="${list}" var="boardVO">

			<tr>
				<td>${boardVO.board_no}</td>
				<td><a href='/board/read${pageMaker.makeSearch(pageMaker.cri.page) }&board_no=${boardVO.board_no}&category_no=${category_no}'>
						${boardVO.board_title} </a></td>
				<td><input type="hidden" value="${emp_no }">${emp_name}</td>
				<td><fmt:formatDate pattern="yyyy-MM-dd HH:mm"
						value="${boardVO.board_regdate}" /></td>
				<td><span class="badge bg-red">${boardVO.board_hit }</span></td>
			</tr>

		</c:forEach>
	</table>
	<button id='newBtn' class="btn btn-default">게시글 작성</button>
	<!-- 페이징처리 -->
	<div class="box-footer">

		<div class="text-center">
			<ul class="pagination">

				<c:if test="${pageMaker.prev}">
					<li><a
						href="list${pageMaker.makeSearch(pageMaker.startPage - 1) }&category_no=${category_no}">&laquo;</a></li>
				</c:if>

				<c:forEach begin="${pageMaker.startPage }"
					end="${pageMaker.endPage }" var="idx">
					<li
						<c:out value="${pageMaker.cri.page == idx?'class =active':''}"/>>
						<a href="list${pageMaker.makeSearch(idx)}&category_no=${category_no}">${idx}</a>
					</li>
				</c:forEach>

				<c:if test="${pageMaker.next && pageMaker.endPage > 0}">
					<li><a
						href="list${pageMaker.makeSearch(pageMaker.endPage +1) }&category_no=${category_no}">&raquo;</a></li>
				</c:if>

			</ul>
		</div>

	</div>
	</form>	
</body>
</html>