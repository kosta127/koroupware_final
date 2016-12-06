<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd" class="form-control">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<!-- bootstrap 3.3.2 -->
<link href="/resources/bootstrap-3.3.2-dist/css/bootstrap.min.css"
   rel="stylesheet">
<script src="/resources/bootstrap-3.3.2-dist/js/bootstrap.min.js"></script>
</head>
<style>
 .margin_top{
 	margin-top: 10px;
 }
</style>
<body>
<h1>인사평가</h1>
<div class="col-md-6">
		<form action="/estimate/attendCount/" method="post">
			<div class="col-md-12 header-est-div">
				<div class="col-md-4 header-est">
				
					<select name="keyField" class="form-control">
					<option value="dept_1">개발부서</option>
					<option value="dept_2">영업부서</option>
					<option value="dept_3">판매부서</option>
					<option value="dept_4">총무부서</option>
				</select>
				</div>
				<div class="col-md-2">
				<input type="submit" class="btn btn-primary" value="출석 평가">
				</div>
			</div>
				</form>
		</div>

		
<div class="col-md-6">
		<form action="/estimate/lateCount/" method="post">
			<div class="col-md-12 header-est-div">
				<div class="col-md-4 header-est">
					
					<select name="keyField" class="form-control">
					<option value="dept_1">개발부서</option>
					<option value="dept_2">영업부서</option>
					<option value="dept_3">판매부서</option>
					<option value="dept_4">총무부서</option>
				</select>
				</div>
				<div class="col-md-2">
				<input type="submit" class="btn btn-primary" value="지각 평가">
				</div>
			</div>
				</form>
		</div>
	

<div class="col-md-6 margin_top">
		<form action="/estimate/specialCount/" method="post">
			<div class="col-md-12 header-est-div">
				<div class="col-md-4 header-est">
					
					<select name="keyField" class="form-control">
					<option value="dept_1">개발부서</option>
					<option value="dept_2">영업부서</option>
					<option value="dept_3">판매부서</option>
					<option value="dept_4">총무부서</option>
				</select>
				</div>
				<div class="col-md-2">
				<input type="submit" class="btn btn-primary" value="특근 평가">
				</div>
			</div>
				</form>
		</div>
	

<div class="col-md-6 margin_top">
		<form action="/estimate/totalCount/" method="post">
			<div class="col-md-12 header-est-div">
				<div class="col-md-4 header-est">
					
					<select name="keyField" class="form-control">
					<option value="dept_1">개발부서</option>
					<option value="dept_2">영업부서</option>
					<option value="dept_3">판매부서</option>
					<option value="dept_4">총무부서</option>
				</select>
				</div>
				<div class="col-md-2">
				<input type="submit" class="btn btn-primary" value="종합 평가">
				</div>
			</div>
				</form>
		</div>		
					
</body>
</html>