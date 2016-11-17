<%@page import="java.sql.Date"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
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
<script type="text/javascript">
	$(function() {
		$("input#printButton").on('click',function() {
			var nowDate = new Date();
			$("#printable").print({
				//Use Global styles
				globalStyles : true,
				//Add link with attrbute media=print
				mediaPrint : true,
				//Custom stylesheet
				stylesheet : "http://fonts.googleapis.com/css?family=Inconsolata",
				//Print in a hidden iframe
				iframe : true,
				//Don't print this
				noPrintSelector : ".avoid-this",
				//Add this at top
				prepend : "인쇄 미리보기",
				//Add this on bottom
				append : new Date() + "<br>KoroupWare에서 출력하였습니다."
			});
		});
		
	});
</script>
<title>Insert title here</title>
</head>
<body>

	<table class="table table-bordered" id="tabel1" border=1 width=60%>
		<tr>
			<td width=15%>문서종류</td>
			<td width=30%>${elecauthRead.doc_title }</td>
			<td width=15%>결재마감일</td>
			<td width=30%>${elecauthRead.elec_auth_enddate }</td>
		</tr>
		<tr>
			<td>문서번호</td>
			<td>${elecauthRead.elec_auth_no }</td>
			<td>작성일자</td>
			<td>${elecauthRead.elec_auth_regdate }</td>
		</tr>
		<tr>
			<td>작성자</td>
			<td>${elecauthRead.emp_name }</td>
			<td>보존년한</td>
			<td>${elecauthRead.elec_auth_con_period }</td>
		</tr>
	</table>
	
	<br> <br>

		<table class="table table-bordered" id="table2" border=1 width=60%>
			<tr>
				<td width=15%></td>
				<c:forEach var="a" items="${elecauthReadApproval }">
					<td width=85%>${a.office_name }</td>
				</c:forEach>
			</tr>
			<tr>
				<td>승인</td>
				<c:forEach var="b" items="${elecauthReadApproval }">
					<td>${b.approval_list_pass }</td>
				</c:forEach>
			</tr>			
			<tr>
				<td>참조자</td>
				<td><c:forEach var="d" items="${elecauthReadReferrer }">
				${d.dept_name}: ${d.emp_name }/ </c:forEach></td>
			</tr>
		</table>
		<br> <br>

		<h3>상세입력</h3>
		<table class="table table-bordered" id="table3" border=1 width=60%>
			<tr>
				<td width=15%>제목</td>
				<td width=85%>${elecauthRead.elec_auth_title }</td>
			</tr>
			<tr>
				<td>내용</td>
				<td>${elecauthRead.elec_auth_contents }</td>
		</table>
		<br> <br>
		
		<h3>@결재 진행 상태 및 의견</h3>
		<table class="table table-bordered" id="table4" border=1 width=60%>
			<tr>
				<th width=25%>분류</th>
				<th width=25%>결재자명</th>
				<th width=25%>결재일시</th>
				<th width=25%>상태</th>
			</tr>
			<c:forEach var="c" items="${elecauthReadApproval }">
				<tr>
					<td><c:if test="${elecauthRead.emp_no==c.emp_no }">기안자</c:if>
						<c:if test="${elecauthRead.emp_no!=c.emp_no }">결재자</c:if></td>
					<td>${c.emp_name }</td>
					<td>${c.approval_list_date }</td>
					<td>${c.approval_list_pass }</td>
				</tr>
			</c:forEach>
		</table><br>
		
		<input id="printButton" type="button" class="btn btn-success" name="print2" value="인쇄">	
	
</body>
</html>