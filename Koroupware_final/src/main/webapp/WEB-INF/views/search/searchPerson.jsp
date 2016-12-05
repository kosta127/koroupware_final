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
					<h2>${login.emp_no}</h2>
					<h3 class="box-title">검색 결과</h3>
				</div>
			</div>
		</div>


		<div class="box">
			<div class="box-header with-border">
				<h3 class="box-title">사원 리스트</h3>
			</div>
			<div class="box-body">
				<table class="table table-bordered" border='2' align='center'>
					<tr>
						<th style="width: 10px">사원번호</th>
						<th>이름</th>
						<th>부서이름</th>
						<th>아이디</th>
						<th>이메일</th>
						<th>주소</th>
						<th>입사일</th>
					</tr>

					<c:forEach items="${searchResult}" var="searchResult">

						<tr>
							<td>${searchResult.emp_no}</td>
							<td><a href='/board/read?bno=${searchResult.emp_no}'>${searchResult.emp_name}</a></td>
							<td>${searchResult.dept_name}</td>
							<td>${searchResult.emp_id}</td>
							<td>${searchResult.emp_email}</td>
							<td>${searchResult.emp_address}</td>
							<td>${searchResult.emp_hiredate}</td>
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
								href="searchPerson${pageMaker.makeSearch(pageMaker.startPage - 1) }">&laquo;</a></li>
						</c:if>

						<c:forEach begin="${pageMaker.startPage }"
							end="${pageMaker.endPage }" var="idx">
							<li
								<c:out value="${pageMaker.cri.page == idx?'class =active':''}"/>>
								<a href="searchPerson${pageMaker.makeSearch(idx)}">${idx}</a>
							</li>
						</c:forEach>

						<c:if test="${pageMaker.next && pageMaker.endPage > 0}">
							<li><a
								href="searchPerson${pageMaker.makeSearch(pageMaker.endPage +1) }">&raquo;</a></li>
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