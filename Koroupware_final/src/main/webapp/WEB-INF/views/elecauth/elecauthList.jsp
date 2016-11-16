<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<div class="elecauthList">
				<div class="page-header">
					<h3>���繮�� ���</h3>
				</div>
				<table border="1" class="table table-bordered table-hover">
					<thead>
						<tr>
							<th>������ȣ</th>
							<th>��������</th>
							<th>����</th>
							<th>�����μ�</th>
							<th>�����</th>
							<th>�����</th>
							<th>���� ������</th>
							<th>���� �ܰ�</th>
						</tr>
					</thead> 
					<tbody>
						<c:forEach var="i" items="${elecauthList }">
							<tr>
								<td>${i.elec_auth_no }</td>
								<td>${i.doc_title}</td>
								<td><a href="elec_authDetail.do?elec_auth_no=${i.elec_auth_no}">${i.elec_auth_title }</a></td>
								<td> ${i.dept_name }</td>
								<td> ${i.emp_name }</td>
								<td>${i.elec_auth_regdate }</td>
								<td>${i.elec_auth_enddate }</td>
								<td>${i.approval_list_pass } </td>
							</tr>
						</c:forEach>
					</tbody>
				</table> 
			</div>
</body>
</html>