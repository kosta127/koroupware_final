<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<script type="text/javascript">

</script>
<body>
<h1>인사평가</h1>
<div class="col-md-6">
		<form action="/estimate/attendCount/" method="post">
			<div class="col-md-12 header-est-div">
				<div class="col-md-4 header-est">
					<span class="header-est-span">출석 인사평가</span><br>
					<select name="keyField">
					<option value="dept_1">1부서</option>
					<option value="dept_2">2부서</option>
					<option value="dept_3">3부서</option>
					<option value="dept_4">4부서</option>
					<option value="dept_5">5부서</option>
				</select>
				</div>
				<div class="col-md-2">
				<input type="submit" value="출석 평가">
				</div>
			</div>
				</form>
		</div>
		
<div class="col-md-6">
		<form action="/estimate/lateCount/" method="post">
			<div class="col-md-12 header-est-div">
				<div class="col-md-4 header-est">
					<span class="header-est-span">지각 인사평가</span><br>
					<select name="keyField">
					<option value="dept_1">1부서</option>
					<option value="dept_2">2부서</option>
					<option value="dept_3">3부서</option>
					<option value="dept_4">4부서</option>
					<option value="dept_5">5부서</option>
				</select>
				</div>
				<div class="col-md-2">
				<input type="submit" value="지각 평가">
				</div>
			</div>
				</form>
		</div>

<div class="col-md-6">
		<form action="/estimate/specialCount/" method="post">
			<div class="col-md-12 header-est-div">
				<div class="col-md-4 header-est">
					<span class="header-est-span">특근 인사평가</span><br>
					<select name="keyField">
					<option value="dept_1">1부서</option>
					<option value="dept_2">2부서</option>
					<option value="dept_3">3부서</option>
					<option value="dept_4">4부서</option>
					<option value="dept_5">5부서</option>
				</select>
				</div>
				<div class="col-md-2">
				<input type="submit" value="특근 평가">
				</div>
			</div>
				</form>
		</div>

<div class="col-md-6">
		<form action="/estimate/totalCount/" method="post">
			<div class="col-md-12 header-est-div">
				<div class="col-md-4 header-est">
					<span class="header-est-span">총합 인사평가</span><br>
					<select name="keyField">
					<option value="dept_1">1부서</option>
					<option value="dept_2">2부서</option>
					<option value="dept_3">3부서</option>
					<option value="dept_4">4부서</option>
					<option value="dept_5">5부서</option>
				</select>
				</div>
				<div class="col-md-2">
				<input type="submit" value="종합 평가">
				</div>
			</div>
				</form>
		</div>								
</body>
</html>