<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ page session="false"%>


<!-- Main content -->
<section class="content">
	<div class="row">
		<!-- left column -->
		<div class="col-md-12">
			<!-- general form elements -->

			<div class="box">
				<div class="box-header with-border">
					<h3 class="box-title">LIST ALL PAGE</h3>
				</div>
				<div class="box-body">
				
<table class="table table-bordered">
	<tr>
		<th style="width: 10px">사원번호</th>
		<th>이름</th>
		<th>부서이름</th>
		<th>아이디</th>
		<th>이메일</th>
		<th>주소</th>
		<th>입사일</th>
	</tr>

<c:forEach items="${searchResult}" var="Search">

	<tr>
		<td>${searchResult.emp_no}</td>
		<td><a href='/board/read?bno=${searchResult.emp_no}'>${searchResult.emp_name}</a></td>
		<td>${searchResult.dept_name}</td>
		<td><fmt:formatDate pattern="yyyy-MM-dd HH:mm"
				value="${searchResult.emp_hiredate}" /></td>
		<td>${searchResult.emp_email}</td>
		<td>${searchResult.emp_address}</td>
	</tr>


</c:forEach>

</table>

				</div>
				<!-- /.box-body -->
				<div class="box-footer">Footer</div>
				<!-- /.box-footer-->
			</div>
		</div>
		<!--/.col (left) -->

	</div>
	<!-- /.row -->
</section>
<!-- /.content -->
</div>
<!-- /.content-wrapper -->

<script>
    
    var result = '${msg}';
    
    if(result == 'SUCCESS'){
    	alert("처리가 완료되었습니다.");
    }
    
    </script>

