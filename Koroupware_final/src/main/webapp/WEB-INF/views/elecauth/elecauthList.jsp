 <%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
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
<script src="/resources/js/elecauthList.js"></script>
<link href="/resources/css/elecauthList.css" rel="stylesheet">
<title>Insert title here</title>
</head>
<body>
	<form id="flag_form">
		<input type="hidden" id="kind" name="kind" value="${kind }">
		<input type="hidden" id="receive" name="receive" value="${receive }">
	</form>
	<br>
	<div class="col-md-12">
		<div class="elecauthList">
			<ul id="elecauth_list" class="nav nav-tabs">
				<li id="receive_li"><a href="#">내가 받은 결재</a></li>
				<li id="write_li"><a href="#">내가 보낸 결재</a></li>
			</ul>
			<div id="category_list">
				<div id="receive_list" class="left-top-padding">
					<ul id="receive_ul" class="nav nav-pills">
						<li><a href="wait/ok">결재대기중인 결재</a></li>
						<li><a href="ing/ok">진행중인 결재</a></li>
						<li><a href="done/ok">완료된 결재</a></li>
						<li><a href="ret/ok">부결/반려한 결재</a></li>
					</ul>
				</div>
				<div id="write_list" class="left-padding">
					<ul id="write_ul" class="nav nav-pills">
						<li><a href="ing/no">진행중인 결재</a></li>
						<li><a href="done/no">완료된 결재</a></li>
						<li><a href="ret/no">부결/반려된 결재</a></li>
						<li><a href="temp/no">임시저장 결재</a></li>
					</ul>
				</div>
			</div>

			<table class="table table-bordered table-hover">
				<thead>
					<tr>
						<th>문서번호</th>
						<th>문서종류</th>
						<th>제목</th>
						<th>관리부서</th>
						<th>기안자</th>
						<th>기안일</th>
						<th>결재 마감일</th>
						<th>결재 단계</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="i" items="${elecauthList }">
						<tr>
							<td>${i.elec_auth_no }</td>
							<td>${i.doc_title}</td>
							<td><a href="elecauthRead?elec_auth_no=${i.elec_auth_no}">
									${i.elec_auth_title }</a></td>
							<td>${i.dept_name }</td>
							<td>${i.emp_name }</td>
							<td>${i.elec_auth_regdate }</td>
							<td>${i.elec_auth_enddate }</td>
							<td>${i.approval_list_pass }</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
		<input type="button" id="write" class="btn btn-primary pull-right"
			value="결재작성">
	</div>
</body>
</html>