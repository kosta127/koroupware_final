<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<section class="content">
	<div class="row">
		<!-- left column -->


		<div class="col-md-12">
			<!-- general form elements -->
			<div class='box'>
				<div class="box-header with-border">
					<h3 class="box-title">검색 결과</h3>
				</div>


				<form action="/search/search" method="post">
					<div class="col-xs-2">
						<select name="keyField" class="form-control select">
							<option value="emp_name">사원</option>
							<option value="document">문서</option>
						</select>
					</div>
					<div class="col-xs-5">
						<input type="text" name="search_content" class="form-control">
					</div>
					<input type="submit" value="검색" class="btn btn-primary">
				</form>
			</div>
		<div class="box">
			<div class="box-header with-border">
				<h3 class="box-title">문서 리스트</h3>
			</div>
			<div class="box-body">
				<table class="table table-bordered" border='2' align='center'>
					<tr>
						<th style="width: 10px">문서번호</th>
						<th>문서 이름</th>
						<th>문서내용</th>
						<th>문서 생성시기</th>
						<th>작성자</th>
					</tr>

					<c:forEach items="${searchResult}" var="searchResult">

						<tr>
							<td>${searchResult.doc_no}</td>
							<td><a href='/board/read?bno=${searchResult.doc_no}'>${searchResult.doc_title}</a></td>
							<td>${searchResult.doc_contents}</td>
							<td>${searchResult.doc_con_period}</td>
							<td><a href='/board/read?bno=${searchResult.emp_no}'>${searchResult.emp_name}</a></td>
						</tr>

					</c:forEach>

				</table>
			</div>
			<!-- /.box-body -->


			<div class="box-footer">

				<div class="text-center">
					<ul class="pagination">

						<c:if test="${pageMaker.prev}">
							<li><a
								href="searchDoc${pageMaker.makeSearch(pageMaker.startPage - 1) }">&laquo;</a></li>
						</c:if>

						<c:forEach begin="${pageMaker.startPage }"
							end="${pageMaker.endPage }" var="idx">
							<li
								<c:out value="${pageMaker.cri.page == idx?'class =active':''}"/>>
								<a href="searchDoc${pageMaker.makeSearch(idx)}">${idx}</a>
							</li>
						</c:forEach>

						<c:if test="${pageMaker.next && pageMaker.endPage > 0}">
							<li><a
								href="searchDoc${pageMaker.makeSearch(pageMaker.endPage +1) }">&raquo;</a></li>
						</c:if>

					</ul>
				</div>

			</div>
			<!-- /.box-footer-->
		</div>
	</div>
	<!--/.col (left) -->

	</div>
	<!-- /.row --> </section>
</body>
</html>