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
<script type="text/javascript">
	$(function(){
		$("#write").on("click", function(){
			self.location="regist";
		});
	})
</script>
<title>Insert title here</title>
</head>
<body>
	<div class="container">
		<div class="col-md-2">
			<div id="elec_auth_box">
				<div class="panel panel-default">
					<div class="panel-heading">
						<h3 class="panel-title">
							<a href="elec_authList.do">내가 올린 결재</a>
						</h3>
					</div>
					<div class="panel-body">
						<ul id="write_list" class="nav nav-pills nav-stacked">
							<li><a href="elec_authList.do?">진행중인 결재</a></li>
							<li><a href="elec_authList.do?">완료된 결재</a></li>
							<li><a href="elec_authList.do?">부결/반려된 결재</a></li>
							<li><a href="elec_authList.do?">임시저장 결재</a></li>
						</ul>
					</div>
				</div>
				<div class="panel panel-default">
					<div class="panel-heading">
						<h3 class="panel-title">
							<a href="elec_authList.do?">내가 받은 결재</a>
						</h3>
					</div>
					<div class="panel-body">
						<ul id="receive_list" class="nav nav-pills nav-stacked">
							<li><a href="elec_authList.do?">결재대기중인
									결재</a></li>
							<li><a href="elec_authList.do?">진행중인
									결재</a></li>
							<li><a href="elec_authList.do?">완료된
									결재</a></li>
							<li><a href="elec_authList.do?">부결/반려한
									결재</a></li>
						</ul>
					</div>
				</div>
			</div>
		</div>

		<div class="col-md-10">
			<div class="elecauthList">
				<div class="page-header">
					<h3>결재문서 목록</h3>
				</div>
				<table border="1" class="table table-bordered table-hover">
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
			<input type="button" id="write" class="btn btn-primary pull-right" value="결재작성">
		</div>
	</div>
</body>
</html>