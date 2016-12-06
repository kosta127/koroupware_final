<%@page import="java.sql.Date"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
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
<!-- printTool -->
<script src="/resources/printTool/jQuery.print.js"></script>
<script src="/resources/js/elecauthPrint.js"></script>
<script src="/resources/js/elecauthRead.js"></script>

<title>Insert title here</title>
</head>
<body>

	<br>

	<input type="hidden" name="elec_auth_no"
		value=${elecauthRead.elec_auth_no }>
	<input type="hidden" name="emp_no" value=${login.emp_no }>

	<table class="table table-bordered" id="tabel1" border=1 width=60%>
		<tr>
			<td width=15%>��������</td>
			<td width=30%>${elecauthRead.doc_title }</td>
			<td width=15%>���縶����</td>
			<td width=30%>${elecauthRead.elec_auth_enddate }</td>
		</tr>
		<tr>
			<td>������ȣ</td>
			<td>${elecauthRead.elec_auth_no }</td>
			<td>�ۼ�����</td>
			<td>${elecauthRead.elec_auth_regdate }</td>
		</tr>
		<tr>
			<td>�ۼ���</td>
			<td>${elecauthRead.emp_name }</td>
			<td>��������</td>
			<td>${elecauthRead.elec_auth_con_period }</td>
		</tr>
	</table>
	<br>
	<br>

	<h3>���Է�</h3>
	<table class="table table-bordered" id="table3" border=1 width=60%>
		<tr>
			<td width=15%>����</td>
			<td width=85%>${elecauthRead.elec_auth_title }</td>
		</tr>
		<tr>
			<td>����</td>
			<td>${elecauthRead.elec_auth_contents }</td>
	</table>
	<br>

	<jsp:useBean id="now" class="java.util.Date" />
	<fmt:formatDate value="${now}" pattern="yyyy-MM-dd a hh:mm" var="today" /> 

	<c:if test="${login.emp_no != elecauthRead.emp_no}">
		<c:forEach var="c" items="${elecauthReadApproval }">
			<c:if test="${c.approval_list_pass ==null }">
			<c:if test="${login.emp_no==c.emp_no }">
			<c:if test="${elecauthRead.elec_auth_enddate>now}">
				<form action="elecauthOkReport">
					<input type="hidden" name="emp_no" value="${c.emp_no }">
					<input type="hidden" name="elec_auth_no" value="${elecauthRead.elec_auth_no }">
					<div>
						<input type="submit" class="btn btn-info" value="����">
					</div>				
				</form>	
				<form action="elecauthNoReport">
					<input type="hidden" name="emp_no" value="${c.emp_no }">
					<input type="hidden" name="elec_auth_no" value="${elecauthRead.elec_auth_no }">
					<div>
						<input type="submit" class="btn btn-danger" value="�ź�">	
					</div>				
				</form>	
			</c:if>				
			</c:if>
			</c:if>
		</c:forEach>		
	</c:if>

	<c:if test="${login.emp_no== elecauthRead.emp_no}">
		<form action="elecauthDelete">
			<input type="hidden" name="elec_auth_no" value=${elecauthRead.elec_auth_no }>
			 <input type="hidden" name="emp_no" value=${login.emp_no }> 
			 <input type="submit" class="btn btn-warning" value="����">
		</form>
	</c:if>
	<br>

	<h3>@���� ���� ����</h3>
	<table class="table table-bordered" id="table4" border=1 width=60%>
		<tr>
			<th width=20%>�з�</th>
			<th width=20%>����</th>
			<th width=20%>�����ڸ�</th>
			<th width=20%>�����Ͻ�</th>
			<th width=20%>����</th>
		</tr>
		<c:forEach var="c" items="${elecauthReadApproval }">
			<tr>
				<td><c:if test="${elecauthRead.emp_no==c.emp_no }">�����</c:if> <c:if
						test="${elecauthRead.emp_no!=c.emp_no }">������</c:if></td>
				<td>${c.office_name }</td>
				<td>${c.emp_name }</td>
				<td>${c.approval_list_date }</td>
				<td>${c.approval_list_pass }</td>
			</tr>
		</c:forEach>
	</table>
	<br>

	<h3>@������</h3>
	<table class="table table-bordered" id="table5" border=1 width=60%>
		<tr>
			<th width=33%>�з�</th>
			<th width=33%>������ �μ�</th>
			<th width=33%>�����ڸ�</th>
		</tr>
		<c:forEach var="d" items="${elecauthReadReferrer }">
			<tr>
				<td>������</td>
				<td>${d.dept_name}</td>
				<td>${d.emp_name }</td>
			</tr>
		</c:forEach>
	</table> 

	<input id="printButton" type="button" class="btn btn-success"
		name="print2" value="�μ�">

</body>
</html>