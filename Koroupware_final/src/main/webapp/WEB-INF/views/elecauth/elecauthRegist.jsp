<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<!-- jquery -->
<script src="/resources/jquery-1.9.1/jquery-1.9.1.min.js"></script>
<!-- jquery-ui -->
<link href="/resources/jquery-ui-1.12.1/jquery-ui.min.css" rel="stylesheet">
<script src="/resources/jquery-ui-1.12.1/jquery-ui.min.js"></script>
<!-- bootstrap 3.3.2 -->
<link href="/resources/bootstrap-3.3.2-dist/css/bootstrap.min.css" rel="stylesheet">
<link href="/resources/bootstrap-3.3.2-dist/css/bootstrap-theme.min.css" rel="stylesheet">
<script src="/resources/bootstrap-3.3.2-dist/js/bootstrap.min.js"></script>
<!-- validation -->
<script src="/resources/validation/jquery.validate.min.js"></script>
<script src="/resources/validation/additional-methods.min.js"></script>
<script src="/resources/validation/messages_ko.min.js"></script>
<!-- ckeditor -->
<script src="/resources/ckeditor/ckeditor.js"></script>
<!-- mine -->
<link href="/resources/css/elecauthRegist.css" rel="stylesheet">
<script src="/resources/js/elecauthRegist.js"></script>

<title>전자결재 - 결재 작성</title>
</head>
<body>
	<div class="container">
		<div class="page-header">
			<h3>결재작성</h3>
		</div>
		<form id="elec_auth_form" action="/elecauth/regist/0" method="post" class="form-horizontal">
			<!-- 작성자 -->
			<div id="emp_div" class="form-group">
				<label for="emp_name" class="col-xs-2 col-lg-2 control-label">안건 작성자</label> 
				<div class="col-xs-10 col-lg-10">
					<input type="text" name="emp_name" id="emp_name" value="${empDetail.emp_name }" readonly="readonly" class="form-control">
					<input type="hidden" name="emp_no" id="emp_no" value="${empDetail.emp_no }">
				</div>
			</div>
			<!-- 관리부서 -->
			<div id="manage_dept_div" class="form-group">
				<label for="management_dept_name" class="col-xs-2 col-lg-2 control-label">관리 부서</label>
				<div class="col-xs-10 col-lg-10">
					<input type="text" name="elec_auth_management_dept_name" id="elec_auth_management_dept_name" value="${empDetail.dept_name }" readonly="readonly" class="form-control">
					<input type="hidden" name="elec_auth_management_dept_no" id="elec_auth_management_dept_no" value="${empDetail.dept_no }">
				</div>
			</div>
			<!-- 문서 양식 -->
			<div id="docform_div" class="form-group">
				<label for="docFormList" class="col-xs-2 col-lg-2 control-label">문서 양식 선택</label>
				<div class="col-xs-10 col-lg-10">
					<select id="docFormList" name="doc_no" class="form-control">
						<option value="" disabled="disabled" selected="selected">양식을 선택하세요</option>
						<c:forEach var="doc" items="${docFormList }">
							<option value="${doc.doc_no }">${doc.doc_title }</option>						
						</c:forEach>
					</select>
				</div>
				<c:forEach var="doc" items="${docFormList }">
					<div class="hidden_div" id="hidden_docform_div_${doc.doc_no }">${doc.doc_contents }</div>
				</c:forEach>
			</div>
			<!-- 결재마감일 -->
			<div id="enddate_div" class="form-group" >
				<label for="elec_auth_enddate" class="col-xs-2 col-lg-2 control-label">결재 마감일</label>
				<div class="col-xs-10 col-lg-10">
					<input type="text" name="elec_auth_enddate" id="elec_auth_enddate" readonly="readonly" 
							class="form-control" placeholder="결재 마감일을 설정해주세요">
				</div>
			</div>
			<!-- 보존년한 -->
			<div id="conperiod_div" class="form-group">
				<label for="elec_auth_con_period" class="col-xs-2 col-lg-2 control-label">보존년한</label>
				<div class="col-xs-10 col-lg-10">
					<select name="elec_auth_con_period" id="elec_auth_con_period" class="form-control">
						<c:forEach var="i" begin="1" end="10">
							<option value="${i }">${i }년</option>
						</c:forEach>
					</select>
				</div>
			</div>
			<!-- 안건제목 -->
			<div id="title_div" class="form-group">
				<label for="elec_auth_title" class="col-xs-2 col-lg-2 control-label">안건 제목</label>
				<div class="col-xs-10 col-lg-10">
					<input type="text" name="elec_auth_title" id="elec_auth_title" class="form-control" placeholder="제목을 입력해주세요">
				</div>
			</div>
			<!-- 내용 -->
			<div id="contents_div" class="form-group">
				<textarea name="elec_auth_contents" id="elec_auth_contents" class="form-control"></textarea>
			</div>
			<!-- 결재자 -->
			<div id="approval_div" class="form-group">
				<label for="elec_auth_approval" class="col-xs-2 col-lg-2 control-label">결재자</label>
				<div class="col-xs-10 col-lg-10">
					<input type="text" name="elec_auth_approval" id="elec_auth_approval" class="form-control" placeholder="이름으로 검색">
				</div>
				<label for="elec_auth_approval_list" class="col-xs-2 col-lg-2 control-label">결재자 목록</label>
				<ul id="elec_auth_approval_list" class="col-xs-10 col-lg-10">
				</ul>
			</div>
			<!-- 참조자 -->
			<div id="referrer_div" class="form-group">
				<label for="elec_auth_referrer" class="col-xs-2 col-lg-2 control-label">참조자</label>
				<div class="col-xs-10 col-lg-10">
					<input type="text" name="elec_auth_referrer" id="elec_auth_referrer" class="form-control" placeholder="이름으로 검색">
				</div>
				<label for="elec_auth_referrer_list" class="col-xs-2 col-lg-2 control-label">참조자 목록</label>
				<ul id="elec_auth_referrer_list" class="col-xs-10 col-lg-10">			
				</ul>
			</div>
			<!-- 버튼 -->
			<div id="btn_div" class="form-group pull-right">
				<input type="button" value="임시저장" id="elec_auth_temp_save" class="btn btn-info">
				<input type="submit" value="제출하기" class="btn btn-primary">
				<input type="button" value="취소" id="elec_auth_cancel" class="btn btn-warning">
			</div>
		</form>		
	</div>
</body>
</html>