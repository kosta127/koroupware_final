<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<link href="css/bootstrap.min.css" rel="stylesheet">
<script type="text/javascript" src="js/jquery.js"></script>
<script type="text/javascript" src="printTool/jQuery.print.js"></script>
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
				prepend : "�μ� �̸�����",
				//Add this on bottom
				append : new Date() + "<br>KoroupWare���� ����Ͽ����ϴ�."
			});
		});
	});
</script>
<title>Insert title here</title>
</head>
<body>

	<table class="table table-bordered" id="tabel1" border=1 width=60%>
		<tr>
			<td width=15%>��������</td>
			<td width=30%>${elec_authDetail.doc_title }</td>
			<td width=15%>���縶����</td>
			<td width=30%>${elec_authDetail.elec_auth_enddate }</td>
		</tr>
		<tr>
			<td>������ȣ</td>
			<td>${elec_authDetail.elec_auth_no }</td>
			<td>�ۼ�����</td>
			<td>${elec_authDetail.elec_auth_regdate }</td>
		</tr>
		<tr>
			<td>�ۼ���</td>
			<td>${elec_authDetail.emp_name }</td>
			<td>��������</td>
			<td>${elec_authDetail.elec_auth_con_period }</td>
		</tr>
	</table>
	
	<br> <br>

		<table class="table table-bordered" id="table2" border=1 width=60%>
			<tr>
				<td width=15%></td>
				<c:forEach var="a" items="${elec_authDetailApproval }">
					<td width=85%>${a.office_name }</td>
				</c:forEach>
			</tr>
			<tr>
				<td>����</td>
				<c:forEach var="b" items="${elec_authDetailApproval }">
					<td>${b.approval_list_pass }</td>
				</c:forEach>
			</tr>
			<tr>
				<td>������</td>
				<td><c:forEach var="d" items="${elec_authDetailReferrer }">
				${d.dept_name}: ${d.emp_name }/ </c:forEach></td>
		</table>
		<br> <br>

		<h3>���Է�</h3>
		<table class="table table-bordered" id="table3" border=1 width=60%>
			<tr>
				<td width=15%>����</td>
				<td width=85%>${elec_authDetail.elec_auth_title }</td>
			</tr>
			<tr>
				<td>����</td>
				<td>${elec_authDetail.elec_auth_contents }</td>
		</table>
		<br> <br>
		
		<h3>@���� ���� ���� �� �ǰ�</h3>
		<table class="table table-bordered" id="table4" border=1 width=60%>
			<tr>
				<th width=25%>�з�</th>
				<th width=25%>�����ڸ�</th>
				<th width=25%>�����Ͻ�</th>
				<th width=25%>����</th>
			</tr>
			<c:forEach var="c" items="${elec_authDetailApproval }">
				<tr>
					<td><c:if test="${elec_authDetail.emp_no==c.emp_no }">�����</c:if>
						<c:if test="${elec_authDetail.emp_no!=c.emp_no }">������</c:if></td>
					<td>${c.emp_name }</td>
					<td>${c.approval_list_date }</td>
					<td>${c.approval_list_pass }</td>
				</tr>
			</c:forEach>
		</table><br>
		
		<input id="printButton" type="button" class="btn btn-success" name="print2" value="�μ�">	
	
</body>
</html>