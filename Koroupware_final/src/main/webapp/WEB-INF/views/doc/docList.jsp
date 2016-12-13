<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<!-- jquery -->
<script src="/resources/jquery-1.9.1/jquery-1.9.1.min.js"></script>
<!-- jquery-ui -->
<link href="/resources/jquery-ui-1.12.1/jquery-ui.min.css"
	rel="stylesheet">
<script src="/resources/jquery-ui-1.12.1/jquery-ui.min.js"></script>
<!-- bootstrap 3.3.2 -->
<link href="/resources/bootstrap-3.3.2-dist/css/bootstrap.min.css"
	rel="stylesheet">
<script src="/resources/bootstrap-3.3.2-dist/js/bootstrap.min.js"></script>
<!--  -->
<link
	href='https://fonts.googleapis.com/css?family=Product+Sans:400,400i,700,700i'
	rel='stylesheet' type='text/css'>
<script src="/resources/js/docList.js"></script>
<title>Insert title here</title>
<style type="text/css"> 
.blank {
	height: 50px;
}
table{
	margin-top: 10px;
}
</style>
</head>
<body>	
	<br>
	<br>
	<div>
		<form id="doc_list_info">
			<input type="hidden" id="doc_box_no" name="doc_box_no"
				value="${doc_box_no}"> <input type="hidden" id="emp_no"
				name="emp_no" value="${emp_no}">
		</form>
		<ul id="doc_box_list" class="nav nav-tabs">
			<li id="box_li_all" value="0"><a href="#">문서 전체 목록</a></li>
			<c:forEach var="docbox" items="${boxlist }">
				<li id="box_li_${docbox.doc_box_no }" value="${docbox.doc_box_no }"><a
					href="#">${docbox.doc_box_name }</a></li>
			</c:forEach>
			<li id="box_li_add"><a href="/doc/doc_boxRegist"><b>+</b></a></li>
		</ul>
		<form action="/doc/doc_managementRegist/${doc_box_no}/${emp_no}"
			method="post">
			<table id="checklist" class="table table-hover">
				<thead>
					<tr height="30">
						<th>선택</th>
						<th>No</th>
						<th>문서명</th>
						<th>양식여부</th>
						<th>보존년한</th>
						<th></th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="doc" items="${list}">
						<c:if test="${doc.doc_deldate == null }">
							<tr>
								<td><input type="checkbox" name="doc_no"
									value="${doc.doc_no}"></td>
								<td>${doc.doc_no }</td>
								<td><a
									href="/doc/docRead/${doc.doc_no}/${doc_box_no}/${emp_no}">${doc.doc_title }</a></td>
								<td><c:choose>
										<c:when test="${doc.doc_formYN == 'Y'}">Y</c:when>
										<c:otherwise>N</c:otherwise>
									</c:choose> 
								</td>
								<td><fmt:formatDate value="${doc.doc_con_period }" pattern="yyyy-MM-dd"/></td>
								<td><a
									href="/doc/docRemove/${doc.doc_no}/${doc_box_no}/${emp_no}">삭제</a></td>
							</tr>
						</c:if>
					</c:forEach>
				</tbody>
			</table>
			
			<c:if test="${doc_box_no!=null }">
				<input type="submit" id="add_doc_into_box_btn" value="문서함에 문서 추가" class="btn btn-default">
				<input type="button" id="add_doc_btn" value="문서등록" class="btn btn-default"> 
				<input type="button" id="list_his_btn" value="문서수정이력보기"
					class="btn btn-default"> 
			</c:if>
				<!-- <input
				type="button" value="돌아가기" class="btn btn-default"
				onclick="fn_detailDoc_box()"> -->
		</form>
	</div>






</body>
</html>
